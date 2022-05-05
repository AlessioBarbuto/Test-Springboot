package com.intesasanpaolo.bear.tit0.engine.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.api.AnagraficaDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.AnagraficaSearchParamsDTO;
import com.intesasanpaolo.bear.tit0.engine.model.api.AuditData;

/**
 * AnagraficaControlliController Tester.
 *
 * @author <Roberto Spagnuolo>
 * @since
 * 
 *        <pre>
 * dic 30, 2021
 *        </pre>
 *
 * @version 1.0
 */
public class AnagraficaControlliControllerTest extends BaseTest {

	/**
	 * Method: getListAnagControllo() Description:"Recupera la lista dell'
	 * Anagrafica"
	 */
	@Test
	public void testGetListAnagControllo() throws Exception {
		String uri = "/anagrafica";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	/**
	 * Method: listAnagraficaBySearchParams(@Valid @RequestBody
	 * AnagraficaSearchParamsDTO anagraficaSearchParams, @RequestParam(required =
	 * false, defaultValue = "0") String page, @RequestParam(required = false,
	 * defaultValue = "20") String size)
	 */
	@Test
	public void testListAnagraficaBySearchParams() throws Exception {

		String uri = "/anagrafica/find";

		AnagraficaSearchParamsDTO anagraficaSearchParams = new AnagraficaSearchParamsDTO();

		anagraficaSearchParams.setIdCtrl("#4");

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.post(uri).content(objectMapper.writeValueAsString(anagraficaSearchParams))
				.contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	/** Method: getAnagControllo(@PathVariable("controlloId") String controlloId) */
	@Test
	public void testGetAnagControllo() throws Exception {
		String uri = "/anagrafica/{controlloId}";

		String controlloId = "#3";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri, controlloId))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	/**
	 * Method: updateAnagControllo(@Valid @RequestBody AnagraficaDTO
	 * anagrafica, @PathVariable("controlloId") String controlloId)
	 */
	@Test
	public void testUpdateAnagControllo() throws Exception {
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

	/**
	 * Method: getListAnagInputOutputControllo(@PathVariable("controlloId") String
	 * controlloId) Description:"Recupera la lista di Input e Output dell'
	 * Anagrafica"
	 */
	@Test
	public void testGetListAnagInputOutputControllo() throws Exception {
		String uri = "/anagrafica/input/{controlloId}";

		String controlloId = "#3";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri, controlloId))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}
}
