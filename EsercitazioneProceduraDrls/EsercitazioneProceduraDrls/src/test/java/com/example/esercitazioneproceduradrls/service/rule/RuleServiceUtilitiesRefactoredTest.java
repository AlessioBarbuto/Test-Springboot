package com.example.esercitazioneproceduradrls.service.rule;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@Slf4j
class RuleServiceUtilitiesRefactoredTest {
    RuleServiceUtilitiesRefactored ruleService = new RuleServiceUtilitiesRefactored();

    @Test
    public void testMethod(){
        Integer number = 2;
        String separator = "t";
        String test = "stringa di test";

        String result = ruleService.addTabulationOrNewLine(test,number,separator);
        log.info("result: "+result);
        Assertions.assertEquals(result, "stringa di test"+separator+separator);
    }

}