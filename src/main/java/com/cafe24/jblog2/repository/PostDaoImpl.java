package com.cafe24.jblog2.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		System.out.println(postVo.toString());
		sqlSession.insert("post.insert",postVo);
	}
}
