package com.intesasanpaolo.bear.tit0.engine.service.rule;

import com.google.gson.JsonObject;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;
import com.intesasanpaolo.bear.tit0.engine.model.entity.DtRules;
import com.intesasanpaolo.bear.tit0.engine.resource.RuleResource;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetBlockService extends BaseService {

    private static final Logger log = LoggerUtils.getLogger(GetBlockService.class);

    public String run(String type, String code) throws SQLException, IOException {

        log.debug("getBlock");

        RuleServiceUtilities ruleServiceUtilities = new RuleServiceUtilities();
        ruleServiceUtilities.init();

        JsonObject itemP = ruleServiceUtilities.getBlockInfo(type, code).deepCopy();
        itemP.remove("parameters");
        return itemP.toString();
    }

}
