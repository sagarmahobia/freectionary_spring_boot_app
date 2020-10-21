/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sagar.freectionary.api;

import com.sagar.freectionary.models.Dictionary;
import com.sagar.freectionary.models.Word;
import com.sagar.freectionary.repository.DictionaryRepository;
import com.sagar.freectionary.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author SAGAR MAHOBIA
 */

@CrossOrigin("*")
@RestController()
public class ApiController {

    @Autowired
    DictionaryRepository repository;

    @Autowired
    SearchRepository searchRepository;

    @GetMapping("/api/v1/search")
    public List<Word> query(@Param("q") String q) {
        return searchRepository.searchByQuerySingle(q);
    }

    @GetMapping("/api/v1/dictionary/{word_id}")
    public Dictionary getDictionary(@PathVariable("word_id") Integer wordId) {
        return repository.getDictionary(wordId);
    }



}
