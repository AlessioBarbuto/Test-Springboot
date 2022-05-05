package com.intesasanpaolo.bear.tit0.engine.service.rule;

import com.google.gson.JsonObject;
import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class SaveControlService extends BaseService {

    private static final Logger log = LoggerUtils.getLogger(SaveControlService.class);

    public String run(String id, String body) throws SQLException, IOException {
        log.debug("saveControlService");

        String returnMessage = "";


/*
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        KieFileSystem kieFileSystem = ks.newKieFileSystem();
        kieFileSystem.write("src/main/resources/com/pwc/innovate/" + drlFile, body);

        KieBuilder kieBuilder = ks.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();



        if(kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {

            for(Message message: kieBuilder.getResults().getMessages()) {
                returnMessage = returnMessage.concat(message.getText());
                returnMessage = returnMessage.concat("\n");
            }

        }

        if(returnMessage.isEmpty()) {
            PreparedStatement pstmt = null;
            String query = "DELETE FROM DT_CONTROLS_TEXT WHERE ID = ?";
            pstmt = this.conn.prepareStatement(query);
            pstmt.setInt(1, Integer.valueOf(id));
            pstmt.execute();

            query = "INSERT INTO DT_CONTROLS_TEXT(ID, DATE_LOADED, PO_DOCUMENT) VALUES (?, ?, ?)";
            pstmt = this.conn.prepareStatement(query);
            pstmt.setInt(1, Integer.valueOf(id));

            pstmt.execute();

            returnMessage = "OK";
        }
        */

        JsonObject message = new JsonObject();
        message.addProperty("message", returnMessage);

        return message.toString();

    }
}
