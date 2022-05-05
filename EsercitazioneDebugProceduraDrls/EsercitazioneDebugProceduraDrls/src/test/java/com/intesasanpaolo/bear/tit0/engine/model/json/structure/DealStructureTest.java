package com.intesasanpaolo.bear.tit0.engine.model.json.structure;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

public class DealStructureTest {

	@Test
	public void testGetInstance() {
	
		Executable executable = () -> DealStructure.getInstance(DealType.MUREX, null);
		assertThrows(Exception.class,executable);
	
	}

}
