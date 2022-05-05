package com.intesasanpaolo.bear.tit0.engine.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MvcResult;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.api.NotaDTO;
import com.intesasanpaolo.bear.tit0.engine.resource.NotaResource;
import com.intesasanpaolo.bear.tit0.engine.utils.MockMvcRequestBuilders;
import com.intesasanpaolo.bear.tit0.engine.utils.MockUtils;

public class NoteControllerTest extends BaseTest {

	@Test
	public void testListNotesByModulo() throws Exception {

		String uri = "/note/modulo/{modulo}";

		String modulo = "CURVE";
		logger.debug(uri);

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri, modulo))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void testInsertNote() throws Exception {

		String uri = "/note";

		NotaDTO nota = new NotaDTO();

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(uri)
						.content(objectMapper.writeValueAsString(nota)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void testDeleteNote() throws Exception {
		String uri = "/note/{idNota}";

		String idNota = "11";

		logger.debug(uri);

		MvcResult mvcResult = mockMvc
				.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete(uri, idNota))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

		String content = objectMapper.readTree(mvcResult.getResponse().getContentAsString()).toPrettyString();

		logger.debug(content);

		Assert.assertEquals(200, status);
	}

	@Test
	public void testListNota() throws Exception {
		List<NotaResource> actual;
		List<NotaResource> expected = MockUtils.getMock_NotaList(objectMapper, "listNotaOK.json");
		String actualString = mockMvc.perform(MockMvcRequestBuilders.get("/note/modulo/test"))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_NotaList(objectMapper, "listNotaOK.json");
		// List<NotaResource> actual =
		// objectMapper.readValue(actualString, new TypeReference<List<NotaResource>>()
		// {});
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testDeleteNota() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/note/abc123"))

				.andExpect(status().isOk());
	}

	@Test
	public void testInsertNota() throws Exception {
		NotaResource actual;
		NotaResource expected = MockUtils.getMock_Nota(objectMapper, "insertNotaOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.post("/note").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(expected)))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_Nota(objectMapper, "insertNotaOK.json");
		// NotaResource actual = objectMapper.readValue(actualString,
		// NotaResource.class);
		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}
}
