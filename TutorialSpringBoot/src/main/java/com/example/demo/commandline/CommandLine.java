package com.example.demo.commandline;

import com.example.demo.service.PopolamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    PopolamentoService popolamentoService;

    @Override
    public void run(String... args) {

        log.info("popolo il db");
        popolamentoService.populateDB();

    }

}
