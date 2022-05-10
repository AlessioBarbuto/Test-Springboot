package com.example.esercitazioneproceduradrls.service.rule;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PutControlServiceRefactoredTest {

    RuleServiceUtilitiesRefactored ruleService = new RuleServiceUtilitiesRefactored();

    @Test
    void makeImports() {
        List<String> importList = Arrays.asList("import org.pwc.innovate.drools_4_tit.*;",
                ("import org.pwc.innovate.drools_4_tit.*;"));

        List<String> anotherList = importList.stream()
                .map(x -> x+"xxxxxxxxx")
                .collect(Collectors.toList());

        anotherList.forEach(System.out::println);

    }
}