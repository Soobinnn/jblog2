package com.cafe24.jblog2.repository;

import com.cafe24.jblog2.vo.BlogVo;
import com.cafe24.jblog2.vo.UserVo;

public interface UserDao 
{
	/** 회원가입 **/
	public void insert(UserVo userVo);
	
	/** 로그인확인 **/
	public UserVo getUser(UserVo userVo);
	
	/** 이메일 체크 (ajax) **/
	public Boolean checkId(String id);
}
