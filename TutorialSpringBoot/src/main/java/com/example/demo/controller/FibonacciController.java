package com.example.demo.controller;

import com.example.demo.service.RicorsioneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FibonacciController {

    //Metodo errato
    @GetMapping("/fibonacci")
    public void esercizioFibonacci() {

        int num1 =0;
        int num2 =1;
        int numeroFibonacci;
        double quadrato;
        double somma = 0;

        int i = 1;

        do {
            numeroFibonacci = num1+num2;
            quadrato = Math.pow(numeroFibonacci,2);
            somma += quadrato;

            //riassegnazione
            num1 = num2;
            num2 = numeroFibonacci;

            log.info("numero di fibonacci "+i+": "+String.valueOf(numeroFibonacci));
            log.info("Quadrato: "+quadrato);
            log.info("Somma del quadrato: "+somma);
            log.info("--------------------------------------------------------------------");

            i++;
        } while (i <= 5);

    }

    @Autowired
    RicorsioneService ricorsioneService;

    //Metodo Ccorretto con ricorsione
    //Ricorsione: è una funzione che richiama se stessa, tecnica che prevede lo scomponimento di un problema in sottoproblemi simili all'originale
    @GetMapping("/fibonacciRicorsivo/{n}")
    public int fibonacci(@PathVariable int n) {

        return ricorsioneService.fibonacci(n);

    }

    @GetMapping("/esercizioRicorsione")
    public int[] esRicorsione(){

        int[] intArr = {1,2,3,4,5,6,7};
        return ricorsioneService.reverse(intArr,0, intArr.length-1);
    }



}


