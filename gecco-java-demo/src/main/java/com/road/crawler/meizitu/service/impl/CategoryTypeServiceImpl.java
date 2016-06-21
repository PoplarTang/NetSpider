package com.road.crawler.meizitu.service.impl;

import com.road.crawler.meizitu.mapper.CategoryTypeMapper;
import com.road.crawler.meizitu.model.CategoryType;
import com.road.crawler.meizitu.service.CategoryTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description :
 * @Author :WeiHui.Zhang
 * @Data : 2016/3/30 10:57
 * @Version:1.0.0
 */
@Service
public class CategoryTypeServiceImpl implements CategoryTypeService {

    @Autowired
    private CategoryTypeMapper categoryTypeMapper;

    @Override
    public void save(CategoryType categoryType) {
        categoryTypeMapper.insert(categoryType);
    }

	@Override
	public List<CategoryType> findAll() {
		return categoryTypeMapper.findAll();
	}
}
