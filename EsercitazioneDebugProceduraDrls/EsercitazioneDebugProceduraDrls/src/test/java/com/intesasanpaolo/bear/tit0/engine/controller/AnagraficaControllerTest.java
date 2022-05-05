package com.intesasanpaolo.bear.tit0.engine.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.api.AnagraficaDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.AnagraficaInputDTO;
import com.intesasanpaolo.bear.tit0.engine.model.api.AuditData;
import com.intesasanpaolo.bear.tit0.engine.resource.AnagraficaInputOutputResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AnagraficaResource;
import com.intesasanpaolo.bear.tit0.engine.resource.SogliaResource;
import com.intesasanpaolo.bear.tit0.engine.utils.MockMvcRequestBuilders;
import com.intesasanpaolo.bear.tit0.engine.utils.MockUtils;

public class AnagraficaControllerTest extends BaseTest {
	

    @Test
	public void testGetListSoglia() throws Exception {   	
		mockMvc.perform(MockMvcRequestBuilders.get("/anagrafica/soglia/xx")).andExpect(status().isOk());
	}
    
    @Test
   	public void testGetListSoglie() throws Exception {
   		mockMvc.perform(MockMvcRequestBuilders.post("/anagrafica/soglia/find")).andExpect(status().isOk());
   	}
    

    @Test
	public void testPutListSoglia() throws Exception {
    	SogliaResource content = SogliaResource.builder().controlloId("x").value("0").key("TEST").descrizione("").dataFine(null).dataInizio("2021-11-30 00:00:00").build();
		mockMvc.perform(MockMvcRequestBuilders.put("/anagrafica/soglia/33").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(content)))
				.andExpect(status().isOk());
	}
    
    
	@Test
	public void testGetListAnagControllo() throws Exception {
		List<AnagraficaResource> actual;
		List<AnagraficaResource> expected = MockUtils.getMock_AnagraficaControlloList(objectMapper,
				"listAnagraficaControlloOK.json");
		String actualString = mockMvc.perform(MockMvcRequestBuilders.get("/anagrafica"))

				.andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_AnagraficaControlloList(objectMapper, "listAnagraficaControlloOK.json");

		// actual =
		// objectMapper.readValue(actualString, new
		// TypeReference<List<AnagraficaResource>>()
		// {});
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testListAnagraficaBySearchParams() throws Exception {

		List<AnagraficaResource> actual;
		Page<AnagraficaResource> response = MockUtils.getMock_AnagraficaControlloPage(objectMapper,
				"listAnagraficaBySearchParamsOK.json");
		List<AnagraficaResource> expected = response.getContent();
		// TODO populate payload
		AnagraficaDTO input = AnagraficaDTO.builder().build();
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.post("/anagrafica/find").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(input)))

				.andReturn().getResponse().getContentAsString();
		String actualContent = objectMapper.readTree(actualString).get("content").toString();

		actual = response.getContent();

		// List<AnagraficaResource> actual =
		// Arrays.asList(objectMapper.readValue(actualContent,
		// AnagraficaResource[].class));
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testGetAnagControllo() throws Exception {
		AnagraficaResource actual;
		AnagraficaResource expected = MockUtils.getMock_AnagraficaControllo(objectMapper,
				"getAnagraficaControlloOK.json");
		String actualString = mockMvc.perform(MockMvcRequestBuilders.get("/anagrafica/" + expected.getIdCtrl()))

				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_AnagraficaControllo(objectMapper, "getAnagraficaControlloOK.json");

		// AnagraficaResource actual = objectMapper.readValue(actualString,
		// AnagraficaResource.class);

		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testUpdateAnagControllo() throws Exception {
		AnagraficaResource expected = MockUtils.getMock_AnagraficaControllo(objectMapper,
				"updateAnagraficaControlloOK.json");
		mockMvc.perform(MockMvcRequestBuilders.put("/anagrafica/" + expected.getIdCtrl())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(expected)))

				.andExpect(status().isOk());
	}

	@Test
	public void testUpdateInputAnagControllo() throws Exception {
		AnagraficaInputDTO content = AnagraficaInputDTO.builder().idCtrl("123").nomeCurva("abc").build();
		mockMvc.perform(MockMvcRequestBuilders.put("/anagrafica/input/abc123").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(content)))

				.andExpect(status().isInternalServerError());
	}

	@Test
	public void testInsertInputAnagControllo() throws Exception {
		AnagraficaInputDTO content = AnagraficaInputDTO.builder().idCtrl("123").nomeCurva("abc").build();
		mockMvc.perform(MockMvcRequestBuilders.post("/anagrafica/input/abc123").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(content)))

				.andExpect(status().isInternalServerError());
	}

	@Test
	public void testDeleteInputAnagControllo() throws Exception {
		AnagraficaInputDTO content = AnagraficaInputDTO.builder().idCtrl("123").nomeCurva("abc").build();
		mockMvc.perform(MockMvcRequestBuilders.delete("/anagrafica/input/abc123")
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(content)))

				.andExpect(status().isOk());
	}

	@Test
	public void testGetListAnagInputOutputControllo() throws Exception {
		List<AnagraficaInputOutputResource> actual;
		List<AnagraficaInputOutputResource> expected = MockUtils.getMock_AnagraficaInputOutputList(objectMapper,
				"listAnagraficaInputOutputControlloOK.json");
		String actualString = mockMvc.perform(MockMvcRequestBuilders.get("/anagrafica/input/abc123"))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_AnagraficaInputOutputList(objectMapper, "listAnagraficaInputOutputControlloOK.json");
		// List<AnagraficaInputOutputResource> actual =
		// objectMapper.readValue(actualString,
		// new TypeReference<List<AnagraficaInputOutputResource>>() {});
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void updateAnagraficaControlliById() throws Exception {

		String uri = "/anagrafica/{controlloId}";

		String controlloId = "#3";

		AnagraficaDTO dtCtrlAnagDTO = new AnagraficaDTO();
		AuditData auditData = new AuditData();
		auditData.setUserName("U0J8452");

		dtCtrlAnagDTO.setIdCtrl("#3");
		dtCtrlAnagDTO.setNote("unit test update");
		dtCtrlAnagDTO.setDescrizione("Spread per la curva TIT marginale a tasso variabile");
		dtCtrlAnagDTO.setAuditData(auditData);
		

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.put(uri, controlloId).content(objectMapper.writeValueAsString(dtCtrlAnagDTO))
				.contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void insertAndDeletedAnagraficaControlliById() throws Exception {

		String uri = "/anagrafica/{controlloId}";

		String controlloId = "#33";

		AnagraficaDTO anagraficaResource = new AnagraficaDTO();
		AuditData auditData = new AuditData();
		auditData.setUserName("U0J8452");

		anagraficaResource.setIdCtrl("#33");
		anagraficaResource.setNote("unit test insert");
		anagraficaResource.setDescrizione("Spread per la curva TIT marginale a tasso variabile");
		anagraficaResource.setAuditData(auditData);

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.put(uri, controlloId).content(objectMapper.writeValueAsString(anagraficaResource))
				.contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);

		
	}

	@Test
	public void updateAnagraficaInput() throws Exception {

		String uri = "/anagrafica/input/{controlloId}";

		String controlloId = "#1";
		AnagraficaInputDTO anagraficaInput = new AnagraficaInputDTO();

		AuditData auditData = new AuditData();
		auditData.setUserName("JUNIT");

		// key :
		anagraficaInput.setIdCtrl("#1");
		anagraficaInput.setNomeCurva("DEPO-FACILITY");
		anagraficaInput.setCcy("EUR");
		anagraficaInput.setFlagInput("I");
		anagraficaInput.setDataInizio("2021-07-01");
		// Not key:
		anagraficaInput.setNote("unit test update");
		anagraficaInput.setAuditData(auditData);
		anagraficaInput.setCanaleCurva("MANUALE");
		anagraficaInput.setDepth(1);

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.put(uri, controlloId).content(objectMapper.writeValueAsString(anagraficaInput))
				.contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void insertAnagraficaInput() throws Exception {

		String uri = "/anagrafica/input/{controlloId}";

		String controlloId = "#1";
		AnagraficaInputDTO anagraficaInput = new AnagraficaInputDTO();

		// key :
		anagraficaInput.setIdCtrl("#1");
		anagraficaInput.setNomeCurva("SPITI-JPY");
		anagraficaInput.setCcy("JPY");
		anagraficaInput.setFlagInput("O");
		anagraficaInput.setCanaleCurva("MERCATO");
		// Not key:
		anagraficaInput.setNote("Questo nuovo input per #1");
		anagraficaInput.setCodPrimary("P");
		anagraficaInput.setDepth(1);


		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.post(uri, controlloId).content(objectMapper.writeValueAsString(anagraficaInput))
				.contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}
}
