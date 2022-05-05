package com.intesasanpaolo.bear.tit0.engine.errors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class RestResponseEntityExceptionHandlerTest {

	private final RestResponseEntityExceptionHandler handler = new RestResponseEntityExceptionHandler() {
	};

	@Test
	public void testHandler() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpClientErrorException exception = HttpClientErrorException.NotFound.create(HttpStatus.NOT_FOUND, "", headers,
				"".getBytes(), null);
		ResponseEntity<Object> handled = handler.handleExceptions(exception, null);
		assertEquals(handled.getStatusCodeValue(), 404);
	}
}
