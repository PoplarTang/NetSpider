package com.xiaomaoguai.dianping.htmlBean.list;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

@PipelineName("jsonDataOutput")
public class JsonDataOutput implements Pipeline<ShopDetailInfo> {

	@Override
	public void process(ShopDetailInfo bean) {
		System.out.println(JSON.toJSONString(bean));
	}

}
