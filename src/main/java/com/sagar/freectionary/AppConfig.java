/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sagar.freectionary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author SAGAR MAHOBIA
 */
@Configuration
public class AppConfig {

    private final ApplicationContext applicationContext;

    public AppConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

}
