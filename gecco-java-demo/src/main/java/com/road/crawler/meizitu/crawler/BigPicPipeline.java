package com.road.crawler.meizitu.crawler;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.road.crawler.meizitu.exec.DownloadAction;
import com.road.crawler.meizitu.exec.Executors;
import com.road.crawler.meizitu.model.Picture;
import com.road.crawler.meizitu.service.PictureService;

@Service
public class BigPicPipeline implements Pipeline<BigPic> {

	@Resource(name = "pictureServiceImpl")
	private PictureService pictureService;

	@Value("${local.path}")
	private String fileSavePath;

	private Executors executors = Executors.create();

	@Override
	public void process(BigPic bean) {
		Picture pic = new Picture();
		pic.setCreateDate(new Date());
		pic.setUpdateDate(new Date());
		pic.setPicinfoId(bean.getPicInfoId());

		for (String url : bean.getPics()) {
			pic.setUrl(url);
			String localPath = fileSavePath + System.currentTimeMillis() + ".jpg";
			pic.setPath(localPath);
			pictureService.save(pic);
			executors.getDefaultActionQueue().enqueue(
					new DownloadAction(executors.getDefaultActionQueue(), url, localPath));
		}
	}
}
