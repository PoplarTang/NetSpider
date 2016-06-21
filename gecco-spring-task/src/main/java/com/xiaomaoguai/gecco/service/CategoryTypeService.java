package com.xiaomaoguai.gecco.service;

import com.xiaomaoguai.gecco.entity.CategoryType;

import java.util.List;

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
