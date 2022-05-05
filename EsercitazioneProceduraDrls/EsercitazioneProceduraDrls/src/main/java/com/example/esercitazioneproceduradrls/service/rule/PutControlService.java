package com.example.esercitazioneproceduradrls.service.rule;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Slf4j
@Service
public class PutControlService {


    public String run(String id, String type, String body) throws SQLException, IOException {
        log.debug("putControl");
        log.debug("Looking for controls #" +id + " and type " + type);


        RuleServiceUtilities ruleServiceUtilities = new RuleServiceUtilities();
        ruleServiceUtilities.init();

        String control_text = "";

        JsonArray rules = JsonParser.parseString(body).getAsJsonArray();


        //TODO: Logica senza cicli
        //Step 1: Eliminare il codice scolpito, Step 2: Usare gli Stram, Step 3: Testare il codice a blocchi
        for(JsonElement iteratorR: rules) {
            funzione(iteratorR, body);
        }


        JsonObject message = new JsonObject();
        message.addProperty("code", "ok");
        message.addProperty("body", control_text);

        return message.toString();

    }


    public void funzione (JsonElement iteratorR, String body){

        String control_text = "";

        RuleServiceUtilities ruleServiceUtilities = new RuleServiceUtilities();
        ruleServiceUtilities.init();

        JsonArray rules = JsonParser.parseString(body).getAsJsonArray();
        List<String> imports = new ArrayList<>();

        JsonObject rule = iteratorR.getAsJsonObject();
        String single_rule = RuleServiceUtilities.control_template;

        single_rule = single_rule.replace("[RULE_NAME]", rule.get("name").getAsString());
        String single_rule_conditions = "";

        for(JsonElement iteratorC: rule.get("conditions").getAsJsonArray()) {
            JsonObject condition = iteratorC.getAsJsonObject();
            String single_instruction = condition.get("pattern").getAsString();
            single_instruction = single_instruction.replace("{NAME}", condition.get("name").getAsString());

            for(JsonElement iteratorP: condition.get("parameters").getAsJsonArray()) {
                JsonObject parameter = iteratorP.getAsJsonObject();
                String single_parameter = "";
                if(parameter.get("type").getAsString().equals(RuleServiceUtilities.vLIST_TYPE) || parameter.get("type").getAsString().equals(RuleServiceUtilities.vLIST_VALUE)) {
                    if(parameter.get("value").getAsString().equals(RuleServiceUtilities.vMANUAL)) {
                        single_parameter = single_parameter.replace(
                                "{"+ parameter.get("parameter").getAsString()+"}",
                                ruleServiceUtilities.generateOutputManual(parameter.get("manualValue").getAsString()));
                    } else {
                        if(parameter.get("type").getAsString().equals(RuleServiceUtilities.vLIST_TYPE)) {
                            single_parameter = single_parameter.replace(
                                    "{"+ parameter.get("parameter").getAsString()+"}",
                                    parameter.get("value").getAsString());
                        } else {
                            single_parameter = single_parameter.replace(
                                    "{"+ parameter.get("parameter").getAsString()+"}",
                                    ruleServiceUtilities.quotestring(parameter.get("value").getAsString()));
                        }
                        for(JsonElement singleValueTmp: parameter.get("values").getAsJsonArray()) {
                            JsonObject singleValue = singleValueTmp.getAsJsonObject();
                            if(singleValue.get("code").getAsString().equals(parameter.get("value").getAsString())) {
                                if(singleValue.has("import")) {
                                    if(!imports.contains(singleValue.get("import").getAsString())) {
                                        imports.add(singleValue.get("import").getAsString());
                                    }
                                }
                            }
                        }


                    }
                } else if(parameter.get("type").getAsString().equals(RuleServiceUtilities.vFREETEXT)) {
                    single_parameter = single_parameter.replace(
                            "{"+ parameter.get("parameter").getAsString()+"}",
                            ruleServiceUtilities.generateOutputManual(parameter.get("value").getAsString()));
                } else if(parameter.get("type").getAsString().equals(RuleServiceUtilities.vCALCTEXT)) {
                    single_parameter = single_parameter.replace(
                            "{"+ parameter.get("parameter").getAsString()+"}",
                            ruleServiceUtilities.generateFromCalcManual(parameter.get("value").getAsString()));
                }
                single_instruction = single_instruction.replace(
                        "{"+ parameter.get("parameter").getAsString() +"}", single_parameter);


            }
            single_instruction = single_instruction.replace(", , ", ", ");
            single_instruction = single_instruction.replace(", )", ")");
            single_rule_conditions = single_rule_conditions.concat(single_instruction);
            single_rule_conditions = single_rule_conditions.concat("\n\t");

            if(condition.has("import")) {
                if(!imports.contains(condition.get("import").getAsString())) {
                    imports.add(condition.get("import").getAsString());
                }
            }
        }

        String single_rule_outcomes = "";
        for(JsonElement iteratorC: rule.get("outcomes").getAsJsonArray()) {
            JsonObject outcome = iteratorC.getAsJsonObject();
            String single_instruction = outcome.get("pattern").getAsString();
            single_instruction = single_instruction.replace("{NAME}", outcome.get("name").getAsString());
            for(JsonElement iteratorP: outcome.get("parameters").getAsJsonArray()) {
                JsonObject parameter = iteratorP.getAsJsonObject();
                String single_parameter = "";
                if(!(parameter.get("value").getAsString().equals(RuleServiceUtilities.vNA))) {
                    single_parameter = parameter.get("column").getAsString();

                    if(parameter.get("type").getAsString().equals(RuleServiceUtilities.vLIST_TYPE) || parameter.get("type").getAsString().equals(RuleServiceUtilities.vLIST_VALUE)) {
                        if(parameter.get("value").getAsString().equals(RuleServiceUtilities.vMANUAL)) {
                            single_parameter = single_parameter.replace(
                                    "{"+ parameter.get("parameter").getAsString()+"}",
                                    ruleServiceUtilities.generateOutputManual(parameter.get("manualValue").getAsString()));
                        } else {
                            if(parameter.get("type").getAsString().equals(RuleServiceUtilities.vLIST_TYPE)) {
                                single_parameter = single_parameter.replace(
                                        "{"+ parameter.get("parameter").getAsString()+"}",
                                        parameter.get("value").getAsString());
                            } else {
                                single_parameter = single_parameter.replace(
                                        "{"+ parameter.get("parameter").getAsString()+"}",
                                        ruleServiceUtilities.quotestring(parameter.get("value").getAsString()));
                            }
                            for(JsonElement singleValueTmp: parameter.get("values").getAsJsonArray()) {
                                JsonObject singleValue = singleValueTmp.getAsJsonObject();
                                if(singleValue.get("code").getAsString().equals(parameter.get("value").getAsString())) {
                                    if(singleValue.has("import")) {
                                        if(!imports.contains(singleValue.get("import").getAsString())) {
                                            imports.add(singleValue.get("import").getAsString());
                                        }
                                    }
                                }
                            }

                        }
                    } else if(parameter.get("type").getAsString().equals(RuleServiceUtilities.vFREETEXT)) {
                        single_parameter = single_parameter.replace(
                                "{"+ parameter.get("parameter").getAsString()+"}",
                                ruleServiceUtilities.generateOutputManual(parameter.get("value").getAsString()));
                    } else if(parameter.get("type").getAsString().equals(RuleServiceUtilities.vCALCTEXT)) {
                        single_parameter = single_parameter.replace(
                                "{"+ parameter.get("parameter").getAsString()+"}",
                                ruleServiceUtilities.generateFromCalcManual(parameter.get("value").getAsString()));
                    }
                }
                single_instruction = single_instruction.replace(
                        "{"+ parameter.get("parameter").getAsString() +"}", single_parameter);

            }
            single_instruction = single_instruction.replace(", , ", ", ");
            single_instruction = single_instruction.replace(", )", ")");
            single_rule_outcomes = single_rule_outcomes.concat(single_instruction);
            single_rule_outcomes = single_rule_outcomes.concat("\n\t");

            if(outcome.has("import")) {
                if(!imports.contains(outcome.get("import").getAsString())) {
                    imports.add(outcome.get("import").getAsString());
                }
            }

        }

        String import_text = "";
        for (String anImport : imports) {
            import_text = import_text.concat("import ");
            import_text = import_text.concat(anImport);
            import_text = import_text.concat(";\n");
        }
        single_rule = single_rule.replace("[IMPORTS]", import_text);
        single_rule = single_rule.replace("[INPUTRULETEXT]", single_rule_conditions);
        single_rule = single_rule.replace("[FUNCTIONRULETEXT]", "");
        single_rule = single_rule.replace("[OUTPUTRULETEXT]", single_rule_outcomes);

        control_text = control_text.concat(single_rule);
        control_text = control_text.concat("\n\t");
    }

}
