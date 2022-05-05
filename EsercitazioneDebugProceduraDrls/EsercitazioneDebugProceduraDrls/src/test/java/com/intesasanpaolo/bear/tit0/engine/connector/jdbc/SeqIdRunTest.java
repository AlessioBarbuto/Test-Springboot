package com.intesasanpaolo.bear.tit0.engine.connector.jdbc;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * @Created  30/12/2021 - 14:37
 * @Project core-tit-engine-v1
 * @Auhtor Roberto Spagnuolo
 */

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.service.impl.IdRunSequenceService;

public class SeqIdRunTest extends BaseTest {
	/* Created by Roberto Spagnuolo on 30/12/2021 */
	@Autowired
	private IdRunSequenceService idRunSequenceService;

	/** Method: getIdRun() */
	@Test
	@Ignore
	public void testGetIdRun() throws Exception {

		Long test = idRunSequenceService.getIdRun();

		Assert.assertNotNull(test);
	}
}
