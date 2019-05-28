package com.cafe24.jblog2.service;

import com.cafe24.jblog2.vo.UserVo;

public interface UserService 
{
	/** 회원가입 **/
	public void join(UserVo userVo);
	
	/** 로그인확인 **/
	public UserVo getUser(UserVo userVo);
}
