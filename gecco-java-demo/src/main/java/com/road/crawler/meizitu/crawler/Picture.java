package com.road.crawler.meizitu.crawler;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @Description :
 * @FileName: Picture.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月29日 上午11:48:52
 * @Version:V1.00
 */
public class Picture implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Attr("alt")
	@HtmlField(cssPath = "div.con > .pic > a > img")
	private String alt;

	@Href
	@HtmlField(cssPath = "div.con > .pic > a")
	private String href;

	@Image
	@HtmlField(cssPath = "div.con > .pic > a > img")
	private String thumbnail;

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}
