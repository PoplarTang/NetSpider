package com.xiaomaoguai.dianping.htmlBean;

import java.util.List;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "http://t.dianping.com/list/shenzhen-category_20", pipelines = { "consolePipeline",
		"shopIndexDataPipeline" })
public class CategoryListBean implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Request
	private HttpRequest request;

	@HtmlField(cssPath = "ul.tg-floor-list>.tg-floor-item")
	private List<ShopIndex> shops;

	public List<ShopIndex> getShops() {
		return shops;
	}

	public void setShops(List<ShopIndex> shops) {
		this.shops = shops;
	}

	public CategoryListBean() {
		super();
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public static void main(String[] args) {
		HttpGetRequest start = new HttpGetRequest("http://t.dianping.com/list/shenzhen-category_20");
		start.setCharset("GBK");
		GeccoEngine.create().classpath("com.xiaomaoguai.dianping.htmlBean").interval(2000).start(start).run();
	}
}
