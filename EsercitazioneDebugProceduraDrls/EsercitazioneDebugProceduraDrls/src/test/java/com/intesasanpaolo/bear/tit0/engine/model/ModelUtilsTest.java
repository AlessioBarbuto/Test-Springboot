package com.intesasanpaolo.bear.tit0.engine.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.intesasanpaolo.bear.tit0.engine.utils.ConstantFields;
import com.intesasanpaolo.bear.tit0.engine.utils.Constants;
import com.intesasanpaolo.bear.tit0.engine.utils.DailyFrequency;
import com.intesasanpaolo.bear.tit0.engine.utils.Data;
import com.intesasanpaolo.bear.tit0.engine.utils.DayCounter;
import com.intesasanpaolo.bear.tit0.engine.utils.MonthlyFrequency;
import com.intesasanpaolo.bear.tit0.engine.utils.PojoTestUtils;
import com.intesasanpaolo.bear.tit0.engine.utils.WeeklyFrequency;

@RunWith(MockitoJUnitRunner.class)
public class ModelUtilsTest {
	
	@Test
	public void testDailyFrequency() {
		PojoTestUtils.validate(DailyFrequency.class);
		Object o = new DailyFrequency(1);
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testData() {
		PojoTestUtils.validate(Data.class);
		Object o = new Data(1);
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDayCounter() {
		PojoTestUtils.validate(DayCounter.class);
		Object o = new DayCounter();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testMonthlyFrequency() {
		PojoTestUtils.validate(MonthlyFrequency.class);
		Object o = new MonthlyFrequency(1);
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	

	
	@Test
	public void testWeeklyFrequency() {
		PojoTestUtils.validate(WeeklyFrequency.class);
		Object o = new WeeklyFrequency(1);
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testConstants() {
		PojoTestUtils.validate(Constants.class);
		Object o = new Constants();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testConstantFields() {
		PojoTestUtils.validate(ConstantFields.class);
		Object o = new ConstantFields();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

}
