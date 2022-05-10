package com.example.casinodrools.config;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Slf4j
@Configuration
public class DroolConfig {

    private final KieServices kieServices = KieServices.Factory.get();

    /**
     * Setting of the KieFileSystem bean;
     * this is an in-memory file system provided by the framework.
     * Following code provides the container to define the Drools resources, in this case is a rules file.
     * @return KieFileSystem
     * @throws IOException
     */
    private KieFileSystem getKieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("menu-bar.drl"));
        return kieFileSystem;

    }

    /**
     * Setting the KieContainer. which is a placeholder for all the KieBases for particular KieModule.
     * KieContainer is built with the help of other beans including KieFileSystem, KieModule, and KieBuilder.
     * @return KieContainer
     * @throws IOException
     */
    @Bean
    public KieContainer getKieContainer() throws IOException {
        log.info("Container created");
        getKieRepository();
        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());

    }

    /**
     * Setting the KieRepository and adding modules
     */
    private void getKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }


    /**
     * The rules are fired by opening a KieSession bean
     * @return KieSession
     * @throws IOException
     */
    @Bean
    public KieSession getKieSession() throws IOException {
        log.info("session created");
        return getKieContainer().newKieSession();

    }

}
