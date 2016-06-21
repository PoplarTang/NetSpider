package com.xiaomaoguai.dianping.htmlBean;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * 一级商家信息
 * 
 * @author hp
 *
 */
public class ShopIndex implements HtmlBean {

	private static final long serialVersionUID = 1L;

	/**
	 * 商品Id
	 */
	private String code;

	@Attr("href")
	@HtmlField(cssPath = ".tg-floor-item-wrap>.tg-floor-img")
	private String href;

	@Attr("lazy-src-load")
	@HtmlField(cssPath = ".tg-floor-item-wrap>.tg-floor-img>img")
	private String headPhoto;

	@Html
	@HtmlField(cssPath = ".tg-floor-item-wrap>.tg-floor-title")
	private String shopName;

	@Html
	@HtmlField(cssPath = ".tg-floor-item-wrap>.tg-floor-price>.tg-floor-price-new")
	private String priceNew;

	@Html
	@HtmlField(cssPath = ".tg-floor-item-wrap>.tg-floor-price>.tg-floor-price-old")
	private String priceOld;

	@Text
	@HtmlField(cssPath = ".tg-floor-sold")
	private String comments;

	public String getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPriceNew() {
		return priceNew;
	}

	public void setPriceNew(String priceNew) {
		this.priceNew = priceNew;
	}

	public String getPriceOld() {
		return priceOld;
	}

	public void setPriceOld(String priceOld) {
		this.priceOld = priceOld;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
