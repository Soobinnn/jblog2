package com.cafe24.jblog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog2.repository.PostDao;
import com.cafe24.jblog2.vo.PostVo;

@Service
public class PostServiceImpl implements PostService
{
	@Autowired
	private PostDao postDao;
	
	/** 블로그 글작성 **/
	@Override
	public void postWrite(PostVo postVo)
	{
		postDao.write(postVo);
	}
	
		
}
