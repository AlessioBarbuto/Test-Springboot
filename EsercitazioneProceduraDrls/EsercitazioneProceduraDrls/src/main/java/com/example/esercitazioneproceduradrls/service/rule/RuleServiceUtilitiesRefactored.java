package com.example.esercitazioneproceduradrls.service.rule;

import com.example.esercitazioneproceduradrls.model.Condition;
import com.example.esercitazioneproceduradrls.model.Expression;
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

        String str = IntStream.range(0, quantity)
                .boxed()
                .map(a -> tabulation)
                .collect(Collectors.joining(""));
        inputString = inputString.concat(str);

        return inputString;
    }

    /** Given input "Condition" , transforms it into a String -> name, operator, expression
     * @param condition
     * @return
     */
    public String buildCondition(Condition condition){
        String stringCondition = condition.getName()+" "
                +condition.getOperator()+" "
                +condition.getExpression();

        return stringCondition;
    }

    /** Given input "Expression" , transforms it into a String -> type, name, operator, expression
     * @param expression
     * @return
     */
    public String buildExpression(Expression expression){
        String stringExpression = expression.getType()+" "
                +expression.getName()+" "
                +expression.getOperator()+" "
                +expression.getExpression();

        return stringExpression;
    }

}
