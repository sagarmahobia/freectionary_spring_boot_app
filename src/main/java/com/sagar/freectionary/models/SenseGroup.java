package com.sagar.freectionary.models;

import com.sagar.freectionary.enums.PartsOfSpeechType;
import java.util.List;

/**
 * Created by SAGAR MAHOBIA on 28-Jul-18. at 00:30
 */
public class SenseGroup {

    private PartsOfSpeechType posType;
    private String word;

    private List<String> morphs;
    private List<Sense> senses;

    public PartsOfSpeechType getPosType() {
        return posType;
    }

    public void setPosType(int posTypeId) {
        this.posType = PartsOfSpeechType.getPartOfSpeechById(posTypeId);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getMorphs() {
        return morphs;
    }

    public void setMorphs(List<String> morphs) {
        this.morphs = morphs;
    }

    public List<Sense> getSenses() {
        return senses;
    }

    public void setSenses(List<Sense> senses) {
        this.senses = senses;
    }


}
