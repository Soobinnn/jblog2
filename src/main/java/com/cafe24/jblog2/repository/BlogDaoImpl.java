package com.cafe24.jblog2.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog2.vo.BlogVo;

@Repository
public class BlogDaoImpl implements BlogDao
{
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입시 자동으로 블로그 생성
	@Override
	public void createBlog(BlogVo blogVo)
	{
		sqlSession.insert("blog.insertBlog", blogVo);
	}
	
	/** 해당 블로그 메인 정보 가져오기 **/
	@Override
	public BlogVo getInfo(String ID)
	{
		return sqlSession.selectOne("blog.getInfo",ID);
	}
	
	/** 블로그 정보 업데이트**/
	@Override
	public void updateBlog(BlogVo blogVo)
	{
		if("".equals(blogVo.getLOGO()))
		{
			sqlSession.update("blog.updateBlogTitle", blogVo);
		}
		else
		{
			sqlSession.update("blog.updateBlog", blogVo);
		}
		
	}
}
