package com.example.esercitazioneproceduradrls.service.rule;


import com.example.esercitazioneproceduradrls.model.Condition;
import com.example.esercitazioneproceduradrls.model.Expression;
import com.example.esercitazioneproceduradrls.model.Function;
import com.example.esercitazioneproceduradrls.model.Rule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
class PutControlServiceRefactoredTest {

    PutControlServiceRefactored controlService = new PutControlServiceRefactored();

    @Test
    void makeImports() {
        List<String> importList = Arrays.asList("import org.pwc.innovate.drools_4_tit.*;",
                ("import org.pwc.innovate.drools_4_tit.*;"));

        List<String> anotherList = importList.stream()
                .map(x -> x+"xxxxxxxxx")
                .collect(Collectors.toList());

        anotherList.forEach(System.out::println);

    }

    @Test
    void makeRuleTest() {
        Rule rule = new Rule();
        rule.setName("prova");

        String result = controlService.makeRule(rule);
        log.info("result: "+result);
        Assertions.assertEquals(result,"rule: \"prova\"" );

    }


    @Test
    void makeWhenTest() {
        Rule rule = new Rule();
        List<Condition> conditions = List.of(new Condition("nome","==","espressione"),
                new Condition("nome","==","espressione"));
        List<Function> when = List.of(new Function("nome",":","nomeFunzione",conditions));
        rule.setWhen(when);

        String result = "nome : nomeFunzione(nome == espressione)";
        log.info("result: "+result);

        Assertions.assertEquals(result, controlService.makeWhen(rule).toString());
    }

    @Test
    void makeThenTest() {
        Rule rule = new Rule();
        List<Expression> then = List.of(new Expression("tipo","nome","==", "espressione"));
        rule.setThen(then);

        String result = "tipo nome == espressione";
        log.info("result: "+result);

        Assertions.assertEquals(result, controlService.makeThen(rule).toString());
    }
}