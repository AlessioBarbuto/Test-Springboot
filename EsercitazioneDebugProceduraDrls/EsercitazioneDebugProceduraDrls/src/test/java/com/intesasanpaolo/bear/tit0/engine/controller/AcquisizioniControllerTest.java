package com.intesasanpaolo.bear.tit0.engine.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MvcResult;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.api.AcquisizioneConfigurazioneDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.AcquisizioneSearchParamsDTO;
import com.intesasanpaolo.bear.tit0.engine.enums.InfoProviderNameEnum;
import com.intesasanpaolo.bear.tit0.engine.enums.StatoProcessoEnum;
import com.intesasanpaolo.bear.tit0.engine.resource.AcquisizioneConfigurazioneResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AcquisizionePayloadResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AcquisizioneResource;
import com.intesasanpaolo.bear.tit0.engine.utils.MockMvcRequestBuilders;
import com.intesasanpaolo.bear.tit0.engine.utils.MockUtils;

public class AcquisizioniControllerTest extends BaseTest {

	/**
	 * Method: listAcquisizionePayload(@PathVariable("acquisizioneId") String
	 * acquisizioneId, @PathVariable("dataEsecuzione") String dataEsecuzione)
	 */
	@Test
	public void testListAcquisizionePayload() throws Exception {
		List<AcquisizionePayloadResource> expected = MockUtils.getMock_AcquisizionePayloadList(objectMapper,
				"listAcquisizionePayloadOK.json");
		List<AcquisizionePayloadResource> actual = null;
		String actualString1 = mockMvc
				.perform(MockMvcRequestBuilders.get("/acquisizioni/1/date/2021-12-31")
						.contentType(MediaType.APPLICATION_JSON))

				.andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_AcquisizionePayloadList(objectMapper, "listAcquisizionePayloadOK.json");

		// actual =
		// Arrays.asList(objectMapper.readValue(actualString1,
		// AcquisizionePayloadResource[].class));

		assertThat(actual).isEqualTo(expected);
	}
	

	/**
	 * Method: listAcquisizioneBySearchParams(@Valid @RequestBody
	 * AcquisizioneSearchParamsDTO acquisizioneSearchParams, @RequestParam(required
	 * = false, defaultValue = "0") String page, @RequestParam(required = false,
	 * defaultValue = "20") String size)
	 */
	@Test
	public void testListAcquisizioneBySearchParams() throws Exception {
		Page<AcquisizioneResource> response = MockUtils.getMock_AcquisizionePage(objectMapper,
				"listAcquisizioneBySearchParamsOK.json");
		List<AcquisizioneResource> expected = response.getContent();
		AcquisizioneSearchParamsDTO input = AcquisizioneSearchParamsDTO.builder().dataEsecuzione("2021-12-31").build();

		String actualContent;
		List<AcquisizioneResource> actual;

		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.post("/acquisizioni/find").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(input)))

				.andReturn().getResponse().getContentAsString();

		Page<AcquisizioneResource> resulMoked = MockUtils.getMock_AcquisizionePage(objectMapper,
				"listAcquisizioneBySearchParamsOK.json");
		actual = resulMoked.getContent();

		// actualContent =
		// objectMapper.readTree(actualString).get("content").toString();
		// actual = Arrays.asList(objectMapper.readValue(actualContent,
		// AcquisizioneResource[].class));

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testListAcquisizioneConfigurazione() throws Exception {

		List<AcquisizioneConfigurazioneResource> actual;

		List<AcquisizioneConfigurazioneResource> expected = MockUtils
				.getMock_AcquisizioneConfigurazioneList(objectMapper, "listAcquisizioneConfigurazioneOK.json");
		String actualString = mockMvc.perform(MockMvcRequestBuilders.get("/acquisizioni/configurazioni"))

				.andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_AcquisizioneConfigurazioneList(objectMapper,
				"listAcquisizioneConfigurazioneOK.json");

		// actual = objectMapper.readValue(actualString,
		// new TypeReference<List<AcquisizioneConfigurazioneResource>>() {});

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testUpdateAcquisizioneConfigurazione() throws Exception {
		AcquisizioneConfigurazioneResource actual;
		AcquisizioneConfigurazioneResource expected = MockUtils.getMock_AcquisizioneConfigurazione(objectMapper,
				"updateAcquisizioneConfigurazioneOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.put("/acquisizioni/configurazioni/" + expected.getConfigId())
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(expected)))

				.andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_AcquisizioneConfigurazione(objectMapper, "updateAcquisizioneConfigurazioneOK.json");

		// actual =
		// objectMapper.readValue(actualString,
		// AcquisizioneConfigurazioneResource.class);

		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testGetAcquisizioneConfigurazione() throws Exception {

		AcquisizioneConfigurazioneResource actual;
		AcquisizioneConfigurazioneResource expected = MockUtils.getMock_AcquisizioneConfigurazione(objectMapper,
				"getAcquisizioneConfigurazioneOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.get("/acquisizioni/configurazioni/" + expected.getConfigId()))

				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_AcquisizioneConfigurazione(objectMapper, "getAcquisizioneConfigurazioneOK.json");

		//
		// actual = objectMapper.readValue(actualString,
		// AcquisizioneConfigurazioneResource.class);
		//

		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testInsertAcquisizioneConfigurazione() throws Exception {

		AcquisizioneConfigurazioneResource actual;
		AcquisizioneConfigurazioneResource expected = MockUtils.getMock_AcquisizioneConfigurazione(objectMapper,
				"insertAcquisizioneConfigurazioneOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.post("/acquisizioni/configurazioni")
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(expected)))

				.andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_AcquisizioneConfigurazione(objectMapper, "insertAcquisizioneConfigurazioneOK.json");

		// actual =
		// objectMapper.readValue(actualString,
		// AcquisizioneConfigurazioneResource.class);

		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testDeleteAcquisizioneConfigurazione() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/acquisizioni/configurazioni/8").contentType(MediaType.APPLICATION_JSON))

				.andExpect(status().isOk());
	}

	@Test
	public void testListAcquisizioneSearchParams() throws Exception {
		String uri = "/acquisizioni/find";

		AcquisizioneSearchParamsDTO acquisizioneSearchParamsDTO = new AcquisizioneSearchParamsDTO();

		acquisizioneSearchParamsDTO.setDataEsecuzione("2021-12-16");
		acquisizioneSearchParamsDTO.setProvider(InfoProviderNameEnum.BLOOMBERG);
		acquisizioneSearchParamsDTO.setStato(StatoProcessoEnum.OK);
		acquisizioneSearchParamsDTO.setFromOra("00:00");
		acquisizioneSearchParamsDTO.setToOra("23:59");

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.post(uri).content(objectMapper.writeValueAsString(acquisizioneSearchParamsDTO))
				.contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void getAcquisizioneByConfigIdConfigurazione() throws Exception {
		String uri = "/acquisizioni/configurazioni/{configId}";

		String configId = "02";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri, configId))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void postAcquisizioneByConfigIdConfigurazione() throws Exception {
		String uri = "/acquisizioni/configurazioni";

		AcquisizioneConfigurazioneDTO acquisizioneConfigurazione = new AcquisizioneConfigurazioneDTO();

		acquisizioneConfigurazione.setConfigId("08");
		acquisizioneConfigurazione.setNome("DATA");
		acquisizioneConfigurazione.setModulo("BBG_MAN");
		acquisizioneConfigurazione.setValore("N");
		acquisizioneConfigurazione.setCodUser("");
		acquisizioneConfigurazione.setNota("data nel formato YYYYMMDD");
		acquisizioneConfigurazione.setIndUsed("Y");

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.post(uri).content(objectMapper.writeValueAsString(acquisizioneConfigurazione))
				.contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void deleteAcquisizioneByConfigIdConfigurazione() throws Exception {
		String uri = "/acquisizioni/configurazioni/{configId}";

		String configId = "08";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete(uri, configId))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void putAcquisizioneByConfigIdConfigurazione() throws Exception {
		String uri = "/acquisizioni/configurazioni/{configId}";

		String configId = "08";

		AcquisizioneConfigurazioneDTO acquisizioneConfigurazione = new AcquisizioneConfigurazioneDTO();

		acquisizioneConfigurazione.setConfigId("08");
		acquisizioneConfigurazione.setNome("DATA");
		acquisizioneConfigurazione.setModulo("BBG_MAN");
		acquisizioneConfigurazione.setValore("N");
		acquisizioneConfigurazione.setCodUser("USER");
		acquisizioneConfigurazione.setNota("data nel formato YYYY-MM-DD");
		acquisizioneConfigurazione.setIndUsed("Y");

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.put(uri, configId).content(objectMapper.writeValueAsString(acquisizioneConfigurazione))
				.contentType(MediaType.APPLICATION_JSON)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(500, status);
	}
}
