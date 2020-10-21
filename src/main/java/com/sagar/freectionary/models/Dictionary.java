package com.sagar.freectionary.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

/**
 * Created by SAGAR MAHOBIA on 28-Jul-18. at 00:30
 */

@Getter
@Setter
public class Dictionary {

    private String word;

    private List<SenseGroup> senseGroups;

}
