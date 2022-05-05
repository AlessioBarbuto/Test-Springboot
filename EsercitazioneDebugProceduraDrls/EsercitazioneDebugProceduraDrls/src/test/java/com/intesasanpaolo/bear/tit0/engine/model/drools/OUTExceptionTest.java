package com.intesasanpaolo.bear.tit0.engine.model.drools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class OUTExceptionTest {

    private OUTException outException;

    @BeforeEach
    void setUp() throws Exception {

        String idCasistica   = "idCasistica";
        String desCasisitica = "desCasisitica";
        String idTit         = "idTit";
        String desTit        = "desTit";
        String idDeal        = "idDeal";
        Exception exception  = new Exception();
        String description   = "description";

        outException = new OUTException(idCasistica, desCasisitica, idTit,
                                        desTit, idDeal, exception, description);
    }

    @Test
    void get() {
     String fileName = "fileName";
     outException.get(fileName);
    }

    @Test
    void getDoubleValue() {
        OUTException outExceptionNoArgs = new OUTException();
        String fileName = "fileName";
        outExceptionNoArgs.getDoubleValue(fileName);
    }

    @Test
    void getString() {
        String fileName = "fileName";
        outException.getString(fileName);
    }

    @Test
    void getDate() throws ParseException {
        String fileName = "fileName";
        outException.getDate(fileName);
    }

    @Test
    void getTimestamp() throws ParseException {
        String fileName = "fileName";
        outException.getTimestamp(fileName);
    }
}