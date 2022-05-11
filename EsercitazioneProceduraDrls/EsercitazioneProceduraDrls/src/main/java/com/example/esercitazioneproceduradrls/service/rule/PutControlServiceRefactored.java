package com.example.esercitazioneproceduradrls.service.rule;

import com.example.esercitazioneproceduradrls.model.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class PutControlServiceRefactored {

 Logger log = LoggerFactory.getLogger(PutControlServiceRefactored.class);
 RuleServiceUtilitiesRefactored ruleService = new RuleServiceUtilitiesRefactored();


 /**
  * This method generate the rule.
  * @param rules
  * @return
  */
 public Rule run(String id, String type, List<Rule> rules){

  rules.forEach(el ->log.info("regola: "+ el.toString()));
  //rules.forEach(this::createRule);

  return null;

 }


 /**
  * Given a Json file, extract "import" parameters and write imports in the rule
  */
 public List<String> makeImports(){
  log.info("started make imports");
  List<String> importList = Arrays.asList("import org.pwc.innovate.drools_4_tit.*;","import org.pwc.innovate.drools_4_tit.*;");

  return importList;
 }


 /**
  * Given a Json file, extract "rule" parameters and give a name to the rule
  */
 public String makeRule(Rule rule){
  log.info("started make rule");
  String ruleName = "rule: \""+rule.getName()+"\"";
  ruleService.addTabulationOrNewLine(ruleName, 1, "\n");

  return ruleName;
  }


 /**
  * Given a Json file, extract "dialect" parameter and set the dialect of the rule
  */
 public String setDialect(Rule rule){
  log.info("started set dialect");
  String dialect = "dialect: \""+rule.getDialect()+"\"";
  ruleService.addTabulationOrNewLine(dialect, 1, "\n");

  return dialect;
 }


 /**
  * Create the when section. Given an input rule, streams it and return a list of conditions that are
  * parsed into Strings.
  * @param rule
  * @return
  */
 public List<String> makeWhen(Rule rule){
  log.info("started execute when");

  /*List<Function> whenConditions = rule.getWhen().stream()
          .map(Condition::getFunction)
          .collect(Collectors.toList());

  List<String> conditions = whenConditions.stream()
          .map(condition -> condition.getName().concat(condition.getOperator()).concat(condition.getExpression()))
          .collect(Collectors.toList());

  return conditions;*/
  return null;
 }


 /**
  * Create the when section. Given an input rule, streams it and return a list of conditions that are
  * parsed into Strings.
  * @param rule
  * @return
  */
  public List<String> makeThen(Rule rule){
  log.info("started execute then");

  return null;
 }

 /**
  * method that execute the creation of rule parts, that are returned as Lists concatenated
  * @param rule
  * @return
  */
 private List<String> createRule(Rule rule) {

  List<String> importList = makeImports();
  String ruleName = makeRule(rule);
  String dialect = setDialect(rule);
  List<String> whenList = makeWhen(rule);
  List<String> thenList = makeThen(rule);

  List<String> newList = concatLists(importList, ruleName, dialect, whenList, thenList);
  return newList;
 }


 /**Given many input lists, execute a concatenation
  * @return
  */
 private List<String> concatLists(List<String> importList, String ruleName, String dialect, List<String> whenList, List<String> thenList) {
  List<String> newList = new ArrayList<String>();
  newList.addAll(importList);
  newList.add(ruleName);
  newList.add(dialect);
  newList.addAll(whenList);
  newList.addAll(thenList);
  return newList;
 }


}
