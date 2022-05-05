package com.intesasanpaolo.bear.tit0.engine.smoke;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;

public class ReadinessIntegrationTest extends BaseTest {

	@Test
	public void whenHitReadinessController_okStatusCodeIsReturned() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/actuator/isp/healthy")).andDo(print()).andExpect(status().isOk());
	}
}
