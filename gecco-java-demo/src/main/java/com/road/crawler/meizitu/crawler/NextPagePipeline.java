package com.road.crawler.meizitu.crawler;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.road.crawler.meizitu.model.PictureInfo;
import com.road.crawler.meizitu.service.PictureInfoService;

/**
 * @Description :
 * @Author :WeiHui.Zhang
 * @Data : 2016/3/30 11:06
 * @Version:1.0.0
 */
@Service
public class NextPagePipeline implements Pipeline<SecondPage> {

	@Resource(name="pictureInfoServiceImpl")
	private PictureInfoService pictureInfoService;

	@Override
	public void process(SecondPage bean) {
		// 保存当前页爬取的图片信息
		List<Picture> pictures = bean.getPictures();
		for (Picture picture : pictures) {
			PictureInfo pictureInfo = new PictureInfo();
			pictureInfo.setTag(bean.getTag());
			pictureInfo.setAlt(picture.getAlt());
			pictureInfo.setHref(picture.getHref());
			pictureInfo.setThumbnail(picture.getThumbnail());
			pictureInfo.setCreateDate(new Date());
			pictureInfoService.save(pictureInfo);
			//继续抓取详情页
			HttpRequest sub = bean.getRequest().subRequest(picture.getHref());
			sub.addParameter("picInfoId", ""+pictureInfo.getId());
			SchedulerContext.into(sub);
		}
		//继续抓取下一页构造下一页
		int currPage = bean.getCurrPage();
		int totalPage = getTotalPage(bean.getLastPageUrl());
		if (currPage < totalPage) {
			int nextPage = currPage + 1;
			String nextUrl = "http://www.meizitu.com/tag/"+bean.getTagCode()+"_"+bean.getTagId()+"_"+nextPage+".html";
			HttpRequest request = bean.getRequest();
			SchedulerContext.into(request.subRequest(nextUrl));
		}
	}
	
	private int getTotalPage(String lastPageUrl) {
		if(StringUtils.isEmpty(lastPageUrl)) {
			return 1;
		}
		//http://www.meizitu.com/tag/ suxiong_17_ 9 .html
		lastPageUrl = StringUtils.substringAfterLast(lastPageUrl, "/");
		lastPageUrl = StringUtils.substringBefore(lastPageUrl, ".");
		lastPageUrl = StringUtils.substringAfterLast(lastPageUrl, "_");
		return NumberUtils.toInt(lastPageUrl, 1);
	}
}
