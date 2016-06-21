package com.xiaomaoguai.dianping.htmlBean.city;

import java.util.List;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "http://www.dianping.com/citylist/citylist?citypage=1", pipelines = { "consolePipeline" })
public class CityList implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Text
	@HtmlField(cssPath="div.section>ul#divArea>li")
	private List<Province> cityList;

	public List<Province> getCityList() {
		return cityList;
	}

	public void setCityList(List<Province> cityList) {
		this.cityList = cityList;
	}

	
	public static void main(String[] args) {
		HttpGetRequest start = new HttpGetRequest("http://www.dianping.com/citylist/citylist?citypage=1");
		start.setCharset("GBK");
		GeccoEngine.create().classpath("com.xiaomaoguai.dianping.htmlBean.city").interval(2000).start(start).run();
	}
}
