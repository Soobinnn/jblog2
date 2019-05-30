package com.cafe24.jblog2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog2.repository.CategoryDao;
import com.cafe24.jblog2.repository.PostDao;
import com.cafe24.jblog2.vo.CategoryVo;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PostDao postDao;
	
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
		return categoryDao.getCategoryList(categoryVo.getID());
	}
	
	/** 카테고리글 삭제&리스트가져오기(ajax) **/
	@Override
	public List<CategoryVo> DeleteGetList(CategoryVo categoryVo)
	{
		//카테고리 글 삭제
		categoryDao.DeleteCategory(categoryVo);
		
		//카테고리 목록 가져오기
		return categoryDao.getCategoryList(categoryVo.getID());
	}
	
	/** 카테고리명 가져오기 **/
	@Override
	public List<CategoryVo> getCategoryNameList(String id)
	{
		return categoryDao.getCategoryNameList(id);
	}
}
