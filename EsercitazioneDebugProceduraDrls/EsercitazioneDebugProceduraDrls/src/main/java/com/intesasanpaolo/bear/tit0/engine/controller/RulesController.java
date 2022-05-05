package com.intesasanpaolo.bear.tit0.engine.controller;

import com.intesasanpaolo.bear.tit0.engine.command.rule.*;
import com.intesasanpaolo.bear.tit0.engine.resource.RuleResource;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @Created  17/01/2022 - 18:38
 * @Project core-tit-engine-v1
 * @Author Roberto Spagnuolo
 */


import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping(
        path = "/rule",
        produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})

public class RulesController {

  /* Created by Roberto Spagnuolo on 17/01/2022 */

  private final BeanFactory beanFactory;

  public RulesController(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
  }

  // Todo verifica Ok: Riorna le regole suddive in P ed S (produzione e simulazione)
    @GetMapping("/findAll")
    @ApiOperation(value = "Ottiene la lista di tutte le regole")
    public ResponseEntity<List<RuleResource>> getAllRules()
            throws Exception {
        ListRulesCommand listRulesCommand = beanFactory.getBean(ListRulesCommand.class);
        return ok(listRulesCommand.execute());
    }

    // Todo: mi ritorna ogni prevista per ogni blocco
    @GetMapping("/simulator/getAttributesByBlock/{type}/{block}")
    @ApiOperation(value = "Ottiene i blocchi di un tipo")
    public ResponseEntity<String> getAttributesByBlockCommand(
            @PathVariable("type") String type,
            @PathVariable("block") String block) throws Exception {
        GetAttributesByBlockCommand getAttributesByBlockCommand = beanFactory.getBean(GetAttributesByBlockCommand.class, type, block);
        return ok(getAttributesByBlockCommand.execute());
    }

    // Todo:
    @GetMapping("/simulator/getCategories/{type}")
    @ApiOperation(value = "Ottiene i blocchi di un tipo")
    public ResponseEntity<String> getCategories(
            @PathVariable("type") String type) throws Exception {
        GetCategoriesCommand getCategoriesCommand = beanFactory.getBean(GetCategoriesCommand.class, type);
        return ok(getCategoriesCommand.execute());
    }

    @GetMapping("/simulator/getBlock/{type}/{block}")
    @ApiOperation(value = "Ottiene le info di un singolo block")
    public ResponseEntity<String> getBlock(
            @PathVariable("type") String type,
            @PathVariable("block") String block) throws Exception {
        GetBlockCommand getBlockCommand = beanFactory.getBean(GetBlockCommand.class, type, block);
        return ok(getBlockCommand.execute());
    }


    

    @GetMapping("/simulator/getControl/{id}/{type}")
    @ApiOperation(value = "Ottiene i blocchi di un tipo")
    public ResponseEntity<String> getControlCommand(
            @PathVariable("id") String id,
            @PathVariable("type") String type) throws Exception {
        GetControlCommand getControlCommand = beanFactory.getBean(GetControlCommand.class, id, type);
        return ok(getControlCommand.execute());
    }

    @GetMapping("/simulator/getControls")
    @ApiOperation(value = "Ottiene i blocchi di un tipo")
    public ResponseEntity<String> getControlsCommand() throws Exception {
        GetControlsCommand getControlsCommand = beanFactory.getBean(GetControlsCommand.class);
        return ok(getControlsCommand.execute());
    }

    @PostMapping("/simulator/saveControl")
    @ApiOperation(value = "Salva i blocchi di un tipo")
    public ResponseEntity<String> saveControlCommand(
            @Valid @RequestBody String body,
            @RequestParam String id) throws Exception {
        SaveControlCommand saveControlCommand = beanFactory.getBean(SaveControlCommand.class, id, body);
        return ok(saveControlCommand.execute());
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

    // Todo: verificare funzionale
    @PutMapping("/simulator/putControls/{controls}")
    @ApiOperation(value = "Ottiene i blocchi di un tipo")
    public ResponseEntity<String> putControlsCommand(
            @PathVariable("controls") String controls) throws Exception {
        PutControlsCommand putControlsCommand = beanFactory.getBean(PutControlsCommand.class, controls);
        return ok(putControlsCommand.execute());
    }
  
}
