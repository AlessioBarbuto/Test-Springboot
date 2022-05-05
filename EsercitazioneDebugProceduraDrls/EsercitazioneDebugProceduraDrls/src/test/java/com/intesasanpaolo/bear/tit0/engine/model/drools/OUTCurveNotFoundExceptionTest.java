package com.intesasanpaolo.bear.tit0.engine.model.drools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OUTCurveNotFoundExceptionTest {


    String idCasistica   = "idCasistica";
    String desCasisitica = "desCasisitica";
    String idTit         = "idTit";
    String desTit        = "desTit";
    String idDeal        = "idDeal";
    String codAsset      = "codAsset";
    Date tradeDate       = new Date();

    OUTCurveNotFoundException outCurveNotFoundException;
    OUTCurveNotFoundException outCurveNotFoundExceptionNoArgs;

    @BeforeEach
    void setUp() throws Exception {

        outCurveNotFoundException       = new OUTCurveNotFoundException(idCasistica,  desCasisitica,
                                                                        idTit,  desTit,
                                                                        idDeal,  codAsset,
                                                                        tradeDate );
        outCurveNotFoundExceptionNoArgs = new OUTCurveNotFoundException();
    }

    @Test
    void get() {
        String fieldName = "fieldName";
        outCurveNotFoundException.get(fieldName);
    }

    @Test
    void getDoubleValue() {
        String fieldName = "fieldName";
        outCurveNotFoundException.getDoubleValue(fieldName);
    }

    @Test
    void getString() {
        String fieldName = "fieldName";
        outCurveNotFoundException.getString(fieldName);
    }

    @Test
    void getDate() throws ParseException {
        String fieldName = "fieldName";
        outCurveNotFoundException.getDate(fieldName);
    }

    @Test
    void getTimestamp() throws ParseException {
        String fieldName = "fieldName";
        outCurveNotFoundException.getTimestamp(fieldName);
    }
}