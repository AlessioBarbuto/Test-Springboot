package com.intesasanpaolo.bear.tit0.engine.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collection;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.DtDealFilterDTO;
import com.intesasanpaolo.bear.tit0.engine.model.api.CasisticaRecord;
import com.intesasanpaolo.bear.tit0.engine.model.drools.IOUT;
import com.intesasanpaolo.bear.tit0.engine.resource.DealConfigurazioneResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ListDealDataResource;
import com.intesasanpaolo.bear.tit0.engine.service.deal.ConfigDealService;
import com.intesasanpaolo.bear.tit0.engine.service.deal.GetDealService;
import com.intesasanpaolo.bear.tit0.engine.transformers.VoidResponseTransformer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DealServiceTest extends BaseTest {

	@Autowired
	private DealService dealService;

	@Autowired
	private GetDealService getDealService;
	@Autowired
	private ConfigDealService configDealService;
	@Autowired
	private VoidResponseTransformer voidResponseTransformer;

	@Test
	@Ignore
	public void TestDealService() throws Exception {

		String dateControl = "2021-10-30";
		String ctrlId = "#INTRA_BT";
		String operType = "BT_INTRA";
		Collection<IOUT> result = dealService.control(dateControl, null, ctrlId, operType);

		assertNotNull(dealService);
	}

	@Test
	@Ignore
	public void TestGetDeal() throws Exception {

		String dataEsecuzione = "2021-10-30";
		String operType = "BT_INTRA";
		String flType = "P";
		ListDealDataResource result = getDealService.run(dataEsecuzione, operType, flType);

		List<CasisticaRecord> l = result.getOperIntraList();
		l.forEach(out -> {
			log.info(out.toString());
			// System.out.println(out);
		});

		assertNotNull(getDealService);
	}

	@Test
	@Ignore
	public void TestUpdateDeal() throws Exception {

		DtDealFilterDTO d = new DtDealFilterDTO();
		d.setId("D922E3CAB1BFD390E0536A1CCC0AEFB8");
		d.setFolder("A");
		d.setCod_source("s");
		d.setBt_mlt("ad");
		d.setDeal_oper("TEST");
		DealConfigurazioneResource result = configDealService.run(d);

		log.info(result.toString());
		//

		assertNotNull(getDealService);
	}

}
