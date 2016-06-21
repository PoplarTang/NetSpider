package com.road.crawler.meizitu.mapper;

import com.road.crawler.meizitu.model.Picture;

public interface PictureMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}