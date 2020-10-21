package com.sagar.freectionary.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Created by SAGAR MAHOBIA on 25-Jul-18. at 16:28
 */


@Getter
@Setter
public class Word implements Comparable<Word> {

    private String word;
    private int wordId;

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
