package com.intesasanpaolo.bear.tit0.engine.model.json.structure;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.intesasanpaolo.bear.tit0.engine.model.json.JsonRowObject;

class DealMurexStructureTest {

	@Test
	void testDealMurexStructureJsonRowObject() {
		Executable executable = () -> new DealMurexStructure(new JsonRowObject(null));
		assertThrows(Exception.class,executable);
	
		
	}

}
