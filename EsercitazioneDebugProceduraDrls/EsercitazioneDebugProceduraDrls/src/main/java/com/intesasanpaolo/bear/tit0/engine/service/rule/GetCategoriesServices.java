package com.intesasanpaolo.bear.tit0.engine.service.rule;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class GetCategoriesServices extends BaseService {

    private static final Logger log = LoggerUtils.getLogger(GetCategoriesServices.class);

    public String run(String type) throws SQLException, IOException {

        log.debug("getBlock");


        RuleServiceUtilities ruleServiceUtilities = new RuleServiceUtilities();
        ruleServiceUtilities.init();

        System.out.println("getCategories");

        JsonArray categories = new JsonArray();

        for(JsonElement iterator: ruleServiceUtilities.getYamlStructure().get("categories").getAsJsonObject().get(type).getAsJsonArray()) {
            JsonObject item = iterator.getAsJsonObject();

            JsonObject category = new JsonObject();
            category.addProperty("data", item.get("item").getAsJsonObject().get("code").getAsString());
            category.addProperty("label", item.get("item").getAsJsonObject().get("description").getAsString());
            category.add("children", new JsonArray());

            categories.add(category);
        }

        for(JsonElement iterator: ruleServiceUtilities.getYamlStructure().get(type).getAsJsonArray()) {
            JsonObject item = iterator.getAsJsonObject();

            JsonObject category = null;
            for(JsonElement iteratorC: categories.getAsJsonArray()) {
                JsonObject itemC = iteratorC.getAsJsonObject();
                if(itemC.get("data").getAsString().equals(item.get("command").getAsJsonObject().get("category").getAsString()))
                    category = itemC;
            }

            if(category != null) {

                JsonObject itemC = ruleServiceUtilities.getBlockInfo(type, item.get("command").getAsJsonObject().get("code").getAsString()).deepCopy();
                itemC.remove("parameters");


                category.get("children").getAsJsonArray().add(itemC);
            }

        }


        return categories.toString();

    }
}
