package com.xiaomaoguai.dianping.htmlBean;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.xiaomaoguai.dianping.model.tuangou.TGShopInfo;

@PipelineName("shopIndexDataPipeline")
public class ShopIndexDataPipeline implements Pipeline<CategoryListBean> {

	@Override
	public void process(CategoryListBean bean) {
		List<ShopIndex> shops = bean.getShops();
		for (ShopIndex shopIndex : shops) {
			TGShopInfo shopInfo = new TGShopInfo(shopIndex);
			System.out.println(JSON.toJSON(shopInfo));
		}
	}

}
