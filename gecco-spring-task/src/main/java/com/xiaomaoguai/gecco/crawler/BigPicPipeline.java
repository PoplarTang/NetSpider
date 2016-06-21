package com.xiaomaoguai.gecco.crawler;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.xiaomaoguai.gecco.common.exec.DownloadAction;
import com.xiaomaoguai.gecco.common.exec.Executors;
import com.xiaomaoguai.gecco.entity.Picture;
import com.xiaomaoguai.gecco.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


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
			executors.getDefaultActionQueue()
					.enqueue(new DownloadAction(executors.getDefaultActionQueue(), url, localPath));
		}
	}
}
