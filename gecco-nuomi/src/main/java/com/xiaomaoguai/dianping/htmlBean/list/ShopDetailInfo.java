package com.xiaomaoguai.dianping.htmlBean.list;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

//, "consolePipeline"
@Gecco(matchUrl = "http://www.dianping.com/shop/17953086", pipelines = { "shopDeatilDataPipeline", "jsonDataOutput" })
public class ShopDetailInfo implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Text
	@HtmlField(cssPath = ".main>#basic-info>.shop-name")
	private String shopName;

	@Attr("class")
	@HtmlField(cssPath = ".main>#basic-info>.brief-info>.mid-rank-stars")
	private String star;

	@Text
	@HtmlField(cssPath = ".main>#basic-info>.brief-info>.item")
	private String comment;

	@Text
	@HtmlField(cssPath = ".main>#basic-info>.brief-info>.item:nth-child(4)")
	private String avg;

	@Text
	@HtmlField(cssPath = ".main>#basic-info>.brief-info>.item:nth-child(5)")
	private String point1;

	@Text
	@HtmlField(cssPath = ".main>#basic-info>.brief-info>.item:nth-child(6)")
	private String point2;

	@Text
	@HtmlField(cssPath = ".main>#basic-info>.brief-info>.item:nth-child(7)")
	private String point3;

	@Text
	@HtmlField(cssPath = ".main>#basic-info>div.expand-info>span.item")
	private String address;

	@Text
	@HtmlField(cssPath = ".main>#basic-info>p.expand-info>span.item")
	private List<String> tel;

	@JSONField(serialize = false)
	@Html
	@HtmlField(cssPath = "script.J-panels")
	private String details;

	private List<DishInfo> dishInfos;

	private List<DishPhoto> dishPhotos;

	private List<EnvironmentPhoto> environmentPhotos;

	private String story;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public String getPoint1() {
		return point1;
	}

	public void setPoint1(String point1) {
		this.point1 = point1;
	}

	public String getPoint2() {
		return point2;
	}

	public void setPoint2(String point2) {
		this.point2 = point2;
	}

	public String getPoint3() {
		return point3;
	}

	public void setPoint3(String point3) {
		this.point3 = point3;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getTel() {
		return tel;
	}

	public void setTel(List<String> tel) {
		this.tel = tel;
	}

	public List<DishInfo> getDishInfos() {
		return dishInfos;
	}

	public void setDishInfos(List<DishInfo> dishInfos) {
		this.dishInfos = dishInfos;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<DishPhoto> getDishPhotos() {
		return dishPhotos;
	}

	public void setDishPhotos(List<DishPhoto> dishPhotos) {
		this.dishPhotos = dishPhotos;
	}

	public List<EnvironmentPhoto> getEnvironmentPhotos() {
		return environmentPhotos;
	}

	public void setEnvironmentPhotos(List<EnvironmentPhoto> environmentPhotos) {
		this.environmentPhotos = environmentPhotos;
	}

	public static void main(String[] args) {
		HttpGetRequest start = new HttpGetRequest("http://www.dianping.com/shop/17953086");
		start.setCharset("GBK");
		GeccoEngine.create().classpath("com.xiaomaoguai.dianping.htmlBean.list").interval(2000).start(start).run();
	}
}
