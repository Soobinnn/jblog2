package com.cafe24.jblog2.service;


import com.cafe24.jblog2.vo.BlogVo;

public interface BlogService 
{
	/** 해당 블로그 메인 정보 가져오기 **/
	public BlogVo getInfo(String ID);
}
