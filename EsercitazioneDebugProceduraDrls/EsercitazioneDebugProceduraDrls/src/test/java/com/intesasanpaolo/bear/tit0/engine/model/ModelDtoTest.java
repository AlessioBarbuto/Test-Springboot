package com.intesasanpaolo.bear.tit0.engine.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.intesasanpaolo.bear.tit0.engine.dto.CurveDto;
import com.intesasanpaolo.bear.tit0.engine.dto.DealRecordDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtBatchConfigurationDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtCtrlAnagDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtCtrlInputAnagDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtCtrlInputOutputAnagDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtCtrlParamDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtCtrlScheduleAnagDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtCurveAnagDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtDealFilterDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtNoteDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DvCurveAnagAcquisizioniDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DvDetailDealDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DvEngineCurveDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DvInstanceInputDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DvInstanceLatestDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DvMonitorLogCurveDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.HistoryDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.SeqIdRunDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.WtCurveDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.WtCurveManDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.WtInputCtrlDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.WtOutputCtrlDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.WtRunCtrlDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.WtRunDealDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.WtRunNoteDTO;
import com.intesasanpaolo.bear.tit0.engine.utils.PojoTestUtils;


@RunWith(MockitoJUnitRunner.class)
public class ModelDtoTest {


	@Test
	public void testCurveDto() {
		PojoTestUtils.validate(CurveDto.class);
		Object o = new CurveDto();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDealRecordDTO() {
		PojoTestUtils.validate(DealRecordDTO.class);
		Object o = new DealRecordDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDtBatchConfigurationDTO() {
		PojoTestUtils.validate(DtBatchConfigurationDTO.class);
		Object o = new DtBatchConfigurationDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}

	@Test
	public void testDtCtrlAnagDTO() {
		PojoTestUtils.validate(DtCtrlAnagDTO.class);
		Object o = new DtCtrlAnagDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDtCtrlInputAnagDTO() {
		PojoTestUtils.validate(DtCtrlInputAnagDTO.class);
		Object o = new DtCtrlInputAnagDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDtCtrlInputOutputAnagDTO() {
		PojoTestUtils.validate(DtCtrlInputOutputAnagDTO.class);
		Object o = new DtCtrlInputOutputAnagDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDtCtrlParamDTO() {
		PojoTestUtils.validate(DtCtrlParamDTO.class);
		Object o = new DtCtrlParamDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDtCtrlScheduleAnagDTO() {
		PojoTestUtils.validate(DtCtrlScheduleAnagDTO.class);
		Object o = new DtCtrlScheduleAnagDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDtCurveAnagDTO() {
		PojoTestUtils.validate(DtCurveAnagDTO.class);
		Object o = new DtCurveAnagDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDtDealFilterDTO() {
		PojoTestUtils.validate(DtDealFilterDTO.class);
		Object o = new DtDealFilterDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDtNoteDTO() {
		PojoTestUtils.validate(DtNoteDTO.class);
		Object o = new DtNoteDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDvCurveAnagAcquisizioniDTO() {
		PojoTestUtils.validate(DvCurveAnagAcquisizioniDTO.class);
		Object o = new DvCurveAnagAcquisizioniDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDvDetailDealDTO() {
		PojoTestUtils.validate(DvDetailDealDTO.class);
		Object o = new DvDetailDealDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	@Ignore
	public void testDvEngineCurveDTO() {
		PojoTestUtils.validate(DvEngineCurveDTO.class);
		Object o = new DvEngineCurveDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDvInstanceInputDTO() {
		PojoTestUtils.validate(DvInstanceInputDTO.class);
		Object o = new DvInstanceInputDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDvInstanceLatestDTO() {
		PojoTestUtils.validate(DvInstanceLatestDTO.class);
		Object o = new DvInstanceLatestDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testDvMonitorLogCurveDTO() {
		PojoTestUtils.validate(DvMonitorLogCurveDTO.class);
		Object o = new DvMonitorLogCurveDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testHistoryDTO() {
		PojoTestUtils.validate(HistoryDTO.class);
		Object o = new HistoryDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testSeqIdRunDTO() {
		PojoTestUtils.validate(SeqIdRunDTO.class);
		Object o = new SeqIdRunDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testWtCurveDTO() {
		PojoTestUtils.validate(WtCurveDTO.class);
		Object o = new WtCurveDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testWtCurveManDTO() {
		PojoTestUtils.validate(WtCurveManDTO.class);
		Object o = new WtCurveManDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testWtInputCtrlDTO() {
		PojoTestUtils.validate(WtInputCtrlDTO.class);
		Object o = new WtInputCtrlDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testWtOutputCtrlDTO() {
		PojoTestUtils.validate(WtOutputCtrlDTO.class);
		Object o = new WtOutputCtrlDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testWtRunCtrlDTO() {
		PojoTestUtils.validate(WtRunCtrlDTO.class);
		Object o = new WtRunCtrlDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testWtRunDealDTO() {
		PojoTestUtils.validate(WtRunDealDTO.class);
		Object o = new WtRunDealDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
	@Test
	public void testWtRunNoteDTO() {
		PojoTestUtils.validate(WtRunNoteDTO.class);
		Object o = new DvDetailDealDTO();
		assertNotNull(o.toString());
		assertNotEquals(o, null);
	}
	
}
