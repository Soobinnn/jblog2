package com.cafe24.jblog2.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog2.vo.CategoryVo;
import com.cafe24.jblog2.vo.PostVo;

@Repository
public class PostDaoImpl implements PostDao
{
	@Autowired
	private SqlSession sqlSession;
	
	/** 블로그 글작성 **/
	@Override
	public void write(PostVo postVo)
	{
		sqlSession.insert("post.insert",postVo);
	}
	
	/** 해당 카테고리 포스트 목록 가져오기 **/
	@Override
	public List<PostVo> getPostList(String id)
	{
		return sqlSession.selectList("post.getPostList",id);
	}
	
}
