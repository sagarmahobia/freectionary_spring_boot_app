package com.sagar.freectionary.models;

import com.sagar.freectionary.enums.RelationType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAGAR MAHOBIA on 28-Jul-18. at 00:43
 */
public class Relation {

    private RelationType relationType;
    private List<Word> words;

    public Relation() {
        words = new ArrayList<>();
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setName(int relationTypeId) {
        this.relationType = RelationType.getRelationTypeById(relationTypeId);
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
