package com.cafe24.jblog2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog2.repository.CategoryDao;
import com.cafe24.jblog2.vo.CategoryVo;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryDao categoryDao;
	
	/** 블로그  카테고리 목록  가져오기**/
	@Override
	public List<CategoryVo> getCategoryList(String id)
	{
		return categoryDao.getCategoryList(id);
	}
	
	/** 카테고리글작성&리스트가져오기(ajax)**/
	@Override
	public List<CategoryVo> WriteGetList(CategoryVo categoryVo)
	{
		//카테고리 글 등록
		categoryDao.WriteCategory(categoryVo);
		
		//카테고리 목록 가져오기
		String id = categoryVo.getID();
		
		return categoryDao.getCategoryList(id);
	}
	
}
