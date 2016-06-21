package com.xiaomaoguai.dianping.htmlBean.city;

import java.util.List;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class Province implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Text
	@HtmlField(cssPath=".vocabulary")
	private String region;
	
	@Text
	@HtmlField(cssPath="dl.terms>dt")
	private String provinceName;

	@Text
	@HtmlField(cssPath="dl.terms>dd>a")
	private List<City> citys;

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

}
