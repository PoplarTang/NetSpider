package com.gecco.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.DefaultCookieSpecProvider;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Requestor {

	protected final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";
	protected final static String Accept = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
	protected final static String AcceptLanguage = "zh-CN,zh;q=0.8,en;q=0.6";

	protected CookieStore cookieStore;
	protected HttpClientContext context;
	protected CloseableHttpClient client;

	public Requestor() {
		client = HttpClients.createDefault();
	}

	public void doLogin(String loginUrl, Map<String, String> params) {
		HttpResponse httpResponse = doPost(loginUrl, params);
		printResponse(httpResponse);
	}

	public void printResponse(HttpResponse httpResponse) {
		// 获取响应消息实体
		HttpEntity entity = httpResponse.getEntity();
		// 响应状态
		System.out.println("status:" + httpResponse.getStatusLine());
		System.out.println("headers:");
		HeaderIterator iterator = httpResponse.headerIterator();
		while (iterator.hasNext()) {
			System.out.println("\t" + iterator.next());
		}
		// 判断响应实体是否为空
		if (entity != null) {
			String responseString;
			try {
				responseString = EntityUtils.toString(entity);
				System.out.println("response length:" + responseString.length());
				System.out.println("response content:" + responseString.replace("\r\n", ""));
			} catch (org.apache.http.ParseException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void setContext() {
		context = HttpClientContext.create();
		Registry<CookieSpecProvider> registry = RegistryBuilder.<CookieSpecProvider> create()
				.register(CookieSpecs.DEFAULT, new DefaultCookieSpecProvider()).register(CookieSpecs.DEFAULT, new DefaultCookieSpecProvider())
				.build();
		context.setCookieSpecRegistry(registry);
		context.setCookieStore(cookieStore);
	}

	public void setCookieStore(HttpResponse httpResponse) {
		cookieStore = new BasicCookieStore();
		Header[] headers = httpResponse.getHeaders("Set-Cookie");

		String cookieValue = null;
		for (Header header : headers) {
			System.out.println(header.getName() + ":" + header.getValue());
				cookieValue = header.getValue();
		}
		// 新建一个Cookie
		BasicClientCookie cookie = new BasicClientCookie("oscid", cookieValue);
		cookie.setDomain(".oschina.net");
		cookie.setPath("/");
		cookieStore.addCookie(cookie);
	}

	public List<NameValuePair> getParam(Map<String, String> parameterMap) {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		Set<String> keySet = parameterMap.keySet();
		for (String key : keySet) {
			nameValuePairs.add(new BasicNameValuePair(key, parameterMap.get(key)));
		}
		return nameValuePairs;
	}

	public HttpResponse doGet(String url) {
		HttpResponse result = null;
		HttpGet httpGet = new HttpGet(url);
		config(httpGet);
		try {
			result = client.execute(httpGet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public HttpResponse doPost(String url, Map<String, String> params) {
		HttpResponse result = null;
		HttpPost httpPost = new HttpPost(url);
		UrlEncodedFormEntity postEntity;
		try {
			postEntity = new UrlEncodedFormEntity(getParam(params), "UTF-8");
			httpPost.setEntity(postEntity);
			config(httpPost);
			result = client.execute(httpPost);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	protected void config(HttpRequestBase httpRequestBase) {
		httpRequestBase.setHeader("User-Agent", USER_AGENT);
		httpRequestBase.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpRequestBase.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
		httpRequestBase.setHeader("Referer", "https://www.oschina.net/home/login?goto_page=http%3A%2F%2Fwww.oschina.net%2F");
		// 配置请求的超时设置
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(3000).setConnectTimeout(3000).setSocketTimeout(3000).build();
		httpRequestBase.setConfig(requestConfig);
	}

}
