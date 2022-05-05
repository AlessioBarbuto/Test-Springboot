package com.intesasanpaolo.bear.tit0.engine.transformers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.intesasanpaolo.bear.tit0.engine.utils.PageableModel;
import com.intesasanpaolo.bear.tit0.engine.utils.PojoTestUtils;
import com.intesasanpaolo.bear.tit0.engine.utils.RestPageImpl;

@RunWith(MockitoJUnitRunner.class)
public class TransformersTest {
	@Test
	public void testPageableModel() {
		PojoTestUtils.validate(PageableModel.class);
	}

	@Test
	public void testRestPageImpl() {
		PojoTestUtils.validate(RestPageImpl.class);
	}
}
