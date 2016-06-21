package com.xiaomaoguai.gecco.service.impl;

import com.xiaomaoguai.gecco.entity.CategoryType;
import com.xiaomaoguai.gecco.mapper.CategoryTypeMapper;
import com.xiaomaoguai.gecco.service.CategoryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
