package com.intesasanpaolo.bear.tit0.engine.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.DealRecordDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtDealFilterDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ConfigurazioniDealSearchParamDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.DealInputDataDTO;
import com.intesasanpaolo.bear.tit0.engine.enums.OperEnum;
import com.intesasanpaolo.bear.tit0.engine.utils.MockMvcRequestBuilders;

public class DealsControllerTest extends BaseTest {

	@Test
	public void testStartNewInstance() throws Exception {
		DealInputDataDTO listDataInput = DealInputDataDTO.builder().controlloId("#BT_INTRA").oper("INTRA").dataEsecuzione("2021-11-30").build();
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/deals/start-deal-request")
				.content(objectMapper.writeValueAsString(listDataInput)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertNotNull(mvcResult.getResponse());
	}

	@Test
	public void testUpdateDeals() throws Exception {
		
		
		List<DealRecordDTO> listDataInput = Arrays.asList(DealRecordDTO.builder().
				idDeal("0000000").
				idRun("000000000").
				idCtrl("TEST").
				idCasisticaMan("").
				desCasisticaMan("").
				tit_ricalcolo_man(0.d).
				codUser("").
				desNote("").
				flType("P").
				operType("").
				idTitMan("").
				desTitMan("").
				validato("").build());
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/deals/2021-11-21/oper/BT_INTRA/env/P")
				.content(objectMapper.writeValueAsString(listDataInput)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
	}

	@Test
	public void testGetDeals() throws Exception {
		List<DealRecordDTO> listDataInput = Arrays.asList(DealRecordDTO.builder().codUser("ALL_BT").codBaseCcy("").build());
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/deals/2021-11-30/oper/ALL_BT/env/P")
				.content(objectMapper.writeValueAsString(listDataInput)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
	}

	@Test
	public void testGetDealDeatails() throws Exception {
		List<DealRecordDTO> listDataInput = Arrays.asList(DealRecordDTO.builder().idDeal("11244296").build());
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/deals/2021-11-30/oper/BT_INTRA/env/P")
				.content(objectMapper.writeValueAsString(listDataInput)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
	}

	@Test
	public void testListDealConfigurazione() throws Exception {
		ConfigurazioniDealSearchParamDTO configurazione = ConfigurazioniDealSearchParamDTO.builder().cod_source("")
				.oper(OperEnum.CE).build();
		mockMvc.perform(MockMvcRequestBuilders.post("/deals/listConfigurazioni")
				.content(objectMapper.writeValueAsString(configurazione)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testUpdateDealConfigurazione() throws Exception {
		DtDealFilterDTO configurazione = DtDealFilterDTO.builder().cod_source("").cod_user("").build();
		mockMvc.perform(MockMvcRequestBuilders.put("/deals/configurazioni")
				.content(objectMapper.writeValueAsString(configurazione)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
	}

	@Test
	public void testInsertDealConfigurazione() throws Exception {
		DtDealFilterDTO configurazione = DtDealFilterDTO.builder().cod_source("").cod_user("").build();
		mockMvc.perform(MockMvcRequestBuilders.post("/deals/configurazioni")
				.content(objectMapper.writeValueAsString(configurazione)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
	}

	@Test
	public void testDeleteDealConfigurazione() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/deals/configurazioni/configAAA"))
				.andExpect(status().isOk());
	}

}
