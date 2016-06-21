package com.road.crawler.meizitu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.road.crawler.meizitu.mapper.PictureMapper;
import com.road.crawler.meizitu.model.Picture;
import com.road.crawler.meizitu.service.PictureService;

/**
 * @Description :
 * @FileName: PictureInfoServiceImpl.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月30日 下午2:30:04
 * @Version:V1.00
 */
@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureMapper pictureMapper;

	@Override
	public int save(Picture picture) {
		return pictureMapper.insert(picture);
	}

}
