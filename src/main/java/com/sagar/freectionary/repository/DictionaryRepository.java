/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sagar.freectionary.repository;

import com.sagar.freectionary.enums.RelationType;
import com.sagar.freectionary.models.Dictionary;
import com.sagar.freectionary.models.Index;
import com.sagar.freectionary.models.Relation;
import com.sagar.freectionary.models.Sense;
import com.sagar.freectionary.models.SenseGroup;
import com.sagar.freectionary.models.Word;

import java.util.ArrayList;
import java.util.List;

import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

/**
 * @author SAGAR MAHOBIA
 */
@Repository()
public class DictionaryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Dictionary getDictionary(int wordId) {
        Dictionary dictionary = new Dictionary();
        List<SenseGroup> senseGroups = getSenseGroups(wordId);
        dictionary.setSenseGroups(senseGroups);
        dictionary.setWord(senseGroups.get(0).getWord());
        return dictionary;
    }

    private List<SenseGroup> getSenseGroups(int wordId) {

        List<SenseGroup> senseGroups = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SqlStrings.FOR_SENSE_GROUPS, wordId);

        while (rowSet.next()) {
            SenseGroup senseGroup = new SenseGroup();
            int senseGroupId = rowSet.getInt("sensegroupid");
            int posId = rowSet.getInt("posid");
            String lemma = rowSet.getString("lemma");
            String cased = rowSet.getString("cased");
            List<String> morphs = getMorphs(senseGroupId);
            List<Sense> senses = getSenses(senseGroupId);

            senseGroup.setPosType(posId);
            senseGroup.setMorphs(morphs);
            senseGroup.setSenses(senses);

            if (cased != null) {
                senseGroup.setWord(cased);
            } else {
                senseGroup.setWord(lemma);
            }
            senseGroups.add(senseGroup);
        }
        return senseGroups;
    }

    private List<String> getMorphs(int senseGroupId) {
        List<String> words = new ArrayList<>();

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SqlStrings.FOR_MORPHS, senseGroupId);
        while (rowSet.next()) {
            String morph = rowSet.getString("morph");
            words.add(morph);
        }

        return words;
    }

    private List<Sense> getSenses(int senseGroupId) {
        List<Sense> senses = new ArrayList<>();

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SqlStrings.FOR_SENSES, senseGroupId);
        while (rowSet.next()) {
            int senseId = rowSet.getInt("senseid");
            int synsetId = rowSet.getInt("synsetid");
            String definition = rowSet.getString("definition");
            String sampleset = rowSet.getString("sampleset");

            List<Index> synsetIndices = getSynsetIndices(synsetId);
            List<Index> sampleSetIndices = getSampleSetIndices(synsetId);

            List<Relation> relations = new ArrayList<>();
            Relation synonyms = getSynonyms(senseId);
            if (synonyms.getWords() != null && synonyms.getWords().size() > 0) {
                relations.add(synonyms);
            }
            relations.addAll(getRelations(senseId));

            Sense sense = new Sense();
            sense.setDefinition(definition);
            sense.setExample(sampleset);
            sense.setDefinitionIndices(synsetIndices);
            sense.setExampleIndices(sampleSetIndices);
            sense.setRelations(relations);

            senses.add(sense);
        }

        return senses;
    }

    private List<Relation> getRelations(int senseId) {

        List<Relation> relations = new ArrayList<>();

        int lastRelationTypeId = -1;
        Relation relation;
        List<Word> words = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SqlStrings.FOR_RELATION, senseId);
        while (rowSet.next()) {

            int wordId = rowSet.getInt("wordid");
            String lemma = rowSet.getString("lemma");
            int relationTypeId = rowSet.getInt("relationtypeid");

            if (lastRelationTypeId != relationTypeId) {
                lastRelationTypeId = relationTypeId;
                relation = new Relation();
                words = new ArrayList<>();
                relation.setName(relationTypeId);
                relation.setWords(words);
                relations.add(relation);
            }
            Word word = new Word();
            word.setWord(lemma);
            word.setWordId(wordId);
            words.add(word);
        }
        return relations;
    }

    private Relation getSynonyms(int senseId) {
        Relation synonyms = new Relation();
        synonyms.setName(RelationType.Synonyms.getId());

        List<Word> words = new ArrayList<>();

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SqlStrings.FOR_SYNONYMS, senseId);
        while (rowSet.next()) {

            int wordId = rowSet.getInt("wordid");
            String lemma = rowSet.getString("lemma");
            String cased = rowSet.getString("cased");
            Word word = new Word();
            word.setWordId(wordId);
            if (cased != null) {
                word.setWord(cased);
            } else {
                word.setWord(lemma);
            }
            words.add(word);

            synonyms.setWords(words);
        }
        return synonyms;
    }

    private List<Index> getSynsetIndices(int synsetId) {
        List<Index> indices = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SqlStrings.FOR_SYNSET_INDICES, synsetId);
        while (rowSet.next()) {

            int wordid = rowSet.getInt("wordid");
            int start = rowSet.getInt("indexstart");
            int end = rowSet.getInt("indexend");
            Index index = new Index();
            index.setWordId(wordid);
            index.setStart(start);
            index.setEnd(end);
            indices.add(index);
        }
        return indices;
    }

    private List<Index> getSampleSetIndices(int synsetId) {
        List<Index> indices = new ArrayList<>();

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(SqlStrings.FOR_SAMPLESET_INDICES, synsetId);

        while (rowSet.next()) {

            int wordid = rowSet.getInt("wordid");
            int start = rowSet.getInt("indexstart");
            int end = rowSet.getInt("indexend");
            Index index = new Index();
            index.setWordId(wordid);
            index.setStart(start);
            index.setEnd(end);

            indices.add(index);
        }
        return indices;
    }

}
