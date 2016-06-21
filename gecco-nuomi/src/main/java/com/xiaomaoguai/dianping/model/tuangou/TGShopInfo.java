package com.xiaomaoguai.dianping.model.tuangou;

import org.apache.commons.lang3.StringUtils;

import com.xiaomaoguai.dianping.htmlBean.ShopIndex;
import com.xiaomaoguai.dianping.model.Costants;

/**
 * 团购模块
 * 
 * @author hp
 *
 */
public class TGShopInfo {

	/**
	 * 商品Id
	 */
	private String code;

	private String href;

	private String headPhoto;

	private String shopName;

	private String priceNew;

	private String priceOld;

	private String other;

	public TGShopInfo() {
		super();
	}

	public TGShopInfo(ShopIndex shopIndex) {
		String href = shopIndex.getHref();
		this.code = StringUtils.substringAfter(href, "deal/");
		this.href = Costants.TUANGOU_PATH + href;

		String shopName = shopIndex.getShopName();
		String shopRealName = StringUtils.substringBetween(shopName, "<h3>", "</h3>");

		this.shopName = shopRealName;

		String benefit = StringUtils.substringBetween(shopName, "<h4>", "</h4>");

		this.other = benefit;
		this.headPhoto = shopIndex.getHeadPhoto();

		String priceNew = StringUtils.substringBetween(shopIndex.getPriceNew(), "<em>", "</em>");
		this.priceNew = priceNew;

		String priceOld = StringUtils.substringBetween(shopIndex.getPriceOld(), "<del>", "</del>");

		this.priceOld = priceOld;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

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

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "TGShopInfo [code=" + code + ", href=" + href + ", headPhoto=" + headPhoto + ", shopName=" + shopName
				+ ", priceNew=" + priceNew + ", priceOld=" + priceOld + ", other=" + other + "]";
	}

}
