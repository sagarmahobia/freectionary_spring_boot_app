package com.sagar.freectionary.models;

import java.util.List;
import org.springframework.lang.NonNull;

/**
 * Created by SAGAR MAHOBIA on 28-Jul-18. at 00:30
 */
public class Dictionary {

    private String word;

    private List<SenseGroup> senseGroups;

    @NonNull
    public List<SenseGroup> getSenseGroups() {
        return senseGroups;
    }

    public void setSenseGroups(@NonNull List<SenseGroup> senseGroups) {
        this.senseGroups = senseGroups;
    }

    @NonNull
    public String getWord() {
        return word;
    }

    public void setWord(@NonNull String word) {
        this.word = word;
    }
}
