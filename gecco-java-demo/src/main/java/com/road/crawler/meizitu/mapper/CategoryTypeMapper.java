package com.road.crawler.meizitu.mapper;


import java.util.List;

import com.road.crawler.meizitu.model.CategoryType;

public interface CategoryTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryType record);

    int insertSelective(CategoryType record);

    CategoryType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryType record);

    int updateByPrimaryKey(CategoryType record);

	List<CategoryType> findAll();
}