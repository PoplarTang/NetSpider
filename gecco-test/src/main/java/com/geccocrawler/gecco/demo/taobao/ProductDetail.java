package com.geccocrawler.gecco.demo.taobao;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl="https://item.taobao.com/item.htm?spm={spm}&id={id}&ns=1&abbucket=1", pipelines="consolePipeline")
public class ProductDetail implements HtmlBean {

	private static final long serialVersionUID = -4L;

	/**
	 * 商品代码
	 */
	@RequestParameter
	private String id;

	/**
	 * 标题
	 */
	@Text
	@HtmlField(cssPath="#J-Title > h3")
	private String title;

	/**
	 * 获取商品价格
	 */
	@Text
	@HtmlField(cssPath="#J-StrPrice > em")
	private String price;

	@Text
	@HtmlField(cssPath="#J_ShopInfo > div.tb-shop-info-wrap > div.tb-shop-info-hd > div.tb-shop-name > dl > dd > strong")
	private String shop;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

}
