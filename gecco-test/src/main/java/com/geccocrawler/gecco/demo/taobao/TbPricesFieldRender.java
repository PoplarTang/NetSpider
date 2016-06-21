package com.geccocrawler.gecco.demo.taobao;

import java.lang.reflect.Field;
import java.util.List;

import net.sf.cglib.beans.BeanMap;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.FieldRenderName;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.response.HttpResponse;
import com.geccocrawler.gecco.spider.SpiderBean;
import com.geccocrawler.gecco.spider.render.CustomFieldRender;

@FieldRenderName("TbPricesFieldRender")
public class TbPricesFieldRender implements CustomFieldRender {

	@Override
	public void render(HttpRequest request, HttpResponse response,
			BeanMap beanMap, SpiderBean bean, Field field) {
		String content = response.getContent();
		if (StringUtils.isNoneBlank(content)) {
			// 将返回的jsonp转化为json,jsonp525为客户端指定回调函数名
			String jsonResult = StringUtils.substringBetween(content,
					"jsonp525(", ");");
			Object json = JSON.parse(jsonResult);
			if (json != null) {
				Object mods = com.alibaba.fastjson.JSONPath
						.eval(json, "$.mods");
				Object itemlist = com.alibaba.fastjson.JSONPath.eval(mods,
						"$.itemlist");
				Object data = com.alibaba.fastjson.JSONPath.eval(itemlist,
						"$.data");
				Object auctions = com.alibaba.fastjson.JSONPath.eval(data,
						"$.auctions");
				// System.out.println(auctions);
				List<ProductBrief> list = JSON.parseArray(auctions.toString(),
						ProductBrief.class);
//				for (ProductBrief item : list) {
//					System.out.println(item);
//				}
				beanMap.put(field.getName(), list);
			}
		}
	}

}
