package com.sagar.freectionary.models;

import com.sagar.freectionary.enums.RelationType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAGAR MAHOBIA on 28-Jul-18. at 00:43
 */


@Getter
@Setter
public class Relation {

    private RelationType relationType;
    private List<Word> words;

    public Relation() {
        words = new ArrayList<>();
    }

    public void setName(int relationTypeId) {
        this.relationType = RelationType.getRelationTypeById(relationTypeId);
    }

}
