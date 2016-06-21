package com.gecco.atest;

import java.util.List;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "http://www.stats.gov.cn/", timeout = 60 * 1000, pipelines = { "consolePipeline" })
public class NullATest implements HtmlBean {

	private static final long serialVersionUID = -139677387757121011L;

	@HtmlField(cssPath = "a")
	private List<AContent> aList;

	public List<AContent> getaList() {
		return aList;
	}

	public void setaList(List<AContent> aList) {
		this.aList = aList;
	}

	public static void main(String[] args) {
		GeccoEngine.create().classpath("com.gecco.atest").thread(1)
				.interval(2000).start("http://www.stats.gov.cn/").loop(false)
				.run();
	}

}
