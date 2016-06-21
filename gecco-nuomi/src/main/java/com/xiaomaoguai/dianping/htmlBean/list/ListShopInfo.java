package com.xiaomaoguai.dianping.htmlBean.list;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class ListShopInfo implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Attr("data-src")
	@HtmlField(cssPath = ".top>.pic>a")
	private String shopPic;// 店图片

	@Attr("title")
	@HtmlField(cssPath = ".top>.pic>a")
	private String shopName;// 店名

	@Attr("href")
	@HtmlField(cssPath = ".top>.txt>.tit>a")
	private String href;// 链接

	@Text
	@HtmlField(cssPath = ".top>.txt>.comment>a>b")
	private String comments;// 点评

	@Text
	@HtmlField(cssPath = ".top>.txt>comment>a:nth-child(1)>b")
	private String avg;// 人均

	@Text
	@HtmlField(cssPath = ".top>.txt>.tag-addr>a>.tag")
	private String type;// 类型

	@Text
	@HtmlField(cssPath = ".top>.txt>.tag-addr>a:nth-last>.tag")
	private String address;// 区

	@Text
	@HtmlField(cssPath = ".top>.txt>.tag-addr>.addr")
	private String location;// 位置

	@Text
	@HtmlField(cssPath = ".top>.txt>.comment-list>span>b")
	private String point1;// 口味

	@Text
	@HtmlField(cssPath = ".top>.txt>.comment-list>span:nth-child(2)>b")
	private String point2;// 环境

	@Text
	@HtmlField(cssPath = ".top>.txt>.comment-list>span:nth-child(3)>b")
	private String point3;// 服务

	public String getShopPic() {
		return shopPic;
	}

	public void setShopPic(String shopPic) {
		this.shopPic = shopPic;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

}
