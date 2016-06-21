package com.xiaomaoguai.gecco.crawler;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @Description :
 * @Author :WeiHui.Zhang
 * @Data : 2016/3/29 17:15
 * @Version:1.0.0
 */
@PipelineName("downPicPipeline")
@Service
public class DownPicPipeline implements Pipeline<BigPic> {

	private CloseableHttpClient httpClient;

	{
		RequestConfig clientConfig = RequestConfig.custom().setRedirectsEnabled(false).build();
		PoolingHttpClientConnectionManager syncConnectionManager = new PoolingHttpClientConnectionManager();
		syncConnectionManager.setMaxTotal(1000);
		syncConnectionManager.setDefaultMaxPerRoute(50);
		httpClient = HttpClientBuilder.create().setDefaultRequestConfig(clientConfig).setConnectionManager(syncConnectionManager).build();
	}

	@Override
	public void process(BigPic bean) {
		List<String> pics = bean.getPics();
		for (String s : pics) {
			System.out.println("图片地址：" + s);
			HttpRequestBase request = new HttpGet(s);
			try {
				HttpClientContext context = HttpClientContext.create();
				org.apache.http.HttpResponse response = httpClient.execute(request, context);
				FileUtils.copyInputStreamToFile(response.getEntity().getContent(),new File("D:/pic/" + System.currentTimeMillis() + ".jpg"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				request.releaseConnection();
			}
		}
	}
}
