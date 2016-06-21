package com.road.crawler.meizitu.service;

import java.util.List;

import com.road.crawler.meizitu.model.CategoryType;

/**
 * @Description :
 * @Author :WeiHui.Zhang
 * @Data : 2016/3/30 10:56
 * @Version:1.0.0
 */
public interface CategoryTypeService {

    void save(CategoryType categoryType);
    
    List<CategoryType> findAll();
}
