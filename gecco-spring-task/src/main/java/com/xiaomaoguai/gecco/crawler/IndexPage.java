package com.xiaomaoguai.gecco.crawler;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.xiaomaoguai.gecco.entity.CategoryType;

import java.util.List;

/**
 * @Description :
 * @FileName: IndexPage.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月29日 上午11:32:08
 * @Version:V1.00
 */
@Gecco(matchUrl = "http://www.meizitu.com/", pipelines = { "consolePipeline", "saveCategoryPipeline" })
public class IndexPage implements HtmlBean {

	private static final long serialVersionUID = -139677387757121011L;

	@Request
	private HttpRequest request;
	
	@HtmlField(cssPath = ".topmodel > ul > li")
	private List<CategoryType> categoryTypes;

	public List<CategoryType> getCategoryTypes() {
		return categoryTypes;
	}

	public void setCategoryTypes(List<CategoryType> categoryTypes) {
		this.categoryTypes = categoryTypes;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public static void main(String[] args) {
		HttpGetRequest start = new HttpGetRequest("http://www.meizitu.com/");
		start.setCharset("GBK");
		GeccoEngine.create()
				.classpath("com.xiaomaoguai.gecco.crawler")
				.start(start)
				.run();
	}

}
