package com.cafe24.jblog2.repository;

import java.util.List;

import com.cafe24.jblog2.vo.CategoryVo;

public interface CategoryDao 
{
	/** 블로그 카테고리 목록 가져오기**/
	public List<CategoryVo> getCategoryList(String id);
	
	/** 카테고리 글작성 (ajax)**/
	public void WriteCategory(CategoryVo categoryVo);
	
}
