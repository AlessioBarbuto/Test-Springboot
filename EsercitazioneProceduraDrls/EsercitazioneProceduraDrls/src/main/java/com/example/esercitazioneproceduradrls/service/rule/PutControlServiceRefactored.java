package com.example.esercitazioneproceduradrls.service.rule;

import com.example.esercitazioneproceduradrls.model.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class PutControlServiceRefactored {

 Logger log = LoggerFactory.getLogger(PutControlServiceRefactored.class);
 RuleServiceUtilitiesRefactored ruleService = new RuleServiceUtilitiesRefactored();


 /**
  * This method generate the rule.
  * @param rules
  * @return
  */
 public String run(String id, String type, List<Rule> rules){

  rules.forEach(el ->log.info("regola: "+ el.toString()));
  List<List<String>> stringRule = rules.stream()
          .map(this::createRule)
          .collect(Collectors.toList());

  log.info("Regola in Stringhe: "+stringRule.toString());
  String result = removeBrackets.apply(stringRule.toString());

  return result;
 }


 /**
  * Given a Json file, extract "import" parameters and write imports in the rule
  */
 public List<String> makeImports(){
  log.info("executing imports");
  List<String> importList = Arrays.asList("import org.pwc.innovate.drools_4_tit.*;","import org.pwc.innovate.drools_4_tit.*;");

  return importList;
 }


 /**
  * Given a Json file, extract "rule" parameters and give a name to the rule
  */
 public String makeRule(Rule rule){
  log.info("executing rule");
  String ruleName = "rule: \""+rule.getName()+"\"";
  ruleService.addTabulationOrNewLine(ruleName, 1, "\\n");

  return ruleName;
  }


 /**
  * Given a Json file, extract "dialect" parameter and set the dialect of the rule
  */
 public String makeDialect(Rule rule){
  log.info("executing dialect");
  String dialect = "dialect: \""+rule.getDialect()+"\"";
  ruleService.addTabulationOrNewLine(dialect, 1, "\\n");

  return dialect;
 }


 /**
  * Create the when section. Given an input rule, streams it and return a list of conditions that are
  * parsed into Strings.
  * @param rule
  * @return
  */
 public List<String> makeWhen(Rule rule){
  log.info("executing when");
  List<String> when = rule.getWhen().stream()
          .map(function -> ruleService.buildFunction(function))
          .collect(Collectors.toList());

  return when;
 }


 /**
  * Create the when section. Given an input rule, streams it and return a list of conditions that are
  * parsed into Strings.
  * @param rule
  * @return
  */
 public List<String> makeThen(Rule rule){
  log.info("executing then");
  List<String> then = rule.getThen().stream()
          .filter(Objects::nonNull)
          .map(expression -> ruleService.buildExpression(expression))
          .collect(Collectors.toList());

  return then;
 }


 /**
  * method that execute the creation of rule parts, that are returned as Lists concatenated
  * @param rule
  * @return
  */
 private List<String> createRule(Rule rule) {

  List<String> importList = makeImports();
  String ruleName = makeRule(rule);
  String dialect = makeDialect(rule);
  List<String> whenList = makeWhen(rule);
  List<String> thenList = makeThen(rule);

  List<String> newList = ruleService.concatLists(importList, ruleName, dialect, whenList, thenList);
  return newList;
 }


 /**
  * Function that eliminates brackets from a string
  */
 java.util.function.Function<String, String> removeBrackets = x -> x.replace("[", "")
         .replace("]", "");

}
