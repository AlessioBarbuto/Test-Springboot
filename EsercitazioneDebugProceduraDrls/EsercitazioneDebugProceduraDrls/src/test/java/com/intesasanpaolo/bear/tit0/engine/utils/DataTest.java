package com.intesasanpaolo.bear.tit0.engine.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DataTest {

	@Test
	void testDataLong() {
		Data d = new Data(new Date().getTime());
		assertNotNull(d);
	}

	@Test
	void testDataIntIntInt() {
		Data d = new Data(2000,11,01);
		assertNotNull(d);
	}

	@Test
	void testDataDate() {
		Data d = new Data(new Date());
		assertNotNull(d);
	}

	@Test
	void testDataCalendar() {
		Data d = new Data(Calendar.getInstance());
		assertNotNull(d);
	}

	@Test
	void testData() {
		Data d = new Data();
		assertNotNull(d);
	}

	@Test
	void testGetGiornoTraslato() {
		Data d = new Data();
		Data.getGiornoTraslato(d, 1);
		assertNotNull(d);
	}

	@Test
	void testGetMeseTraslato() {
		Data d = new Data();
		Data.getMeseTraslato(d, 1);
		assertNotNull(d);
	}

	@Test
	void testGetAnnoTraslato() {
		Data d = new Data();
		Data.getAnnoTraslato(d, 1);
		assertNotNull(d);
	}

	@Test
	void testGetInizioPeriodoSolare() {
		Data d = new Data();
		Data.getInizioPeriodoSolare(d, 1);
		assertNotNull(d);
	}

	@Test
	void testGetFinePeriodoSolare() {
		Data d = new Data();
		Data.getFinePeriodoSolare(d, 1);
		assertNotNull(d);
	}

	@Test
	void testGetFinePeriodoSolarePrecedenteRata() {
		Data d = new Data();
		Data.getFinePeriodoSolarePrecedenteRata(d, 1);
		assertNotNull(d);
	}

	@Test
	void testGetInizioPeriodoSpecifico() {
		Data d = new Data();
		Data.getInizioPeriodoSpecifico(d, new Data(), 1);
		assertNotNull(d);
	}

	@Test
	void testGetFinePeriodoSpecifico() {
		Data d = new Data();
		Data.getFinePeriodoSpecifico(d, new Data(), 1);
		assertNotNull(d);
	}

	@Test
	void testGetNGiornoSettimanaPeriodoSolare() {
		Data d = new Data();
		Data.getNGiornoSettimanaPeriodoSolare(d,1,1,1);
		assertNotNull(d);
	}

	@Test
	void testGetNGiornoPeriodoSolarePrecedenteRata() {
		Data d = new Data();
		Data.getNGiornoPeriodoSolarePrecedenteRata(d,1,1);
		assertNotNull(d);
	}

	@Test
	void testGetGiornoMillis() {
		Data d = new Data();
		
		assertNotNull(d.getGiornoMillis());
	}

	@Test
	void testGetGiornoSettimana() {
		Data d = new Data();
		assertNotNull(d.getGiornoSettimana());
	}

	@Test
	void testGetGiornoMese() {
		Data d = new Data();
		assertNotNull(d.getGiornoMese());
	}

	@Test
	void testGetGiornoAnno() {
		Data d = new Data();
		assertNotNull(d.getGiornoAnno());
	}

	@Test
	void testGetMese() {
		Data d = new Data();
		assertNotNull(d.getMese());
	}

	@Test
	void testGetAnno() {
		Data d = new Data();
		assertNotNull(d.getAnno());
	}

	@Test
	void testGetUltimoDelMese() {
		Data d = new Data();
		assertNotNull(d.getUltimoDelMese());
	}

	@Test
	void testAddGiorno() {
		Data d = new Data();
		d.addGiorno(1);
		assertNotNull(d);
	}

	@Test
	void testAddMese() {
		Data d = new Data();
		d.addMese(1);
		assertNotNull(d);
	}

	@Test
	void testAddAnno() {
		Data d = new Data();
		d.addAnno(1);
		assertNotNull(d);
	}

	@Test
	void testToString() {
		Data d = new Data();
		assertNotNull(d.toString());
	}

	@Test
	void testToStringDateFormat() {
		Data d = new Data();
		assertNotNull(d.toString(new SimpleDateFormat("yyyy-MM-DD")));
	}

	@Test
	void testToDate() {
		Data d = new Data();
		assertNotNull(d.toDate());
	}

	@Test
	void testGetGiornoAssoluto() {
		Data d = new Data();
		assertNotNull(d.getGiornoAssoluto());
	}

	@Test
	void testGetNewData() {
		Data d = new Data();
		assertNotNull(d.getNewData());
	}

	@Test
	void testIsDopo() {
		Data d = new Data();
		assertNotNull(d.isDopo(new Data()));
	}

	@Test
	void testIsBisestile() {
		Data d = new Data();
		assertNotNull(d.isBisestile());
	}

	@Test
	void testCompareToData() {
		Data d = new Data();
		assertNotNull(d.compareTo(new Data()));
	}

	@Test
	void testCompareToObject() {
		Data d = new Data();
		assertNotNull(d.compareTo((Object)new Data()));
	}

	@Test
	void testEqualsObject() {
		Data d = new Data();
		assertNotNull(d.equals(new Data()));
	}

	@Test
	void testGetDataFineDelMese() {
		Data d = new Data();
		assertNotNull(d.getDataFineDelMese());
	}

	@Test
	void testGetDataFineAnno() {
		Data d = new Data();
		assertNotNull(d.getDataFineAnno());
	}

	@Test
	void testGetDataInizioAnno() {
		Data d = new Data();
		assertNotNull(d.getDataInizioAnno());
	}

	
	@Test
	void testGetClass() {
		Data d = new Data();
		assertNotNull(d.getClass());
	}

	

	
}
