package com.intesasanpaolo.bear.tit0.engine.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ListInputDataDTO;
import com.intesasanpaolo.bear.tit0.engine.model.drools.OUT;
import com.intesasanpaolo.bear.tit0.engine.model.drools.OUT_list;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonOutput;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EngineServiceTest extends BaseTest {

	@Autowired
	private EngineService engineService;

	@Before
	public void setUp() {
		final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		logger.setLevel(Level.INFO);
	}

	@Test
	@Ignore
	public void TestServiceContInputDto() throws Exception {

		ListInputDataDTO listDataInput = new ListInputDataDTO();
		listDataInput.setOrarioCurva("09:15");
		listDataInput.setDataEsecuzione("2022-03-09");
		Collection<OUT_list> result = engineService.control(listDataInput, "#1", null);

		JsonOutput jsonOutput;
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(engineService);
	}

	@Test
	@Ignore
	public void TestSerContFirst() throws Exception {
		Collection<OUT_list> result = engineService.control("2022-03-09", "SCHEDULER", "#1", "09:17");

		JsonOutput jsonOutput;
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}

	@Test
	@Ignore
	public void TestSerContSecond() throws Exception {
		Collection<OUT_list> result = engineService.control("2022-03-11", "SYSTEM", "#2", "09:15");
		JsonOutput jsonOutput;
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}

	@Test
	@Ignore
	public void TestSerContThird() throws Exception {
		Collection<OUT_list> result = engineService.control("2021-10-06", "SYSTEM", "#3", "11:30");
		JsonOutput jsonOutput;
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}

	@Test
	@Ignore
	public void TestSerContFourth() throws Exception {
		Collection<OUT_list> result = engineService.control("2021-10-06", "SYSTEM", "#4", "12:00");
		JsonOutput jsonOutput;
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}

	@Test
	@Ignore
	public void TestSerContFifth() throws Exception {
		Collection<OUT_list> result = engineService.control("2022-03-11", "SYSTEM", "#5", "09:15");
		JsonOutput jsonOutput;
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}

	@Test
	@Ignore
	public void TestSerContSixth() throws Exception {
		Collection<OUT_list> result = engineService.control("2021-10-06", "SYSTEM", "#6", "11:30");
		JsonOutput jsonOutput;
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}

	// Incorrect result size: expected 1, actual 0
	@Test
	@Ignore
	public void TestSerContSeventh() throws Exception {
		Collection<OUT_list> result = engineService.control("2021-10-06", "SYSTEM", "#7", "11:30");
		JsonOutput jsonOutput;
		assertNotNull(result);
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}

	@Test
	@Ignore
	public void TestSerContEighth() throws Exception {
		Collection<OUT_list> result = engineService.control("2021-10-06", "SYSTEM", "#8", "11:30");
		JsonOutput jsonOutput;
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}

	@Test
	@Ignore
	public void TestSerContTenth() throws Exception {
		Collection<OUT_list> result = engineService.control("2021-10-06", "SYSTEM", "#10", "11:45");
		JsonOutput jsonOutput;
		assertNotNull(result);
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}

	@Test
	@Ignore
	public void TestSerContTwelfth() throws Exception {
		Collection<OUT_list> result = engineService.control("2021-10-06", "SYSTEM", "#12", "12:00");
		JsonOutput jsonOutput;
		assertNotNull(result);
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}

	@Test
	@Ignore
	public void TestSerContEleventh() throws Exception {
		Collection<OUT_list> result = engineService.control("2021-10-06", "SYSTEM", "#11", "12:00");
		JsonOutput jsonOutput;
		assertNotNull(result);
		for (OUT_list outListOUT : result) {
			for (Object item : outListOUT) {
				OUT test = (OUT) item;
				jsonOutput = objectMapper.readValue(test.toString(), JsonOutput.class);
				log.debug("%s", jsonOutput.toString() + "\n");
			}
		}
		assertNotNull(result);
	}
}
