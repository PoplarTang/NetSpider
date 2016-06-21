package com.xiaomaoguai.dianping.htmlBean.list;

import java.util.List;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "http://www.dianping.com/search/category/7/10/g112", pipelines = { "consolePipeline" })
public class ListIndexBean implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@HtmlField(cssPath=".shop-wrap>.content>.shop-list>ul>li")
	private List<ListShopInfo> shops;

	public List<ListShopInfo> getShops() {
		return shops;
	}

	public void setShops(List<ListShopInfo> shops) {
		this.shops = shops;
	}

	public static void main(String[] args) {
		HttpGetRequest start = new HttpGetRequest("http://www.dianping.com/search/category/7/10/g112");
		start.setCharset("GBK");
		GeccoEngine.create().classpath("com.xiaomaoguai.dianping.htmlBean.list").interval(2000).start(start).run();
	}
}
