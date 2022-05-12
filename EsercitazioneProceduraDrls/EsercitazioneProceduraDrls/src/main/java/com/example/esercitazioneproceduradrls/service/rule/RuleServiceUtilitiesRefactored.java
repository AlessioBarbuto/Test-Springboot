package com.example.esercitazioneproceduradrls.service.rule;

import com.example.esercitazioneproceduradrls.model.Condition;
import com.example.esercitazioneproceduradrls.model.Expression;
import com.example.esercitazioneproceduradrls.model.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    public String buildCondition(Condition condition) {
        String stringCondition = condition.getName() + " "
                    + condition.getOperator() + " "
                    + condition.getFunction().toString();


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
        stringExpression = addTabulationOrNewLine(stringExpression,1,"\\n");

        return stringExpression;
    }

    /**
     * Assembly the function -> name, operator, functionName(conditions)
     * @param function
     * @return
     */
    public String buildFunction(Function function){

        List<String> conditions = function.getConditions().stream()
                .filter(Objects::nonNull)
                .map(this::buildCondition)
                .collect(Collectors.toList());

        String stringFunction = function.getName()+" "
                +function.getOperator()+" "
                +function.getFunctionName()+"("+conditions.toString()+")";
        stringFunction = addTabulationOrNewLine(stringFunction, 1, "\\n");

        return stringFunction;
    }

    /**Given many input lists (basically the components of the rule), execute a concatenation
     * and add the keywords when, then, end.
     * @return newList (A List of String that are the rows of the rule assembled)
     */
    public List<String> concatLists(List<String> importList, String ruleName, String dialect, List<String> whenList, List<String> thenList) {
        List<String> newList = new ArrayList<>();
        String whenKeyword = addTabulationOrNewLine("when", 2 , "\\n\\n\\t");
        String thenKeyword = addTabulationOrNewLine("then", 2 , "\\n\\n\\t");
        String endKeyword = addTabulationOrNewLine("end", 2 , "\\n\\n\\t");

        newList.addAll(importList);
        newList.add(ruleName);
        newList.add(dialect);
        newList.add(whenKeyword);
        newList.addAll(whenList);
        newList.add(thenKeyword);
        newList.addAll(thenList);
        newList.add(endKeyword);

        return newList;
    }


}
