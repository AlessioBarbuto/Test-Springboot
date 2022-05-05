package com.intesasanpaolo.bear.tit0.engine.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ControlloInstanceDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ListInputDataDTO;
import com.intesasanpaolo.bear.tit0.engine.resource.ControlloInstanceResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ControlloResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ListInputDataResource;
import com.intesasanpaolo.bear.tit0.engine.resource.NotaResource;
import com.intesasanpaolo.bear.tit0.engine.resource.OutputDataResource;
import com.intesasanpaolo.bear.tit0.engine.utils.MockMvcRequestBuilders;
import com.intesasanpaolo.bear.tit0.engine.utils.MockUtils;

public class ControlliCurveControllerTest extends BaseTest {

	@Test
	
	public void testListControllo() throws Exception {
		List<ControlloResource> expected = MockUtils.getMock_ControlloList(objectMapper, "listControlloOK.json");
		 mockMvc.perform(MockMvcRequestBuilders.get("/controlli")).andExpect(status().isOk());

		
	}


	@Test
	public void testListInput() throws Exception {
		String uri = "/controlli/{controlloId}/input";
		logger.debug(uri);
		String controlloId = "#1";
		
		ListInputDataResource expected = MockUtils.getMock_ListInputData(objectMapper, "listInputOK.json");
		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri,controlloId))
				.andExpect(status().isOk());
	}

	@Test
	public void testListInputByDate() throws Exception {
		ListInputDataResource expected = MockUtils.getMock_ListInputData(objectMapper, "listInputByDateOK.json");
		String uri = "/controlli/{controlloId}/input/date/" + expected.getDataEsecuzione();
		logger.debug(uri);
		String controlloId = expected.getControlloId();
		
		
		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.get(uri,controlloId))
				.andExpect(status().isInternalServerError());
	}

	@Test
	public void testUpdateAllInput() throws Exception {
		ListInputDataResource expected = MockUtils.getMock_ListInputData(objectMapper, "updateAllInputOK.json");
		
		String uri = "/controlli/{controlloId}/input";
		logger.debug(uri);
		String controlloId = expected.getControlloId();
		
		mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put(uri,controlloId)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(expected)))
				.andExpect(status().isOk());
	}

	@Test
	public void testListInstanceInput() throws Exception {
		ListInputDataResource expected = MockUtils.getMock_ListInputData(objectMapper, "listInstanceInputOK.json");
		
		String uri = "/controlli/{controlloId}/instances/1080/input";
		logger.debug(uri);
		String controlloId = "#5";
		
		
		mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri,controlloId)).andExpect(status().isOk());
	}

	@Test
	public void testUpdateControlloInstance() throws Exception {
		ControlloInstanceResource expected = MockUtils.getMock_ControlloInstance(objectMapper,
				"updateControlloInstanceOK.json");
		
		String uri = "/controlli/{controlloId}/instances/" + expected.getInstanceId();
		logger.debug(uri);
		String controlloId = expected.getControlloId();
		
		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
						.put(uri,controlloId )
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(expected)))
						.andExpect(status().isOk());
	}

	@Test
	public void testGetInstance() throws Exception {
		ControlloInstanceResource expected = MockUtils.getMock_ControlloInstance(objectMapper, "getInstanceOK.json");
		
		String uri = "/controlli/{controlloId}/instances/" + expected.getInstanceId();
		logger.debug(uri);
		String controlloId = expected.getControlloId();
		
		
		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.get(uri,controlloId))
				.andExpect(status().isOk());
	}

	@Test
	public void testStartNewInstance() throws Exception {
		String uri = "/controlli/{controlloId}/start-request";
		logger.debug(uri);
		String controlloId = "#1";

		ListInputDataDTO input = ListInputDataDTO.builder().dataEsecuzione("2021-10-04").orarioCurva("11:00").instanceId("K1234567890").build();
		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(uri, controlloId)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)))
				.andExpect(status().isOk());
	}

	@Test
	public void testStartOldInstance() throws Exception {
		// TODO populate payload
		ListInputDataDTO input = ListInputDataDTO.builder().dataEsecuzione("2022-01-30").build();
		
		String uri = "/controlli/{controlloId}/instances/772/start-request";
		logger.debug(uri);
		String controlloId = "#5";
	
		
		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(uri,controlloId)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)))
				.andExpect(status().isOk());
	}

	@Test
	public void testStopRunningInstance() throws Exception {
		String uri = "/controlli/{controlloId}/instances/772/stop-request";
		logger.debug(uri);
		String controlloId = "#5";
		
		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(uri,controlloId)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testListInstanceOutput() throws Exception {
		String uri = "/controlli/{controlloId}/instances/651/output";
		logger.debug(uri);
		String controlloId = "#5";
		
		List<OutputDataResource> expected = MockUtils.getMock_OutputDataList(objectMapper, "listInstanceOutputOK.json");
		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri,controlloId))
				.andExpect(status().isOk());
	}

	@Test
	public void testListLatestInstance() throws Exception {
		List<ControlloInstanceResource> expected = MockUtils.getMock_ControlloInstanceList(objectMapper,
				"listLatestInstanceOK.json");
		mockMvc.perform(MockMvcRequestBuilders.get("/controlli/instances/latest"))
				.andExpect(status().isOk());
	}

	@Test
	public void testListLatestInstanceByDate() throws Exception {
		List<ControlloInstanceResource> expected = MockUtils.getMock_ControlloInstanceList(objectMapper,
				"listLatestInstanceOK.json");
		mockMvc.perform(MockMvcRequestBuilders.get("/controlli/instances/latest/date/20211231"))
				.andExpect(status().isOk());
	}

	@Test
	public void testListInstanceBySearchParams() throws Exception {
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
		List<ControlloInstanceResource> actual = Arrays
				.asList(objectMapper.readValue(actualContent, ControlloInstanceResource[].class));
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testListNota() throws Exception {
		List<NotaResource> expected = MockUtils.getMock_NotaList(objectMapper, "listNotaOK.json");
		mockMvc.perform(MockMvcRequestBuilders.get("/note/modulo/test"))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeleteNota() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/note/xxx"))
				.andExpect(status().isOk());
	}

	@Test
	public void testInsertNota() throws Exception {
		NotaResource expected = MockUtils.getMock_Nota(objectMapper, "insertNotaOK.json");
		mockMvc.perform(MockMvcRequestBuilders.post("/note").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(expected)))
				.andExpect(status().isOk());
	}
}
