package com.cafe24.jblog2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog2.repository.BlogDao;
import com.cafe24.jblog2.repository.PostDao;
import com.cafe24.jblog2.vo.BlogVo;
import com.cafe24.jblog2.vo.PostVo;

@Service
public class BlogServiceImpl implements BlogService
{
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private PostDao postDao;
	
	/** 해당 블로그 메인 정보 가져오기 **/
	@Override
	public BlogVo getInfo(String ID)
	{
		return blogDao.getInfo(ID);
	}

	/** 블로그 정보 업데이트**/
	@Override
	public void updateBlog(BlogVo blogVo)
	{
		blogDao.updateBlog(blogVo);
	}
}
