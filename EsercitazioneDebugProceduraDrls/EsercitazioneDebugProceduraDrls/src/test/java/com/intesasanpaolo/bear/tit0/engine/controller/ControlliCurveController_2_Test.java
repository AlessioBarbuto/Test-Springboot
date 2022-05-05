package com.intesasanpaolo.bear.tit0.engine.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ControlloDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ControlloInstanceDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.CurvaSearchIntervalDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.CurvaSearchParamsDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.InstanceSearchParamsDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ListInputDataDTO;
import com.intesasanpaolo.bear.tit0.engine.model.api.AuditData;
import com.intesasanpaolo.bear.tit0.engine.resource.ControlloInstanceResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ControlloResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ListInputDataResource;
import com.intesasanpaolo.bear.tit0.engine.resource.OutputDataResource;
import com.intesasanpaolo.bear.tit0.engine.utils.MockUtils;

public class ControlliCurveController_2_Test extends BaseTest {

	private static final Logger logger = LoggerUtils.getLogger(ControlliCurveController_2_Test.class);

	private static final String FILES_CURVA_SEARCH_MERCATO = "/mocks/curve/curvaSearchMercatoParams.json";

	private static final String FILES_CURVA_SEARCH_MANUAL = "/mocks/curve/curvaSearchManualParams.json";

	private static final String FILES_CURVA_INTERNAL = "/mocks/curve/requestCurvaIntervalOK.json";

	private static final String FILES_INSTANCE_SEARCH = "/mocks/controlli/instanceParams.json";

	/** Start Controller Test */
	@Test
	public void testListSchedulazioneControllo() throws Exception {
		List<ControlloResource> actual;
		List<ControlloResource> expected = MockUtils.getMock_ControlloList(objectMapper,
				"listSchedulazioneControlloOK.json");
		String actualString = mockMvc.perform(MockMvcRequestBuilders.get("/controlli"))

				.andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_ControlloList(objectMapper, "listSchedulazioneControlloOK.json");

		// List<ControlloResource> actual =
		// objectMapper.readValue(actualString, new
		// TypeReference<List<ControlloResource>>()
		// {});

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testGetControlloByIdAndSchedulazione() throws Exception {
		ControlloResource actual;
		ControlloResource expected = MockUtils.getMock_Controllo(objectMapper,
				"getControlloByIdAndSchedulazioneOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.get(
						"/controlli/{controlloId}/schedulazione/{schedulazione}/date/{dataInizio}",
						expected.getControlloId(), expected.getSchedulazione(), expected.getDataInizio()))

				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_Controllo(objectMapper, "getControlloByIdAndSchedulazioneOK.json");

		// ControlloResource actual = objectMapper.readValue(actualString,
		// ControlloResource.class);

		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testUpdateByIdAndSchedulazioneControllo() throws Exception {
		ControlloResource actual;
		ControlloResource expected = MockUtils.getMock_Controllo(objectMapper,
				"updateByIdAndSchedulazioneControlloOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders
						.put("/controlli/{controlloId}/schedulazione/{schedulazione}/date/{dataInizio}",
								expected.getControlloId(), expected.getSchedulazione(), expected.getDataInizio())
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(expected)))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_Controllo(objectMapper, "updateByIdAndSchedulazioneControlloOK.json");

		// ControlloResource actual = objectMapper.readValue(actualString,
		// ControlloResource.class);
		//
		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testListInput() throws Exception {
		ListInputDataResource actual;
		ListInputDataResource expected = MockUtils.getMock_ListInputData(objectMapper, "listInputOK.json");
		mockMvc.perform(MockMvcRequestBuilders.get("/controlli/" + expected.getControlloId() + "/input"))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_ListInputData(objectMapper, "listInputOK.json");
		// ListInputDataResource actual =
		// objectMapper.readValue(actualString, ListInputDataResource.class);

		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testListInputByDate() throws Exception {
		ListInputDataResource actual;
		ListInputDataResource expected = MockUtils.getMock_ListInputData(objectMapper, "listInputByDateOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders
						.get("/controlli/" + expected.getControlloId() + "/input/date/" + expected.getDataEsecuzione()))

				.andExpect(status().isInternalServerError()).andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_ListInputData(objectMapper, "listInputByDateOK.json");
		// ListInputDataResource actual =
		// objectMapper.readValue(actualString, ListInputDataResource.class);
		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testUpdateAllInput() throws Exception {

		ListInputDataResource actual;
		ListInputDataResource expected = MockUtils.getMock_ListInputData(objectMapper, "updateAllInputOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.put("/controlli/" + expected.getControlloId() + "/input")
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(expected)))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_ListInputData(objectMapper, "updateAllInputOK.json");
		// ListInputDataResource actual =
		// objectMapper.readValue(actualString, ListInputDataResource.class);
		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testListInstanceInput() throws Exception {
		ListInputDataResource expected = MockUtils.getMock_ListInputData(objectMapper, "listInstanceInputOK.json");
		mockMvc.perform(MockMvcRequestBuilders
				.get("/controlli/" + expected.getControlloId() + "/instances/" + expected.getInstanceId() + "/input"))

				.andExpect(status().isNotFound());
	}

	@Test
	public void testUpdateControlloInstance() throws Exception {
		ControlloInstanceResource actual;
		ControlloInstanceResource expected = MockUtils.getMock_ControlloInstance(objectMapper,
				"updateControlloInstanceOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders
						.put("/controlli/" + expected.getControlloId() + "/instances/" + expected.getInstanceId())
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(expected)))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_ControlloInstance(objectMapper, "updateControlloInstanceOK.json");
		// ControlloInstanceResource actual =
		// objectMapper.readValue(actualString, ControlloInstanceResource.class);
		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testGetInstance() throws Exception {
		ControlloInstanceResource actual;
		ControlloInstanceResource expected = MockUtils.getMock_ControlloInstance(objectMapper, "getInstanceOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders
						.get("/controlli/" + expected.getControlloId() + "/instances/" + expected.getInstanceId()))

				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_ControlloInstance(objectMapper, "getInstanceOK.json");
		// ControlloInstanceResource actual =
		// objectMapper.readValue(actualString, ControlloInstanceResource.class);
		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testStartNewInstance() throws Exception {
		// TODO populate payload
		ListInputDataDTO input = ListInputDataDTO.builder().build();
		mockMvc.perform(MockMvcRequestBuilders.post("/controlli/1/start-request")
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)))

				.andExpect(status().isOk());
	}

	@Test
	public void testStartOldInstance() throws Exception {
		// TODO populate payload
		ListInputDataDTO input = ListInputDataDTO.builder().build();
		mockMvc.perform(MockMvcRequestBuilders.post("/controlli/1/instances/1/start-request")
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)))

				.andExpect(status().isInternalServerError());
	}

	@Test
	public void testStopRunningInstance() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/controlli/1/instances/1/stop-request")
				.contentType(MediaType.APPLICATION_JSON))

				.andExpect(status().isOk());
	}

	@Test
	public void testListInstanceOutput() throws Exception {
		List<OutputDataResource> actual;
		List<OutputDataResource> expected = MockUtils.getMock_OutputDataList(objectMapper, "listInstanceOutputOK.json");
		String actualString = mockMvc.perform(MockMvcRequestBuilders.get("/controlli/1/instances/1/output"))

				.andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_OutputDataList(objectMapper, "listInstanceOutputOK.json");
		// List<OutputDataResource> actual =
		// objectMapper.readValue(actualString, new
		// TypeReference<List<OutputDataResource>>()
		// {});
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testListLatestInstance() throws Exception {
		List<ControlloInstanceResource> actual;
		List<ControlloInstanceResource> expected = MockUtils.getMock_ControlloInstanceList(objectMapper,
				"listLatestInstanceOK.json");
		String actualString = mockMvc.perform(MockMvcRequestBuilders.get("/controlli/instances/latest"))

				.andReturn().getResponse().getContentAsString();

		actual = MockUtils.getMock_ControlloInstanceList(objectMapper, "listLatestInstanceOK.json");
		// List<ControlloInstanceResource> actual = objectMapper.readValue(actualString,
		// new TypeReference<List<ControlloInstanceResource>>() {});

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testListLatestInstanceByDate() throws Exception {
		List<ControlloInstanceResource> actual;
		List<ControlloInstanceResource> expected = MockUtils.getMock_ControlloInstanceList(objectMapper,
				"listLatestInstanceOK.json");
		String actualString = mockMvc.perform(MockMvcRequestBuilders.get("/controlli/instances/latest/date/20211231"))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_ControlloInstanceList(objectMapper, "listLatestInstanceOK.json");
		// List<ControlloInstanceResource> actual = objectMapper.readValue(actualString,
		// new TypeReference<List<ControlloInstanceResource>>() {});
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testListInstanceBySearchParams() throws Exception {
		List<ControlloInstanceResource> actual;
		Page<ControlloInstanceResource> response = MockUtils.getMock_ControlloInstancePage(objectMapper,
				"listInstanceBySearchParamsOK.json");
		List<ControlloInstanceResource> expected = response.getContent();
		// TODO populate payload
		ControlloInstanceDTO input = ControlloInstanceDTO.builder().build();
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.post("/controlli/instances/find")
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)))

				.andReturn().getResponse().getContentAsString();
		String actualContent = objectMapper.readTree(actualString).get("content").toString();

		actual = response.getContent();
		// List<ControlloInstanceResource> actual =
		// Arrays.asList(objectMapper.readValue(actualContent,
		// ControlloInstanceResource[].class));
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void getInstanceLatestByDate() throws Exception {

		String uri = "/controlli/instances/latest/date/{dataEsecuzione}";

		logger.debug(uri);

		String dataEsecuzione = "2021-10-06";
		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri, dataEsecuzione))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void getListConfigDataInput() throws Exception {

		String uri = "/controlli/{controlloId}/input/date/{dataEsecuzione}";
		logger.debug(uri);
		String controlloId = "#7";
		String dataEsecuzione = "2021-10-06";
		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.get(uri, controlloId, dataEsecuzione)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void getInstanceLatest() throws Exception {

		String uri = "/controlli/instances/latest";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void getListInputInstanceByControlId() throws Exception {

		String uri = "/controlli/{controlloId}/input";
		logger.debug(uri);
		String controlloId = "#5";

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri, controlloId))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void getListInputInstance() throws Exception {

		String uri = "/controlli/{controlloId}/instances/{instanceId}/input";
		logger.debug(uri);
		String controlloId = "#5";
		String instanceId = "f8dac8b5-af5f-4c6e-9cb2-a7a1d8452460";

		MvcResult mvcResult = mockMvc.perform(
				org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri, controlloId, instanceId))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(404, status);
	}

	@Test
	public void getListOutputInstance() throws Exception {

		String uri = "/controlli/{controlloId}/instances/{instanceId}/output";
		logger.info(uri);
		String controlloId = "#5";
		String instanceId = "f8dac8b5-af5f-4c6e-9cb2-a7a1d8452460";

		MvcResult mvcResult = mockMvc.perform(
				org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri, controlloId, instanceId))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.info("\n" + content);

		Assert.assertEquals(404, status);
	}

	@Test
	public void getCurveInterval() throws Exception {

		CurvaSearchIntervalDTO curvaSearchInterval = objectMapper
				.readValue(getClass().getResourceAsStream(FILES_CURVA_INTERNAL), CurvaSearchIntervalDTO.class);

		String uri = "/curve/date/interval/find";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.content(objectMapper.writeValueAsString(curvaSearchInterval)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void postCurveMercatoFind() throws Exception {

		CurvaSearchParamsDTO curvaSearchParams = objectMapper
				.readValue(getClass().getResourceAsStream(FILES_CURVA_SEARCH_MERCATO), CurvaSearchParamsDTO.class);

		String uri = "/curve/find";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.content(objectMapper.writeValueAsString(curvaSearchParams)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void postCurveFindAll() throws Exception {

		CurvaSearchIntervalDTO curvaSearchIntervalDTO = new CurvaSearchIntervalDTO();

		curvaSearchIntervalDTO.setDataEsecuzione("2021-10-06");

		String uri = "/curve/asset/find";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).content(objectMapper.writeValueAsString(curvaSearchIntervalDTO))
						.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void postCurveManualFind() throws Exception {

		CurvaSearchParamsDTO curvaSearchParams = objectMapper
				.readValue(getClass().getResourceAsStream(FILES_CURVA_SEARCH_MANUAL), CurvaSearchParamsDTO.class);

		String uri = "/curve/find";
		// String page = "page";
		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.content(objectMapper.writeValueAsString(curvaSearchParams)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void getAllCurveDescription() throws Exception {

		String uri = "/curve/all";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void getInstanceFind() throws Exception {

		InstanceSearchParamsDTO instanceSearchParamsDTO = objectMapper
				.readValue(getClass().getResourceAsStream(FILES_INSTANCE_SEARCH), InstanceSearchParamsDTO.class);

		String uri = "/controlli/instances/find";

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).content(objectMapper.writeValueAsString(instanceSearchParamsDTO))
						.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void getCurvaByNameAndDateAndTimeManual() throws Exception {

		String uri = "/curve/{nomeCurva}/date/{dataEsecuzione}/time/{oraEsecuzione}";

		String nomeCurva = "DYN-SPITI3-USD";
		String dataEsecuzione = "2021-10-06";
		String oraEsecuzione = "2021-10-06 00:00:00";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.get(uri, nomeCurva, dataEsecuzione, oraEsecuzione)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(500, status);
	}

	@Test
	public void getCurvaByNameAndDateAndTimeMercato() throws Exception {

		String uri = "/curve/{nomeCurva}/date/{dataEsecuzione}/time/{oraEsecuzione}";

		String nomeCurva = "SPITI3-EUR";
		String dataEsecuzione = "2021-10-06";
		String oraEsecuzione = "2021-10-06 09:15:00";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.get(uri, nomeCurva, dataEsecuzione, oraEsecuzione)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void getControlli() throws Exception {

		String uri = "/controlli";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void getControlliByKey() throws Exception {

		String uri = "/controlli/{controlloId}/schedulazione/{schedulazione}/date/{dataInizio}";
		String controlloId = "#3";
		String schedulazione = "11:45";
		String dataInizio = "2021-12-24";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.get(uri, controlloId, schedulazione, dataInizio)).andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void putControlliByKey() throws Exception {

		String uri = "/controlli/{controlloId}/schedulazione/{schedulazione}/date/{dataInizio}";
		String controlloId = "#3";
		String schedulazione = "11:35";
		String dataInizio = "2021-12-24";

		AuditData auditData = new AuditData();
		auditData.setUserId("U0J8452");
		auditData.setUserName("U0J8452");
		ControlloDTO controllo = new ControlloDTO();
		controllo.setAuditData(auditData);
		controllo.setNote("Test Put 2 change key");
		controllo.setSchedulazione("11:25");
		controllo.setControlloId("#3");
		controllo.setOrarioCurva("11:20");
		logger.debug(uri);

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.put(uri, controlloId, schedulazione, dataInizio)
						.content(objectMapper.writeValueAsString(controllo)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(500, status);
	}
}
