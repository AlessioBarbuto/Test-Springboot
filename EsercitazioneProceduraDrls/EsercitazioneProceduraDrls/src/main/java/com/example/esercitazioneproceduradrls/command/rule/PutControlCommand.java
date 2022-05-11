package com.example.esercitazioneproceduradrls.command.rule;

import com.example.esercitazioneproceduradrls.model.Rule;
import com.example.esercitazioneproceduradrls.service.rule.PutControlServiceRefactored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class PutControlCommand {

    private String id;
    private String type;
    //private String body;
    private List<Rule> rules;

    @Autowired
    private PutControlServiceRefactored putControlService;

    public PutControlCommand(String id, String type, List<Rule> rules) {
        this.id = id;
        this.type = type;
        this.rules = rules;
    }

    public String execute() throws Exception {
        return putControlService.run(id, type, rules);
    }
}
