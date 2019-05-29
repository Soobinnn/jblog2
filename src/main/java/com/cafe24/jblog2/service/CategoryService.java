package com.cafe24.jblog2.service;

import java.util.List;

import com.cafe24.jblog2.vo.CategoryVo;

public interface CategoryService 
{
	/** 블로그 카테고리 목록 가져오기**/
	public List<CategoryVo> getCategoryList(String id);
	
	/** 카테고리글작성&리스트가져오기(ajax)**/
	public List<CategoryVo> WriteGetList(CategoryVo categoryVo);
}
