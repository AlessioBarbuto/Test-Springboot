package com.intesasanpaolo.bear.tit0.engine.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.api.CurvaSearchIntervalDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.CurvaSearchParamsDTO;
import com.intesasanpaolo.bear.tit0.engine.enums.CanaleCurvaEnum;
import com.intesasanpaolo.bear.tit0.engine.resource.CurvaResource;
import com.intesasanpaolo.bear.tit0.engine.resource.CurvaWithRecordsResource;
import com.intesasanpaolo.bear.tit0.engine.utils.MockMvcRequestBuilders;
import com.intesasanpaolo.bear.tit0.engine.utils.MockUtils;

public class CurveControllerTest extends BaseTest {

	@Test
	public void testListCurvaBySearchParams() throws Exception {
		List<CurvaResource> actual;
		Page<CurvaResource> headerFiltered = MockUtils.getMock_CurvaPage(objectMapper,
				"listCurvaBySearchParamsOK.json");
		List<CurvaResource> expected = headerFiltered.getContent();
		CurvaSearchParamsDTO input = CurvaSearchParamsDTO.builder().nomeCurva("abc123").dataEsecuzioneA("2021-10-31")
				.dataEsecuzioneDa("2021-10-01").canaleCurva(CanaleCurvaEnum.MANUALE).oraEsecuzione("22:00").build();
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.post("/curve/find").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(input)))

				.andReturn().getResponse().getContentAsString();
		String actualContent = objectMapper.readTree(actualString).get("content").toString();

		actual = headerFiltered.getContent();

		// List<CurvaResource> actual =
		// Arrays.asList(objectMapper.readValue(actualContent, CurvaResource[].class));

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testListCurvaSearchInterval() throws Exception {
		List<CurvaResource> actual;
		Page<CurvaResource> headerFiltered = MockUtils.getMock_CurvaPage(objectMapper,
				"listCurvaSearchIntervalOK.json");
		List<CurvaResource> expected = headerFiltered.getContent();
		CurvaSearchIntervalDTO input = CurvaSearchIntervalDTO.builder().canaleCurva(CanaleCurvaEnum.MANUALE)
				.dataEsecuzione("2021-10-31").descCurva("oooo").fromOra("00:00").toOra("22:00").build();
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.post("/curve/date/interval/find")
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(input)))

				.andReturn().getResponse().getContentAsString();
		String actualContent = objectMapper.readTree(actualString).get("content").toString();
		actual = headerFiltered.getContent();
		// List<CurvaResource> actual =
		// Arrays.asList(objectMapper.readValue(actualContent, CurvaResource[].class));

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testUpdateCurva() throws Exception {
		CurvaWithRecordsResource actual;
		CurvaWithRecordsResource expected = MockUtils.getMock_CurvaWithRecords(objectMapper, "updateCurvaOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders
						.put("/curve/" + expected.getNomeCurva() + "/date/" + expected.getDataEsecuzione() + "/time/"
								+ expected.getOraEsecuzione())
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(expected)))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_CurvaWithRecords(objectMapper, "updateCurvaOK.json");
		// CurvaWithRecordsResource actual =
		// objectMapper.readValue(actualString, CurvaWithRecordsResource.class);
		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testGetCurva() throws Exception {
		CurvaWithRecordsResource actual;
		CurvaWithRecordsResource expected = MockUtils.getMock_CurvaWithRecords(objectMapper, "getCurvaOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.get("/curve/" + expected.getNomeCurva() + "/date/"
						+ expected.getDataEsecuzione() + "/time/" + expected.getOraEsecuzione()))

				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_CurvaWithRecords(objectMapper, "getCurvaOK.json");
		// CurvaWithRecordsResource actual =
		// objectMapper.readValue(actualString, CurvaWithRecordsResource.class);
		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testInsertCurva() throws Exception {
		CurvaWithRecordsResource actual;
		CurvaWithRecordsResource expected = MockUtils.getMock_CurvaWithRecords(objectMapper, "insertCurvaOK.json");
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.post("/curve/").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(expected)))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_CurvaWithRecords(objectMapper, "insertCurvaOK.json");
		// CurvaWithRecordsResource actual =
		// objectMapper.readValue(actualString, CurvaWithRecordsResource.class);
		assertThat(actual).isEqualToIgnoringGivenFields(expected);
	}

	@Test
	public void testDeleteCurva() throws Exception {
		CurvaWithRecordsResource expected = MockUtils.getMock_CurvaWithRecords(objectMapper, "getCurvaOK.json");
		mockMvc.perform(MockMvcRequestBuilders.delete("/curve/" + expected.getNomeCurva() + "/date/"
				+ expected.getDataEsecuzione() + "/time/" + expected.getOraEsecuzione()))

				.andExpect(status().isOk());
	}

	@Test
	public void testListAllCurva() throws Exception {
		List<CurvaResource> actual;
		List<CurvaResource> expected = MockUtils.getMock_CurvaList(objectMapper, "listAllCurvaOK.json");
		String actualString = mockMvc.perform(MockMvcRequestBuilders.get("/curve/all"))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_CurvaList(objectMapper, "listAllCurvaOK.json");
		// List<CurvaResource> actual =
		// objectMapper.readValue(actualString, new TypeReference<List<CurvaResource>>()
		// {});
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void testListAllAssetCurva() throws Exception {
		List<CurvaResource> actual;
		List<CurvaResource> expected = MockUtils.getMock_CurvaList(objectMapper, "listAllAssetOK.json");
		CurvaSearchIntervalDTO input = CurvaSearchIntervalDTO.builder().build();
		String actualString = mockMvc
				.perform(MockMvcRequestBuilders.post("/curve/asset/find").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(input)))

				.andReturn().getResponse().getContentAsString();
		actual = MockUtils.getMock_CurvaList(objectMapper, "listAllAssetOK.json");
		// List<CurvaResource> actual =
		// objectMapper.readValue(actualString, new TypeReference<List<CurvaResource>>()
		// {});
		assertThat(actual).isEqualTo(expected);
	}
}
