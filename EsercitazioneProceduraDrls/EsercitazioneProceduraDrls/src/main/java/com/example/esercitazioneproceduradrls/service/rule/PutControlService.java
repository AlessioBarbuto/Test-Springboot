package com.example.esercitazioneproceduradrls.service.rule;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class PutControlService{

    public static final String RULE_NAME = "[RULE_NAME]";
    public static final String NAME = "name";
    public static final String CONDITIONS = "conditions";
    public static final String PATTERN = "pattern";
    public static final String NAME1 = "{NAME}";
    public static final String PARAMETERS = "parameters";
    public static final String TYPE = "type";
    public static final String TYPE1 = "type";
    // private static final Logger log = Logger.getLogger(PutControlService.class);
   Logger log = LoggerFactory.getLogger(PutControlService.class);


    public String run(String id, String type, String body) throws SQLException, IOException {
        log.debug("putControl");
        log.debug("Looking for controls #" +id + " and type " + type);


        RuleServiceUtilities ruleServiceUtilities = new RuleServiceUtilities();

        /*
        PreparedStatement pstmt = null;
        String query = "DELETE FROM DT_CONTROLS_JSON WHERE ID = ? AND TYPE = ?";
        pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, Integer.valueOf(id.toString()));
        pstmt.setString(2, type);
        pstmt.execute();

        query = "INSERT INTO DT_CONTROLS_JSON(ID, TYPE, DATE_LOADED, PO_DOCUMENT) VALUES (?, ?, ?, ?)";
        pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, Integer.valueOf(id));
        pstmt.setString(2, type);

        pstmt.execute();
        */

        String control_text = "";

        JsonArray rules = JsonParser.parseString(body).getAsJsonArray();
        List<String> imports = new ArrayList<>();

        for(JsonElement iteratorR: rules) {
            JsonObject rule = iteratorR.getAsJsonObject();
            String single_rule = RuleServiceUtilities.control_template;

            single_rule = single_rule.replace(RULE_NAME, rule.get(NAME).getAsString());
            String single_rule_conditions = "";
            for(JsonElement iteratorC: rule.get(CONDITIONS).getAsJsonArray()) {
                JsonObject condition = iteratorC.getAsJsonObject();
                String single_instruction = condition.get(PATTERN).getAsString();
                single_instruction = single_instruction.replace(NAME1, condition.get(NAME).getAsString());

                for(JsonElement iteratorP: condition.get(PARAMETERS).getAsJsonArray()) {
                    JsonObject parameter = iteratorP.getAsJsonObject();
                    String single_parameter = "";
                    if(parameter.get(TYPE1).getAsString().equals(RuleServiceUtilities.LIST_TYPE) || parameter.get(TYPE).getAsString().equals(RuleServiceUtilities.LIST_VALUE)) {
                        if(parameter.get("value").getAsString().equals(RuleServiceUtilities.MANUAL)) {
                            single_parameter = single_parameter.replace(
                                    "{"+ parameter.get("parameter").getAsString()+"}",
                                    ruleServiceUtilities.generateOutputManual(parameter.get("manualValue").getAsString()));
                        } else {
                            if(parameter.get("type").getAsString().equals(RuleServiceUtilities.LIST_TYPE)) {
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
                    } else if(parameter.get("type").getAsString().equals(RuleServiceUtilities.FREETEXT)) {
                        single_parameter = single_parameter.replace(
                                "{"+ parameter.get("parameter").getAsString()+"}",
                                ruleServiceUtilities.generateOutputManual(parameter.get("value").getAsString()));
                    } else if(parameter.get("type").getAsString().equals(RuleServiceUtilities.CALCTEXT)) {
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
                    if(!(parameter.get("value").getAsString().equals(RuleServiceUtilities.NA))) {
                        single_parameter = parameter.get("column").getAsString();

                        if(parameter.get("type").getAsString().equals(RuleServiceUtilities.LIST_TYPE) || parameter.get("type").getAsString().equals(RuleServiceUtilities.LIST_VALUE)) {
                            if(parameter.get("value").getAsString().equals(RuleServiceUtilities.MANUAL)) {
                                single_parameter = single_parameter.replace(
                                        "{"+ parameter.get("parameter").getAsString()+"}",
                                        ruleServiceUtilities.generateOutputManual(parameter.get("manualValue").getAsString()));
                            } else {
                                if(parameter.get("type").getAsString().equals(RuleServiceUtilities.LIST_TYPE)) {
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
                        } else if(parameter.get("type").getAsString().equals(RuleServiceUtilities.FREETEXT)) {
                            single_parameter = single_parameter.replace(
                                    "{"+ parameter.get("parameter").getAsString()+"}",
                                    ruleServiceUtilities.generateOutputManual(parameter.get("value").getAsString()));
                        } else if(parameter.get("type").getAsString().equals(RuleServiceUtilities.CALCTEXT)) {
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

        JsonObject message = new JsonObject();
        message.addProperty("code", "ok");
        message.addProperty("body", control_text);

        return message.toString();

    }
}
