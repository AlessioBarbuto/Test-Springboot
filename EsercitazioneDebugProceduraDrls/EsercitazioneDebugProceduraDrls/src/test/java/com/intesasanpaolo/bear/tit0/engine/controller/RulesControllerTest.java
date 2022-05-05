//package com.intesasanpaolo.bear.tit0.engine.controller;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MvcResult;
//
//import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
//import com.intesasanpaolo.bear.tit0.engine.utils.MockMvcRequestBuilders;
//
//public class RulesControllerTest extends BaseTest {
//
//	@Test
//	public void testGetAllRules() throws Exception {
//		String uri = "/rule/findAll";
//		MvcResult mvcResult = mockMvc
//				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();
//		Assert.assertEquals(200, status);
//	}
//
//	@Test
//	public void testGetBlock() throws Exception {
//		String uri = "/rule/simulator/getBlock/typeXXX/blockYYY";
//		MvcResult mvcResult = mockMvc
//				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();
//		Assert.assertEquals(500, status);
//	}
//
//	@Test
//	public void testGetCategories() throws Exception {
//
//		String uri = "/rule/simulator/getCategories/typeXXX";
//		MvcResult mvcResult = mockMvc
//				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();
//		Assert.assertEquals(500, status);
//	}
//
//	@Test
//	public void testGetAttributesByBlockCommand() throws Exception {
//
//		String uri = "/rule/simulator/getAttributesByBlock/typeXXX/blockYYY";
//		MvcResult mvcResult = mockMvc
//				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();
//		Assert.assertEquals(500, status);
//	}
//
//	@Test
//	public void testGetControlCommand() throws Exception {
//
//		String uri = "/rule/simulator/getControl/1234/typeXXX";
//		MvcResult mvcResult = mockMvc
//				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();
//		Assert.assertEquals(200, status);
//	}
//
//	@Test
//	public void testGetControlsCommand() throws Exception {
//
//		String uri = "/rule/simulator/getControls";
//		MvcResult mvcResult = mockMvc
//				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();
//		Assert.assertEquals(200, status);
//	}
//
//	@Test
//	public void testSaveControlCommand() throws Exception {
//		String actualString = mockMvc
//				.perform(MockMvcRequestBuilders.post("/rule/simulator/saveControl?id=123abc")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(objectMapper.writeValueAsString("bodyyyyyyyyy")))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//		assertThat(actualString).isEqualTo("{\"message\":\"\"}");
//	}
//
//	@Test
//	public void testPutControlCommand() throws Exception {
//		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
//				.put("/rule/simulator/putControl?id=123abc&type=YYY").contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsString("bodyyyyyyyyy"))).andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		Assert.assertEquals(500, status);
//
//	}
//
//	@Test
//	public void testPutControlsCommand() throws Exception {
//		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/rule/simulator/putControls/123abc"))
//				.andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		Assert.assertEquals(500, status);
//	}
//
//}
