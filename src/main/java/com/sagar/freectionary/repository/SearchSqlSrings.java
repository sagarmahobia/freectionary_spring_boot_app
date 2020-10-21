package com.sagar.freectionary.repository;

public interface SearchSqlSrings {
    /* FIND ONE */

    String FOR_WORDID_WORDS = "SELECT wordid FROM words WHERE lemma = ? ";


    String FOR_WORDID_MORPH = "SELECT morphmaps.wordid FROM morphmaps " +
            "LEFT JOIN morphs USING(morphid) " +
            "WHERE morphs.morph = ? ";

    String FOR_GETTING_WORDID_FROM_XWORD
            = "SELECT  `wordid` FROM `xwords` WHERE  `refword` = ?";


    /* SEARCH */

    String SQL_FOR_CASED_SEARCH_LIST = "SELECT w.lemma , w.wordid , csl.cased " +
            "FROM words w " +
            "LEFT JOIN casedsearchlist csl USING(wordid) " +
            "WHERE w.lemma LIKE ? " +
            "ORDER BY w.lemma ASC " +
            "LIMIT 100";

    String FOR_XWORD = "SELECT `refword`, `wordid` FROM `xwords` WHERE" +
            " refword LIKE ? ORDER BY `xwords`.`refword` ASC LIMIT 100";

    String FOR_MORPH = "SELECT DISTINCT `morphs`.`morph`, `morphmaps`.`wordid` FROM" +
            " `morphs` LEFT JOIN `morphmaps`" +
            " ON `morphs`.`morphid` = `morphmaps`.`morphid`" +
            " WHERE `morphs`.`morph` LIKE ?" +
            " LIMIT 100";

}
