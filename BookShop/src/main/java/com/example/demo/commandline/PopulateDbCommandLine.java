package com.example.demo.commandline;

import com.example.demo.service.PopulateDbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PopulateDbCommandLine implements CommandLineRunner {

    @Autowired
    PopulateDbService populateDbService;

    @Override
    public void run(String... args) throws Exception {
        //populateDbService.populateDB();
        //log.info("db populated");

    }
}
