package com.intesasanpaolo.bear.tit0.engine.model.json.structure;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import com.intesasanpaolo.bear.tit0.engine.model.json.JsonRowObject;

public class DealKondorStructureTest {

	@Test
	public void testDealKondorStructureJsonRowObject() {
		Executable executable = () -> new DealKondorStructure(new JsonRowObject(null));
		assertThrows(Exception.class,executable);
	}

}
