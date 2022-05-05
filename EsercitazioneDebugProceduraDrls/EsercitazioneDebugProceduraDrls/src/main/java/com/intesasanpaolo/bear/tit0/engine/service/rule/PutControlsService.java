package com.intesasanpaolo.bear.tit0.engine.service.rule;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.connector.jdbc.JDBCQueryType;
import com.intesasanpaolo.bear.service.BaseService;
import com.intesasanpaolo.bear.tit0.engine.dto.DtCtrlAnagDTO;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PutControlsService extends BaseService {

    private static final Logger log = LoggerUtils.getLogger(PutControlsService.class);

    public String run(String raw_controls) throws SQLException, IOException {
        log.debug("putControl");
        System.out.println("Put controls#" + raw_controls);

        JsonArray controls = JsonParser.parseString(raw_controls).getAsJsonArray();

/*        String query =
                "DELETE FROM DT_CONTROLS";

        dtCtrlAnagConnector.call(
                        query,
                        dtCtrlAnagJDBCRequestTransformer,
                        dtCtrlAnagJDBCResponseTransformer,
                        JDBCQueryType.EXECUTE);


        for(int i=0; i<controls.size(); i++) {

            JsonObject control = controls.get(i).getAsJsonObject();

            query =
                    "INSERT INTO DT_CONTROLS(CONTROL_NUMBER, NAME, DESCRIPTION, TYPE, SCHEDULE ) VALUES (" +
                            control.get("control_number").getAsString() + ", " +
                            control.get("name").getAsString() + "?, " +
                            control.get("description").getAsString() + "?, " +
                            control.get("type").getAsString() + "?, " +
                            control.get("type").getAsString() + "?" +
                            ")";

            dtCtrlAnagConnector.call(
                    query,
                    dtCtrlAnagJDBCRequestTransformer,
                    dtCtrlAnagJDBCResponseTransformer,
                    JDBCQueryType.EXECUTE);

        }


        pstmt = this.conn.prepareStatement(query);
        pstmt.execute();

        query = "DELETE FROM DT_CONTROLS_JSON j WHERE J.ID NOT IN (SELECT ID FROM DT_CONTROLS dc)";

        dtCtrlAnagConnector.call(
                query,
                dtCtrlAnagJDBCRequestTransformer,
                dtCtrlAnagJDBCResponseTransformer,
                JDBCQueryType.EXECUTE);

        query = "DELETE FROM DT_CONTROLS_TEXT j WHERE J.ID NOT IN (SELECT ID FROM DT_CONTROLS dc)";

        dtCtrlAnagConnector.call(
                query,
                dtCtrlAnagJDBCRequestTransformer,
                dtCtrlAnagJDBCResponseTransformer,
                JDBCQueryType.EXECUTE);

        JsonObject message = new JsonObject();
        message.addProperty("message", "ok");

        return message.toString();*/


        return "{}";
    }
}
