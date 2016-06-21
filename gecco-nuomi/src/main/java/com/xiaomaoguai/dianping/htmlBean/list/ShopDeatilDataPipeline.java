package com.xiaomaoguai.dianping.htmlBean.list;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

@PipelineName("shopDeatilDataPipeline")
public class ShopDeatilDataPipeline implements Pipeline<ShopDetailInfo> {

	@Override
	public void process(ShopDetailInfo bean) {
		String details = bean.getDetails();
		Document document = Jsoup.parse(details);
		if (document == null) {
			return;
		}
		// 推荐菜解析
		Elements elements = document.select(".recommend-name>a.item");
		List<DishInfo> dishInfos = new ArrayList<>();
		if (elements != null) {
			for (Element element : elements) {
				DishInfo info = new DishInfo();
				// 菜名
				String dishName = element.ownText();
				if (StringUtils.isNotBlank(dishName)) {
					info.setDishName(dishName);
				}
				// 链接
				String href = element.attr("href");
				if (StringUtils.isNotBlank(href)) {
					info.setDishHref(href);
				}
				// 数量
				Element select = element.select("em.count").get(0);
				if (select != null) {
					String count = select.ownText();
					if (StringUtils.isNotBlank(count)) {
						info.setDishNum(count);
					}
				}
				dishInfos.add(info);
			}
			bean.setDishInfos(dishInfos);
			// 图片解析
			Elements pElements = document.select("ul.recommend-photo>li.item");
			List<DishPhoto> dishPhotos = new ArrayList<>();
			for (Element element : pElements) {
				Element select = element.getElementsByTag("img").get(0);
				if (select != null) {
					DishPhoto photo = new DishPhoto();
					photo.setPhotoHref(select.attr("src"));
					photo.setDishName(select.attr("alt"));
					dishPhotos.add(photo);
				}
			}
			bean.setDishPhotos(dishPhotos);
			// 环境解析
			Elements envElements = document.select("div.container>a.item");
			if (envElements != null) {
				List<EnvironmentPhoto> environmentPhotos = new ArrayList<>();
				for (Element element : envElements) {
					EnvironmentPhoto photo = new EnvironmentPhoto();
					String title = element.attr("title");
					Element img = element.getElementsByTag("img").get(0);
					String url = img.attr("src");
					photo.setName(title);
					photo.setUrl(url);
					environmentPhotos.add(photo);
				}
				bean.setEnvironmentPhotos(environmentPhotos);
			}
			// 故事
			Element storyEle = document.select("div.info").get(0);
			String text = storyEle.text();
			bean.setStory(text);
		}

	}

}
