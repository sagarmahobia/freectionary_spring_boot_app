package com.sagar.freectionary.repository;

/**
 * Created by SAGAR MAHOBIA on 29-Jul-18. at 18:59
 */
interface SqlStrings {

    String FOR_SENSE_GROUPS = "SELECT sg.sensegroupid, sg.posid, w.lemma, cw.cased FROM sensegroups sg INNER JOIN words w "
            + " ON sg.wordid = w.wordid "
            + " LEFT JOIN casedwords cw "
            + " ON sg.casedwordid = cw.casedwordid "
            + " WHERE sg.wordid = ? ORDER BY sg.sensegroupid ASC ";

    String FOR_MORPHS = "SELECT m.morph FROM sensegroupmorph sgm INNER JOIN morphs m "
            + " ON sgm.morphid = m.morphid "
            + " WHERE sgm.sensegroupid = ? GROUP BY m.morph ORDER BY m.morph ASC ";

    String FOR_SENSES = "SELECT s.senseid , s.synsetid, sys.definition, smp.sampleset FROM senses s INNER JOIN synsets sys "
            + " ON s.synsetid = sys.synsetid "
            + " LEFT JOIN samplesets smp "
            + " ON s.synsetid = smp.synsetid "
            + " WHERE s.sensegroupid =  ? ORDER BY s.senseid ASC";

    String FOR_SYNSET_INDICES = "SELECT s.wordid, s.indexstart, s.indexend FROM idxsynsets s where synsetId = ? order by s.indexstart";
    String FOR_SAMPLESET_INDICES = "SELECT s.wordid, s.indexstart, s.indexend FROM idxsamplesets s where synsetId = ? order by s.indexstart";

    String FOR_RELATION = "SELECT r.wordid, w.lemma, r.relationtypeid FROM relations r INNER JOIN words w "
            + " ON r.wordid = w.wordid"
            + " WHERE  r.senseid = ? ORDER BY r.relationtypeid ASC, r.wordid ASC";

    String FOR_SYNONYMS = "SELECT w.wordid,w.lemma,cw.cased FROM synonyms synn	INNER JOIN words w "
            + " ON synn.wordid = w.wordid "
            + " LEFT JOIN casedwords cw "
            + " ON synn.casedwordid = w.wordid "
            + " WHERE synn.senseid = ? ORDER BY w.wordid ASC";

}
