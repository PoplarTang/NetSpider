package com.xiaomaoguai.gecco.crawler;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.xiaomaoguai.gecco.entity.CategoryType;
import com.xiaomaoguai.gecco.service.CategoryTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description :
 * @Author :WeiHui.Zhang
 * @Data : 2016/3/30 10:51
 * @Version:1.0.0
 */
@Service
public class SaveCategoryPipeline implements Pipeline<IndexPage> {

	@Resource(name="categoryTypeServiceImpl")
	private CategoryTypeService categoryTypeService;

	@Override
	public void process(IndexPage bean) {
		List<CategoryType> categoryTypes = bean.getCategoryTypes();
		for (CategoryType categoryType : categoryTypes) {
			categoryTypeService.save(categoryType);
			HttpRequest sub = bean.getRequest().subRequest(categoryType.getUrl());
			sub.addParameter("tag", ""+categoryType.getId());
			SchedulerContext.into(sub);
		}
	}
}
