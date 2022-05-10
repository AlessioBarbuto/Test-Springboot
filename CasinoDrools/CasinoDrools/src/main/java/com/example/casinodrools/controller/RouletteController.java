package com.example.casinodrools.controller;

import com.example.casinodrools.entity.CasinoBarOrder;
import com.example.casinodrools.entity.RouletteSpin;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouletteController {

    @Autowired
    private KieSession session;

    /**
     * Spin the roulette and calculate the win probability of a specific bet
     * @param spin
     * @return
     */
    @PostMapping("/rouletteProbability")
    public RouletteSpin calculateProbability(@RequestBody RouletteSpin spin) {
        session.insert(spin);
        session.fireAllRules();
        return spin;
    }

    @PostMapping("/casinoBarMenu")
    public CasinoBarOrder calculateProbability(@RequestBody CasinoBarOrder order) {
        session.insert(order);
        session.fireAllRules();
        return order;
    }


}
