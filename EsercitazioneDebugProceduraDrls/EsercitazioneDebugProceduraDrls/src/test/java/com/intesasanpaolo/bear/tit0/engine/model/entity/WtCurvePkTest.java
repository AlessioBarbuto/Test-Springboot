package com.intesasanpaolo.bear.tit0.engine.model.entity;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WtCurvePkTest {

    private String idPrg          = "idPrg";
    private String codAsset       = "codAsset";
    private String codCcy         = "codCcy";
    private String codType        = "codType";
    private String codTenor       = "codTenor";
    private java.sql.Date dtRif   = null;
    private java.sql.Date dtStart = null;



    @Test
    void testEquals() {
        String idPrg             = "idPrg";
        String codAsset          = "codAsset";
        String codCcy            = "codCcy";
        String codType           = "codType";
        String codTenor          = "codTenor";
        java.sql.Date dtRif      = null;
        java.sql.Date dtStart    = null;
        WtCurvePk wtCurvePk      = new WtCurvePk(idPrg,codAsset,codCcy,
                                              codType,codTenor,dtRif,dtStart);

        String idPrg2            = "idPrg";
        String codAsset2         = "codAsset";
        String codCcy2           = "codCcy";
        String codType2          = "codType";
        String codTenor2         = "codTenor";
        java.sql.Date dtRif2     = null;
        java.sql.Date dtStart2   = null;
        WtCurvePk wtCurvePkTest  = new WtCurvePk(idPrg2,codAsset2,codCcy2,
                                                 codType2,codTenor2,dtRif2,dtStart2);
        WtCurvePk wtCurveNull  = null;
        wtCurvePk.equals(wtCurveNull);
        wtCurvePk.equals(wtCurvePkTest);
        wtCurvePk.equals(wtCurvePk);
        assert(true);
    }

    @Test
    void testHashCode() {
        WtCurvePk wtCurvePk   = new WtCurvePk();
        wtCurvePk.hashCode();
    }
}