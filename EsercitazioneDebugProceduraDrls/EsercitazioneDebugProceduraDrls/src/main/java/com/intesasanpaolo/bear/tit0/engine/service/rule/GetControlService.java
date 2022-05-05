package com.intesasanpaolo.bear.tit0.engine.service.rule;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class GetControlService extends BaseService {

    private static final Logger log = LoggerUtils.getLogger(GetControlService.class);

    public String run(String id, String type) throws SQLException, IOException {
        log.debug("getControl");
        log.debug("Get Control #" + id + " and type " + type);

        String po_document = null;


        RuleServiceUtilities ruleServiceUtilities = new RuleServiceUtilities();
        ruleServiceUtilities.init();

        /*
        PreparedStatement pstmt = null;
        String query = "SELECT PO_DOCUMENT FROM DT_CONTROLS_JSON WHERE ID = ? AND TYPE = ?";
        pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, Integer.valueOf(id));
        pstmt.setString(2, type);

        ResultSet res = pstmt.executeQuery();


        while(res.next()) {
            po_document = new String(res.getString(1));
            break;
        }

        res.close();
        pstmt.close();

        */

        if(po_document == null) {
            JsonArray templateRules = new JsonArray();
            JsonObject templateItem = new JsonObject();
            templateItem.addProperty("name", "Regola #1");
            templateItem.add("conditions", new JsonArray());
            templateItem.add("outcomes", new JsonArray());
            templateRules.add(templateItem);
            po_document = templateRules.toString();
        }


        return po_document;
    }
}
