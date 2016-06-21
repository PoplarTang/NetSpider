package com.xiaomaoguai.gecco.service.impl;

import com.xiaomaoguai.gecco.entity.PictureInfo;
import com.xiaomaoguai.gecco.mapper.PictureInfoMapper;
import com.xiaomaoguai.gecco.service.PictureInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
