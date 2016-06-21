package com.xiaomaoguai.gecco.mapper;


import com.xiaomaoguai.gecco.entity.Picture;

public interface PictureMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}