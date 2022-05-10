package com.example.esercitazioneproceduradrls.service.rule;

import com.example.esercitazioneproceduradrls.model.Rule;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PutControlServiceRefactored {

 Logger log = LoggerFactory.getLogger(PutControlServiceRefactored.class);


 /**
  * This method generate the rule.
  * @param id
  * @param type
  * @param rules
  * @return
  */
 public Rule run(String id, String type, List<Rule> rules){

  makeImports();
  //makeRule();
  setDialect();
  makeWhen();
  makeThen();

  rules.stream().forEach(el ->log.info("regola: "+ el.toString()));


  return null;

 }


 /**
  * Given a Json file, extract "import" parameters and write imports in the rule
  */
 public List<String> makeImports(){
  log.info("started make imports");
  List<String> importList = Arrays.asList("import org.pwc.innovate.drools_4_tit.*;",
          ("import org.pwc.innovate.drools_4_tit.*;"));
  return importList;
 }

 /**
  * Given a Json file, extract "rule" parameters and give a name to the rule
  */
 public void makeRule(Rule rule){
  log.info("started make rule");
 }

 /**
  * Given a Json file, extract "dialect" parameter and set the dialect of the rule
  */
 public void setDialect(){
  log.info("started set dialect");
 }

 /**
  * create when section
  */
 public void makeWhen(){
  log.info("started exute when");
 }

 /**
  * create then section
  */
 public void makeThen(){
  log.info("started execute then");

 }

}
