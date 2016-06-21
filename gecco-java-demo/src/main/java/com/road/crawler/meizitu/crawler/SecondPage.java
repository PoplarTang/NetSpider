package com.road.crawler.meizitu.crawler;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @Description :
 * @FileName: SecondPage.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月29日 上午11:45:17
 * @Version:V1.00
 */
@Gecco(matchUrl = "http://www.meizitu.com/tag/{tagCode}_{tagId}_{currPage}.html", pipelines = {"consolePipeline", "nextPagePipeline"})
public class SecondPage implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@RequestParameter
	private String tag;
	
	@RequestParameter
	private String tagCode;
	
	@RequestParameter
	private String tagId;

	@Request
	private HttpRequest request;

	@RequestParameter
	private int currPage;

	@Href
	@HtmlField(cssPath = "#wp_page_numbers > ul > li:last-child > a")
	private String lastPageUrl;

	@HtmlField(cssPath = ".wp-list > li")
	private List<Picture> pictures;
	
	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLastPageUrl() {
		return lastPageUrl;
	}

	public void setLastPageUrl(String lastPageUrl) {
		this.lastPageUrl = lastPageUrl;
	}

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public static void main(String[] args) {
		HttpRequest request = new HttpGetRequest("http://www.meizitu.com/tag/suxiong_17_8.html");
		request.setCharset("GBK");
		GeccoEngine.create().classpath("com.road.crawler.meizitu").start(request).interval(2000).run();
	}

}
