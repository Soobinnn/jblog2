package com.cafe24.jblog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog2.repository.BlogDao;
import com.cafe24.jblog2.repository.CategoryDao;
import com.cafe24.jblog2.repository.UserDao;
import com.cafe24.jblog2.vo.BlogVo;
import com.cafe24.jblog2.vo.UserVo;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	/** 회원가입 **/
	@Override
	public void join(UserVo userVo)
	{
		userDao.insert(userVo);
		
		BlogVo blogVo = new BlogVo();	
		blogVo.DefaultBlogSetting(userVo.getID());
		
		//회원가입시 자동으로 블로그 생성
		blogDao.createBlog(blogVo);
		
		//카테고리 default(미분류) 생성
		categoryDao.defaultCategory(userVo.getID());
	}
	
	/** 로그인확인 **/
	@Override
	public UserVo getUser(UserVo userVo)
	{
		return userDao.getUser(userVo);
	}
	/** 이메일 체크 (ajax) **/
	@Override
	public Boolean checkId(String id)
	{
		return userDao.checkId(id);
	}
}
