package com.road.crawler.meizitu;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.request.HttpGetRequest;

/**
 * @Description :
 * @FileName: CrawlerMain.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月30日 下午2:27:59
 * @Version:V1.00
 */
@Service
public class CrawlerMain implements ApplicationContextAware,InitializingBean {

	private ApplicationContext context;

	@Override
	public void afterPropertiesSet() throws Exception {
		PipelineFactory springPipelineFactory = (PipelineFactory)context.getBean("springPipelineFactory");
		HttpGetRequest start = new HttpGetRequest("http://www.meizitu.com/");
		start.setCharset("GBK");
		GeccoEngine.create()
			.classpath("com.road.crawler.meizitu.crawler")
			.pipelineFactory(springPipelineFactory)
			.interval(2000)
			.start(start)
			.run();
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.in.read();
		context.close();
	}
}
