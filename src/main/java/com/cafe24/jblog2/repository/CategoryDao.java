package com.cafe24.jblog2.repository;

import java.util.List;

import com.cafe24.jblog2.vo.CategoryVo;

public interface CategoryDao 
{
	/** 카테고리 default(미분류) 생성 **/
	public void  defaultCategory(String id);
	
	/** 블로그 카테고리 목록 가져오기**/
	public List<CategoryVo> getCategoryList(String id);
	
	/** 카테고리 글작성 (ajax) **/
	public void WriteCategory(CategoryVo categoryVo);
	
	/** 카테고리 글삭제 (ajax) **/
	public void DeleteCategory(CategoryVo categoryVo);
	
	/** 카테고리명 가져오기 **/
	public List<CategoryVo> getCategoryNameList(String id);
}
