/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sagar.freectionary.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SAGAR MAHOBIA
 */
@RestController()
public class ApiController {

    @GetMapping("/api/v1/")
    public String appName() {
        return "Freectionary Application Root";
    }

    @GetMapping("/api/v1/dictionary/{word_id}")
    public String getDictionary(@PathVariable("word_id") Integer wordId) {
        return "dictionary at " + wordId;
    }

}
