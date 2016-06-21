package com.xiaomaoguai.dianping.htmlBean.city;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

public class City implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Attr("href")
	@HtmlField(cssPath="a")
	private String cityName;

	@Html
	@HtmlField(cssPath="a>strong")
	private String cityhref;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityhref() {
		return cityhref;
	}

	public void setCityhref(String cityhref) {
		this.cityhref = cityhref;
	}

}
