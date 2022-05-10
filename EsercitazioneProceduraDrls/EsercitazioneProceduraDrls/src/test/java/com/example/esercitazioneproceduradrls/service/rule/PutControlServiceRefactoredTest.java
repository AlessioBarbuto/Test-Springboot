package com.example.esercitazioneproceduradrls.service.rule;

import com.example.esercitazioneproceduradrls.model.Rule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

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
    void setDialectTest() {
    }
}