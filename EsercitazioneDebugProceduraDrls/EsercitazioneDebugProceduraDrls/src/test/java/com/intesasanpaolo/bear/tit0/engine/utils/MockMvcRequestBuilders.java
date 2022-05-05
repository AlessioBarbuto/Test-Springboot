package com.intesasanpaolo.bear.tit0.engine.utils;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;

public class MockMvcRequestBuilders {
	private static final String sessionId = "MOCKEDXX-d44b-4091-a785-1e7babba4584";

	public static MockHttpServletRequestBuilder get(String uri) {
		return org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(uri)
				.header("X-BEAR-SESSION-TOKEN", sessionId);
	}

	public static MockMultipartHttpServletRequestBuilder multipart(String uri) {
		return (MockMultipartHttpServletRequestBuilder) org.springframework.test.web.servlet.request.MockMvcRequestBuilders
				.multipart(uri).header("X-BEAR-SESSION-TOKEN", sessionId);
	}

	public static MockHttpServletRequestBuilder post(String uri) {
		return org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(uri)
				.header("X-BEAR-SESSION-TOKEN", sessionId);
	}

	public static MockHttpServletRequestBuilder put(String uri) {
		return org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put(uri)
				.header("X-BEAR-SESSION-TOKEN", sessionId);
	}

	public static MockHttpServletRequestBuilder delete(String uri) {
		return org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete(uri)
				.header("X-BEAR-SESSION-TOKEN", sessionId);
	}
}
