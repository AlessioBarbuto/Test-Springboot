package com.intesasanpaolo.bear.tit0.engine.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.intesasanpaolo.bear.tit0.engine.dto.api.AcquisizioneConfigurazioneDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.AcquisizioneSearchParamsDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.AnagraficaDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.AnagraficaInputDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.AnagraficaSearchParamsDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ConfigurazioniDealSearchParamDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ControlloDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ControlloInstanceDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.CurvaSearchIntervalDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.CurvaSearchParamsDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.CurvaWithRecordsDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.DealInputDataDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.InstanceSearchParamsDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ListDealDataDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ListInputDataDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.NotaDTO;
import com.intesasanpaolo.bear.tit0.engine.utils.PojoTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class ModelDtoApiTest {


	@Test
	public void testAcquisizioneConfigurazioneDTO() {
		PojoTestUtils.validate(AcquisizioneConfigurazioneDTO.class);
		Object o = new AcquisizioneConfigurazioneDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testAcquisizioneSearchParamsDTO() {
		PojoTestUtils.validate(AcquisizioneSearchParamsDTO.class);
		Object o = new AcquisizioneSearchParamsDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testAnagraficaDTO() {
		PojoTestUtils.validate(AnagraficaDTO.class);
		Object o = new AnagraficaDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testAnagraficaInputDTO() {
		PojoTestUtils.validate(AnagraficaInputDTO.class);
		Object o = new AnagraficaInputDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testAnagraficaSearchParamsDTO() {
		PojoTestUtils.validate(AnagraficaSearchParamsDTO.class);
		Object o = new AnagraficaSearchParamsDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testConfigurazioniDealSearchParamDTO() {
		PojoTestUtils.validate(ConfigurazioniDealSearchParamDTO.class);
		Object o = new ConfigurazioniDealSearchParamDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testControlloDTO() {
		PojoTestUtils.validate(ControlloDTO.class);
		Object o = new ControlloDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testControlloInstanceDTO() {
		PojoTestUtils.validate(ControlloInstanceDTO.class);
		Object o = new ControlloInstanceDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testCurvaSearchIntervalDTO() {
		PojoTestUtils.validate(CurvaSearchIntervalDTO.class);
		Object o = new CurvaSearchIntervalDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testCurvaSearchParamsDTO() {
		PojoTestUtils.validate(CurvaSearchParamsDTO.class);
		Object o = new CurvaSearchParamsDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testCurvaWithRecordsDTO() {
		PojoTestUtils.validate(CurvaWithRecordsDTO.class);
		Object o = new CurvaWithRecordsDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDealInputDataDTO() {
		PojoTestUtils.validate(DealInputDataDTO.class);
		Object o = new DealInputDataDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testInstanceSearchParamsDTO() {
		PojoTestUtils.validate(InstanceSearchParamsDTO.class);
		Object o = new InstanceSearchParamsDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testListDealDataDTO() {
		PojoTestUtils.validate(ListDealDataDTO.class);
		Object o = new ListDealDataDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testListInputDataDTO() {
		PojoTestUtils.validate(ListInputDataDTO.class);
		Object o = new ListInputDataDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testNotaDTO() {
		PojoTestUtils.validate(NotaDTO.class);
		Object o = new NotaDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
}
