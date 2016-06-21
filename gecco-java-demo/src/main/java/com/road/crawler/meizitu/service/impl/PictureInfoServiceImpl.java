package com.road.crawler.meizitu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.road.crawler.meizitu.mapper.PictureInfoMapper;
import com.road.crawler.meizitu.model.PictureInfo;
import com.road.crawler.meizitu.service.PictureInfoService;

/**
 * @Description :
 * @FileName: PictureInfoServiceImpl.java
 * @Author :WeiHui.Zhang
 * @Data : 2016年3月30日 下午2:30:04
 * @Version:V1.00
 */
@Service
public class PictureInfoServiceImpl implements PictureInfoService {

	@Autowired
	private PictureInfoMapper pictureInfoMapper;

	@Override
	public int save(PictureInfo pictureInfo) {

		return pictureInfoMapper.insert(pictureInfo);
	}

}
