package com.sagar.freectionary.models;

import java.util.Objects;

/**
 * Created by SAGAR MAHOBIA on 25-Jul-18. at 16:28
 */
public class Word implements Comparable<Word> {

    private String word;
    private int wordId;

    public String getWord() {
        return word;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof Word)) {
            return false;
        }
        Word word = (Word) o;
        return this.word.equals(word.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.word);
    }

    @Override
    public int compareTo(Word word) {
        return this.word.compareToIgnoreCase(word.getWord());

    }
}
