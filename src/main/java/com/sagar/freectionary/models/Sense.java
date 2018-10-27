package com.sagar.freectionary.models;

import java.util.List;
import org.springframework.lang.NonNull;

/**
 * Created by SAGAR MAHOBIA on 28-Jul-18. at 00:41
 */
public class Sense {

    private String definition;
    private String example;

    private List<Index> definitionIndices;
    private List<Index> exampleIndices;

    private List<Relation> relations;

    @NonNull
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @NonNull
    public List<Index> getDefinitionIndices() {
        return definitionIndices;
    }

    public void setDefinitionIndices(@NonNull List<Index> definitionIndices) {
        this.definitionIndices = definitionIndices;
    }

    @NonNull
    public List<Index> getExampleIndices() {
        return exampleIndices;
    }

    public void setExampleIndices(@NonNull List<Index> exampleIndices) {
        this.exampleIndices = exampleIndices;
    }

    @NonNull
    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(@NonNull List<Relation> relations) {
        this.relations = relations;
    }
}
