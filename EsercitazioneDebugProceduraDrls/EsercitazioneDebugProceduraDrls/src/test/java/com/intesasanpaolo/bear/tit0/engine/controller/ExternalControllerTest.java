package com.intesasanpaolo.bear.tit0.engine.controller;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.model.api.RunControlApi;

public class ExternalControllerTest extends BaseTest {

	@Test
	public void runControl() throws Exception {

		RunControlApi runControllo = new RunControlApi();

		runControllo.setDtCal("2021-10-06");
		runControllo.setIdCtrl("#5");
		runControllo.setTmsData("09:30");

		String uri = "/external/start-request";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.content(objectMapper.writeValueAsString(runControllo)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}
}
