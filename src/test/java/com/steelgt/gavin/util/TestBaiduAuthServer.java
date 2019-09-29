package com.steelgt.gavin.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBaiduAuthServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestBaiduAuthServer.class);

	@Test
	public void test() {
		BaiduAuthService.getAuth();
	}

}
