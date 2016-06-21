package com.xiaomaoguai.gecco.mapper;


import com.xiaomaoguai.gecco.entity.CategoryType;

import java.util.List;


public interface CategoryTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryType record);

    int insertSelective(CategoryType record);

    CategoryType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryType record);

    int updateByPrimaryKey(CategoryType record);

	List<CategoryType> findAll();
}