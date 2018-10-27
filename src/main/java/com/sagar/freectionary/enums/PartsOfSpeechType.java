/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sagar.freectionary.enums;

/**
 * @author SAGAR
 */
public enum PartsOfSpeechType {

    Adjective("Adjective", 1),
    Adverb("Adverb", 2),
    Conjunction("Conjunction", 3),
    Interjection("Interjection", 4),
    Noun("Noun", 5),
    Preposition("Preposition", 6),
    Pronoun("Pronoun", 7),
    Verb("Verb", 8);
    private final String name;
    private final int id;
    private static final PartsOfSpeechType[] types;

    static {
        types = PartsOfSpeechType.values();
    }

    PartsOfSpeechType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static PartsOfSpeechType getPartOfSpeechById(int id) {
        for (PartsOfSpeechType partsOfSpeechType : types) {
            if (partsOfSpeechType.getId() == id) {
                return partsOfSpeechType;
            }
        }
        return null;
    }
}
