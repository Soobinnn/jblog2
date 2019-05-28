package com.cafe24.jblog2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog2.repository.BlogDao;
import com.cafe24.jblog2.vo.BlogVo;

@Service
public class BlogServiceImpl implements BlogService
{
	@Autowired
	private BlogDao blogDao;
	
	/** 해당 블로그 메인 정보 가져오기 **/
	@Override
	public BlogVo getInfo(String ID)
	{
		return blogDao.getInfo(ID);
	}
	
}
