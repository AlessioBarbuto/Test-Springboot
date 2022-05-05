package com.intesasanpaolo.bear.tit0.engine.connector.jpaoracle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.model.entity.DvInstance;
import com.intesasanpaolo.bear.tit0.engine.resource.ControlloInstanceResource;
import com.intesasanpaolo.bear.tit0.engine.service.controlli.ListLatestInstanceService;

public class DvInstanceLatestTest extends BaseTest {

	@Autowired
	private ListLatestInstanceService listLatestInstanceService;

	@Test
	public void getInstanceLatest() {
		List<ControlloInstanceResource> controlloInstanceResources = listLatestInstanceService.run();
		assertEquals("#1", controlloInstanceResources.get(0).getControlloId());
	}
}
