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
public class GetAttributesByBlockService extends BaseService {

    private static final Logger log = LoggerUtils.getLogger(GetAttributesByBlockService.class);

    public String run(String type, String code) throws SQLException, IOException {

        log.debug("GetAttributesByBlockService");


        JsonArray parameters = new JsonArray();

        RuleServiceUtilities ruleServiceUtilities = new RuleServiceUtilities();
        ruleServiceUtilities.init();

        JsonObject itemB = ruleServiceUtilities.getBlockInfo(type, code);
        if(itemB != null && itemB.get("parameters") != null) {
            for(JsonElement iteratorB: itemB.get("parameters").getAsJsonArray()) {
                JsonObject parameter = iteratorB.getAsJsonObject().deepCopy();
                parameter.addProperty("value", "");
                parameter.addProperty("manualValue", "");

                parameters.add(parameter);
            }
            return parameters.toString();
        }


        return "[]";
    }
}
