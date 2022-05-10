package com.example.esercitazioneproceduradrls.service.rule;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.esercitazioneproceduradrls.model.Rule;
import com.google.gson.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.yaml.snakeyaml.Yaml;

public class RuleServiceUtilities {

    private JsonObject yamlStructure = null;

    static public String control_template =
            "package com.pwc.innovate; \n" +
                    "\n" +
                    "import org.pwc.innovate.drools_4_tit.*;\n" +
                    "import org.pwc.innovate.structure.*;\n" +
                    "import org.pwc.innovate.utils.*;\n" +
                    "[IMPORTS]\n"+
                    "\n"+
                    "rule [RULE_NAME] \n"+
                    "dialect \"mvel\" \n"+
                    "when \n"+
                    "\n"+
                    "\t[INPUTRULETEXT] \n"+
                    "\n"+
                    "then \n"+
                    "\n"+
                    "\t[FUNCTIONRULETEXT] \n"+
                    "\n"+
                    "\t[OUTPUTRULETEXT]\n"+
                    "\n"+
                    "end\n";

    static public String MANUAL = "manual";
    static public  String NA = "none";

    static public  String LIST_VALUE = "list_by_value";
    static public  String LIST_TYPE = "list_by_type";
    static public  String FREETEXT = "free_text";
    static public  String CALCTEXT = "calc_text";

    /**
     * Costructor method that when inizialized create a json object starting from a yaml file.
     */
    public RuleServiceUtilities(){
        Map<String, Object> obj = mapObjectFromYml();
        createJsonObjectFromMap(obj);
        System.out.println(obj);
    }

    /**
     * create a Json Object from a "String, Object" map
     * @param obj
     */
    private void createJsonObjectFromMap(Map<String, Object> obj) {
        Gson gson = new Gson();
        this.yamlStructure = gson.toJsonTree(obj).getAsJsonObject();
    }

    /**
     * Given an input .yml file, returns a map of objects.
     * @return
     */
    private Map<String, Object> mapObjectFromYml() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("buildingblock.yaml");
        Map<String, Object> obj = yaml.load(inputStream);
        return obj;
    }

    public JsonObject getYamlStructure() {
        return yamlStructure;
    }

    public JsonObject getBlockInfo(String type, String code) {

    	if (this.yamlStructure.get(type) != null) {
	        for(JsonElement iterator: this.yamlStructure.get(type).getAsJsonArray()) {
	            JsonObject item = iterator.getAsJsonObject().get("command").getAsJsonObject();

	            if(item.get("code").getAsString().equals(code)) {
	                item.addProperty("type", type);
	                return item;
	            }

	        }
    	} else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "type not found");
        }
        return null;
    }

    public String generateFromCalcManual(String value) {
        return value;
    }

    public String generateOutputManual(String value) {

        String returnValue = value;
        String inside = "";


            /* DA FISSARE

            int numInside = value.split("\\]").length -1;
            if (numInside != (value.split("\\[").length - 1))
                return "unknown";

            if (numInside > 0) {
                int startBracket = 0;

                for (var i = 0; i < value.length(); i++) {
                    if (value.charAt(i) == '[') {
                        startBracket = i;
                        break;
                    }
                }

                int endBracket = 0;

                for (var i = value.length() - 1; i >= 0; --i) {
                    if (value.charAt(i) == ']') {
                        endBracket = i;
                        break;
                    }
                }

                inside = value.substring(startBracket + 1, endBracket);
                value = value.replace(value.substring(startBracket, endBracket + 1), "@1@");

            }

            String[] words = value.split("\\.");

            if (words.length == 3) {
                if (words[2].equals("d")) {
                    returnValue = words[0];
                    returnValue = returnValue.concat(".getDouble(\"");
                    returnValue = returnValue.concat(words[1]);
                    returnValue = returnValue.concat("\")");

                    return returnValue;
                } else {
                    returnValue = words[0];
                    returnValue = returnValue.concat(".get");
                    returnValue = returnValue.concat(words[1].toUpperCase());
                    if (words[2].equals("@1@"))
                        returnValue = returnValue.concat("(" + this.generateOutputManual(inside) + ")");
                    else
                        returnValue = returnValue.concat("(" + words[2] + ")");
                }
            } else if (words.length == 2) {
                if (words[1].equals("value")) {
                    returnValue = words[0];
                } else {
                    returnValue = words[0];
                    returnValue = returnValue.concat(".get");
                    returnValue = returnValue.concat(words[1].toUpperCase());
                    returnValue = returnValue.concat("()");
                }
            } else if (words.length == 1) {
                returnValue = words[0];
            }


             */
        return returnValue;

    }

    public String quotestring(String value) {
        String returnValue = "";

        returnValue = "\"";
        returnValue = returnValue.concat(value);
        returnValue = returnValue.concat("\"");

        return returnValue;
    }

    public String generateManual(String value) {
        String returnValue = "";
        String[] words = value.split(".");

        if (words.length == 3) {
            if (words[2].equals("d")) {
                returnValue = words[0];
                returnValue = returnValue.concat(".getDouble(\"");
                returnValue = returnValue.concat(words[1]);
                returnValue = returnValue.concat("\")");

                return returnValue;
            }
        }
        return "unknown";

    }




}
