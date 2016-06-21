package com.road.crawler.meizitu.mapper;


import com.road.crawler.meizitu.model.PictureInfo;

public interface PictureInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PictureInfo record);

    int insertSelective(PictureInfo record);

    PictureInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PictureInfo record);

    int updateByPrimaryKey(PictureInfo record);
}