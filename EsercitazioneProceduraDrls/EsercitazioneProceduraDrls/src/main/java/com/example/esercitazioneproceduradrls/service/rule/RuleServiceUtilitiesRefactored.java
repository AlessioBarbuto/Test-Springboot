package com.example.esercitazioneproceduradrls.service.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class RuleServiceUtilitiesRefactored {

    /**
     * Insert a new tabulation
     * @param inputString
     * @return
     */
    public String addTabulationOrNewLine(String inputString, Integer quantity, String tabulation){

        String test = "stringa di test";

        String str = IntStream.range(0, quantity)
                .boxed()
                .map(a -> tabulation)
                .collect(Collectors.joining(""));
        inputString = inputString.concat(str);

        return inputString;
    }

}
