package com.xiaomaoguai.gecco.service.impl;

import com.xiaomaoguai.gecco.entity.Picture;
import com.xiaomaoguai.gecco.mapper.PictureMapper;
import com.xiaomaoguai.gecco.service.PictureService;
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
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureMapper pictureMapper;

	@Override
	public int save(Picture picture) {
		return pictureMapper.insert(picture);
	}

}
