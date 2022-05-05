package com.example.esercitazioneproceduradrls.command.rule;

import com.example.esercitazioneproceduradrls.service.rule.PutControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PutControlCommand {

    private String id;
    private String type;
    private String body;

    @Autowired
    private PutControlService putControlService;

    public PutControlCommand(String id, String type, String body) {
        this.id = id;
        this.type = type;
        this.body = body;
    }

    public String execute() throws Exception {
        return putControlService.run(id, type, body);
    }
}
