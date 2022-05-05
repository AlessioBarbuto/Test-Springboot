package com.intesasanpaolo.bear.tit0.engine.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExceptionTest {

	@Test
	public void testDozerException1() {
		DozerException o = new DozerException();
		assertNotNull(o);
		o = new DozerException("");
		assertNotNull(o);
	}

	@Test
	public void testDroolsProcessingEmptyResultException() {
		DroolsProcessingEmptyResultException o = new DroolsProcessingEmptyResultException("");
		assertNotNull(o);
	}
	
	@Test
	public void testEngineErrorException() {
		EngineErrorException o = new EngineErrorException("", null, null, null);
		assertNotNull(o);
	}

	@Test
	public void testIllegalCodBasisException() {
		IllegalCodBasisException o = new IllegalCodBasisException("");
		assertNotNull(o);
		o = new IllegalCodBasisException(0);
		assertNotNull(o);
	}
	
	@Test
	public void testInconsistentDatesException() {
		InconsistentDatesException o = new InconsistentDatesException("");
		assertNotNull(o);
		o = new InconsistentDatesException(null, null);
		assertNotNull(o);
	}
	
	@Test
	public void testNotFoundException() {
		NotFoundException o = new NotFoundException("");
		assertNotNull(o);
	}
	
	@Test
	public void testTermStructureException() {
		TermStructureException o = new TermStructureException("");
		assertNotNull(o);
		o = new TermStructureException(new Exception());
		assertNotNull(o);
	}
	
}
