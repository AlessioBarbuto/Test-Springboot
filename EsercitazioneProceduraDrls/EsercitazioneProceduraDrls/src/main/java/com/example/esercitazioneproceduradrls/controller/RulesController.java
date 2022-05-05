package com.example.esercitazioneproceduradrls.controller;

import com.example.esercitazioneproceduradrls.command.rule.PutControlCommand;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "false", allowedHeaders = "*")
@RequestMapping(
        path = "/rule",
        produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})

public class RulesController {

  private final BeanFactory beanFactory;

  public RulesController(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
  }

    // Todo: crea il file drl a partire dalla struttura JSON generata da front-end
    @PutMapping("/simulator/putControl")
    @ApiOperation(value = "Ottiene i blocchi di un tipo")
    public ResponseEntity<String> putControlCommand(
            @Valid @RequestBody String body,
            @RequestParam String id,
            @RequestParam String type
            ) throws Exception {
        PutControlCommand putControlCommand = beanFactory.getBean(PutControlCommand.class, id, type, body);
        return ok(putControlCommand.execute());
    }

  
}
