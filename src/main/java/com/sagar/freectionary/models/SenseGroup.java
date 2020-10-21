package com.sagar.freectionary.models;

import com.sagar.freectionary.enums.PartsOfSpeechType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by SAGAR MAHOBIA on 28-Jul-18. at 00:30
 */


@Getter
@Setter
public class SenseGroup {

    private PartsOfSpeechType posType;
    private String word;

    private List<String> morphs;
    private List<Sense> senses;

    public void setPosType(int posTypeId) {
        this.posType = PartsOfSpeechType.getPartOfSpeechById(posTypeId);
    }
}
