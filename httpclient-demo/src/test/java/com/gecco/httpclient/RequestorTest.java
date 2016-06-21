package com.gecco.httpclient;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;


public class RequestorTest {

	private Requestor requestor = new Requestor();

	private String loginUrl = "https://www.oschina.net/action/user/hash_login";
	private String testUrl = "http://my.oschina.net/xiaomaoguai/blog";

	@Before
	public void testLogin() throws Exception {
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("email", "XXXX@qq.com");
		parameterMap.put("pwd", "3d7945f2c71687f0a12ac637acdf787bf23cf174");

		requestor.doLogin(loginUrl, parameterMap);
	}

	@Test
	public void testVisitBlog() throws Exception {
		HttpResponse response = requestor.doGet(testUrl);
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));
	}
}