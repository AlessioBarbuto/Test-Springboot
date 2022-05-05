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
public class GetControlsService extends BaseService {

    private static final Logger log = LoggerUtils.getLogger(GetControlsService.class);

    public String run() throws SQLException, IOException {
        log.debug("getControls");

        /*

        RuleServiceUtilities ruleServiceUtilities = new RuleServiceUtilities();
        ruleServiceUtilities.init();

        PreparedStatement pstmt = null;
        String query = "SELECT CONTROL_NUMBER, NAME, DESCRIPTION, TYPE, SCHEDULE FROM DT_CONTROLS";
        pstmt = this.conn.prepareStatement(query);
        ResultSet res = pstmt.executeQuery();

        JsonArray controls = new JsonArray();

        while(res.next()) {
            JsonObject control = new JsonObject();
            control.addProperty("control_number", res.getInt("CONTROL_NUMBER"));
            control.addProperty("name", res.getString("NAME"));
            control.addProperty("description", res.getString("DESCRIPTION"));
            control.addProperty("type", res.getString("TYPE"));
            control.addProperty("schedule", res.getString("SCHEDULE"));
            controls.add(control);

            break;
        }

        res.close();
        pstmt.close();

        return controls.toString();
        */

        JsonArray controls = new JsonArray();

        JsonObject control = new JsonObject();
        control.addProperty("control_number", "1");
        control.addProperty("name", "Primo controllo");
        control.addProperty("description", "Descrizione del primo controllo");
        control.addProperty("type", "Automatic");
        control.addProperty("schedule", "0.0");
        controls.add(control);


        return controls.toString();
    }
}
