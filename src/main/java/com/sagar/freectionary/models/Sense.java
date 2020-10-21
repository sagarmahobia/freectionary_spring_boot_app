package com.sagar.freectionary.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

/**
 * Created by SAGAR MAHOBIA on 28-Jul-18. at 00:41
 */


@Getter
@Setter
public class Sense {

    private String definition;
    private String example;

    private List<Index> definitionIndices;
    private List<Index> exampleIndices;

    private List<Relation> relations;


}
