package com.cafe24.jblog2.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog2.vo.CategoryVo;

@Repository
public class CategoryDaoImpl implements CategoryDao
{
	@Autowired
	private SqlSession sqlSession;
	
	/** 블로그  카테고리 목록  가져오기**/
	@Override
	public List<CategoryVo> getCategoryList(String id)
	{
		return sqlSession.selectList("category.getCategoryList", id);
	}
	
	/** 카테고리 글작성 (ajax)**/
	public void WriteCategory(CategoryVo categoryVo)
	{
		sqlSession.insert("category.insertCategory", categoryVo);
	}
	

}
