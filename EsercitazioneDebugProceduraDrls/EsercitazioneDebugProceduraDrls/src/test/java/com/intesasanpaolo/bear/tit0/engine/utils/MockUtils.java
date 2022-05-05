package com.intesasanpaolo.bear.tit0.engine.utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intesasanpaolo.bear.tit0.engine.resource.AcquisizioneConfigurazioneResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AcquisizionePayloadResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AcquisizioneResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AnagraficaInputOutputResource;
import com.intesasanpaolo.bear.tit0.engine.resource.AnagraficaResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ControlloInstanceResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ControlloResource;
import com.intesasanpaolo.bear.tit0.engine.resource.CurvaResource;
import com.intesasanpaolo.bear.tit0.engine.resource.CurvaWithRecordsResource;
import com.intesasanpaolo.bear.tit0.engine.resource.ListInputDataResource;
import com.intesasanpaolo.bear.tit0.engine.resource.NotaResource;
import com.intesasanpaolo.bear.tit0.engine.resource.OutputDataResource;


public class MockUtils {

	public static AcquisizioneConfigurazioneResource getMock_AcquisizioneConfigurazione(ObjectMapper objectMapper,
			String mockLocation) throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/acquisizioni/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				AcquisizioneConfigurazioneResource.class);
	}

	public static AcquisizionePayloadResource getMock_AcquisizionePayload(ObjectMapper objectMapper,
			String mockLocation) throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/acquisizioni/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				AcquisizionePayloadResource.class);
	}

	public static AcquisizioneResource getMock_Acquisizione(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/acquisizioni/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				AcquisizioneResource.class);
	}

	public static ControlloInstanceResource getMock_ControlloInstance(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/controlli/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				ControlloInstanceResource.class);
	}

	public static ControlloResource getMock_Controllo(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/controlli/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				ControlloResource.class);
	}

	public static AnagraficaResource getMock_AnagraficaControllo(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/anagrafica/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				AnagraficaResource.class);
	}

	public static CurvaResource getMock_Curva(ObjectMapper objectMapper, String mockLocation) throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/curve/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				CurvaResource.class);
	}

	public static CurvaWithRecordsResource getMock_CurvaWithRecords(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/curve/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				CurvaWithRecordsResource.class);
	}

	public static ListInputDataResource getMock_ListInputData(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/controlli/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				ListInputDataResource.class);
	}

	public static OutputDataResource getMock_OutputData(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/controlli/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				OutputDataResource.class);
	}

	public static List<OutputDataResource> getMock_OutputDataList(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/controlli/" + mockLocation);
		return Arrays.asList(objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				OutputDataResource[].class));
	}

	public static List<AcquisizioneConfigurazioneResource> getMock_AcquisizioneConfigurazioneList(
			ObjectMapper objectMapper, String mockLocation) throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/acquisizioni/" + mockLocation);
		return Arrays.asList(objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				AcquisizioneConfigurazioneResource[].class));
	}

	public static List<AcquisizioneResource> getMock_AcquisizioneList(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/acquisizioni/" + mockLocation);
		return Arrays.asList(objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				AcquisizioneResource[].class));
	}

	public static List<ControlloInstanceResource> getMock_ControlloInstanceList(ObjectMapper objectMapper,
			String mockLocation) throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/controlli/" + mockLocation);
		return Arrays.asList(objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				ControlloInstanceResource[].class));
	}

	public static List<ControlloResource> getMock_ControlloList(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/controlli/" + mockLocation);
		return Arrays.asList(objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				ControlloResource[].class));
	}

	public static List<AnagraficaResource> getMock_AnagraficaControlloList(ObjectMapper objectMapper,
			String mockLocation) throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/anagrafica/" + mockLocation);
		return Arrays.asList(objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				AnagraficaResource[].class));
	}

	public static Page<AnagraficaResource> getMock_AnagraficaControlloPage(ObjectMapper objectMapper,
			String mockLocation) throws IOException {
		File schemaJsonFile = ResourceUtils.getFile("./src/main/resources/mocks/anagrafica/" + mockLocation);
		String pageJson = objectMapper.readTree(schemaJsonFile).get("response").get("jsonBody").toString();
		return objectMapper.readValue(pageJson, new TypeReference<RestPageImpl<AnagraficaResource>>() {
		});
	}

	public static List<CurvaResource> getMock_CurvaList(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/curve/" + mockLocation);
		return Arrays.asList(objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				CurvaResource[].class));
	}

	public static Page<CurvaResource> getMock_CurvaPage(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File schemaJsonFile = ResourceUtils.getFile("./src/main/resources/mocks/curve/" + mockLocation);
		String pageJson = objectMapper.readTree(schemaJsonFile).get("response").get("jsonBody").toString();
		return objectMapper.readValue(pageJson, new TypeReference<RestPageImpl<CurvaResource>>() {
		});
	}

	public static Page<ControlloInstanceResource> getMock_ControlloInstancePage(ObjectMapper objectMapper,
			String mockLocation) throws IOException {
		File schemaJsonFile = ResourceUtils.getFile("./src/main/resources/mocks/controlli/" + mockLocation);
		String pageJson = objectMapper.readTree(schemaJsonFile).get("response").get("jsonBody").toString();
		return objectMapper.readValue(pageJson, new TypeReference<RestPageImpl<ControlloInstanceResource>>() {
		});
	}

	public static List<AcquisizionePayloadResource> getMock_AcquisizionePayloadList(ObjectMapper objectMapper,
			String mockLocation) throws IOException {

		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/acquisizioni/" + mockLocation);
		return Arrays.asList(objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				AcquisizionePayloadResource[].class));
	}

	public static Page<AcquisizionePayloadResource> getMock_AcquisizionePayloadPage(ObjectMapper objectMapper,
			String mockLocation) throws IOException {
		File schemaJsonFile = ResourceUtils.getFile("./src/main/resources/mocks/acquisizioni/" + mockLocation);
		String pageJson = objectMapper.readTree(schemaJsonFile).get("response").get("jsonBody").toString();
		return objectMapper.readValue(pageJson, new TypeReference<RestPageImpl<AcquisizionePayloadResource>>() {
		});
	}

	public static Page<AcquisizioneResource> getMock_AcquisizionePage(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File schemaJsonFile = ResourceUtils.getFile("./src/main/resources/mocks/acquisizioni/" + mockLocation);
		String pageJson = objectMapper.readTree(schemaJsonFile).get("response").get("jsonBody").toString();
		return objectMapper.readValue(pageJson, new TypeReference<RestPageImpl<AcquisizioneResource>>() {
		});
	}

	public static List<NotaResource> getMock_NotaList(ObjectMapper objectMapper, String mockLocation)
			throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/note/" + mockLocation);
		return Arrays.asList(objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				NotaResource[].class));
	}

	public static NotaResource getMock_Nota(ObjectMapper objectMapper, String mockLocation) throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/note/" + mockLocation);
		return objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				NotaResource.class);
	}

	public static List<AnagraficaInputOutputResource> getMock_AnagraficaInputOutputList(ObjectMapper objectMapper,
			String mockLocation) throws IOException {
		File jsonFile = ResourceUtils.getFile("./src/main/resources/mocks/anagrafica/" + mockLocation);
		return Arrays.asList(objectMapper.treeToValue(objectMapper.readTree(jsonFile).get("response").get("jsonBody"),
				AnagraficaInputOutputResource[].class));
	}
}
