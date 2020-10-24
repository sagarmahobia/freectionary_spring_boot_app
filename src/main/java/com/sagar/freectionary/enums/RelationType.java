package com.sagar.freectionary.enums;

import lombok.Getter;

/**
 * Created by SAGAR MAHOBIA on 29-Jul-18. at 21:01
 */
@Getter
public enum RelationType {
    Antonyms("Antonyms", 1),
    Derivation("Derived words", 2),
    SeeAlso("See also", 3),
    Similar("Similar Words", 4),
    Usage("Usages", 5),
    Synonyms("Synonyms", 6),//warning above 5 are reserved
    Other("", 0);
    private final String name;
    private final int id;
    private static final RelationType[] types;

    static {
        types = RelationType.values();
    }

    RelationType(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public static RelationType getRelationTypeById(int id) {
        for (RelationType relationType : types) {
            if (relationType.getId() == id) {
                return relationType;
            }
        }
        return Other;
    }
}
