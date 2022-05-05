package com.intesasanpaolo.bear.tit0.engine.command;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intesasanpaolo.bear.tit0.engine.config.BaseTest;
import com.intesasanpaolo.bear.tit0.engine.model.bean.DtRulesBean;

public class DroolsHotSwapFileTest extends BaseTest {

	@Autowired
	private DroolsHotSwapFile droolsHotSwapFile;

	@Test
	public void getDtRulesBean() {
		DtRulesBean dtRulesBean = droolsHotSwapFile.getFileInfo("#1");
		assertEquals("#1", dtRulesBean.getIdCtrl());
	}
}
