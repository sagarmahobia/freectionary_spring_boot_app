package com.sagar.freectionary.repository;

import com.sagar.freectionary.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static com.sagar.freectionary.repository.SearchSqlSrings.*;

@Repository()
public class SearchRepository {

    @Autowired
    JdbcTemplate database;

    public int getWordIdSingle(String query) {

        query = query.toLowerCase();
        int wordId;

        SqlRowSet cursor = database.queryForRowSet(SearchSqlSrings.FOR_WORDID_WORDS, query);

        cursor.first();
        wordId = cursor.getInt(1);

        if (wordId == -1) {
            cursor = database.queryForRowSet(FOR_WORDID_MORPH, query);
            cursor.first();
            wordId = cursor.getInt(1);

        }
        if (wordId == -1) {
            cursor = database.queryForRowSet(FOR_GETTING_WORDID_FROM_XWORD, query);
            cursor.first();
            wordId = cursor.getInt(1);
        }

        return wordId;

    }


    public List<Word> searchByQuerySingle(String query) {

        List<Word> words = new ArrayList<>(getCasedWords(query));

        if (words.size() < 100) {
            words.addAll(getXWords(query));
        }
        if (words.size() < 100) {
            words.addAll(getMorphs(query));
        }
        words = new ArrayList<>(new HashSet<>(words));

        Collections.sort(words);

        return words;
    }

    private List<Word> getCasedWords(String q) {
        List<Word> words = new ArrayList<>();

        SqlRowSet cursor = database.queryForRowSet(SQL_FOR_CASED_SEARCH_LIST, wrap(q));
        while (cursor.next()) {

            String lemma = cursor.getString(1);
            int wordId = cursor.getInt(2);
            String cased = cursor.getString(3);

            Word word = new Word();
            word.setWordId(wordId);

            if (cased != null) {
                word.setWord(cased);
            } else {
                word.setWord(lemma);
            }
            words.add(word);
        }


        return words;
    }

    private List<Word> getXWords(String q) {
        List<Word> words = new ArrayList<>();

        SqlRowSet cursor = database.queryForRowSet(FOR_XWORD, wrap(q));
        while (cursor.next()) {

            String refword = cursor.getString(1);
            int wordId = cursor.getInt(2);

            Word word = new Word();
            word.setWord(refword);
            word.setWordId(wordId);
            words.add(word);

        }
        return words;
    }

    private List<Word> getMorphs(String q) {
        List<Word> words = new ArrayList<>();

        SqlRowSet cursor = database.queryForRowSet(FOR_MORPH, wrap(q));
        while (cursor.next()) {

            String morph = cursor.getString(1);
            int wordId = cursor.getInt(2);

            Word word = new Word();
            word.setWord(morph);
            word.setWordId(wordId);
            words.add(word);

        }
        return words;
    }

    String wrap(String q) {
        return q + "%";
    }
}
