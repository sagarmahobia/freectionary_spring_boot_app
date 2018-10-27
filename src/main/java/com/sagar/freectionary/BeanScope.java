/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sagar.freectionary;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author SAGAR MAHOBIA
 */
public class BeanScope {

    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public @interface Singleton {

    }

    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public @interface Prototype {

    }

    public static final String PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;
    public static final String SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

}
