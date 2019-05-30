package com.cafe24.jblog2.repository;


import com.cafe24.jblog2.vo.BlogVo;

public interface BlogDao 
{
	/**회원가입시 자동으로 블로그 생성 **/
	public void createBlog(BlogVo blogVo);
	
	/** 해당 블로그 메인 정보 가져오기 **/
	public BlogVo getInfo(String ID);
	
	/** 블로그 정보 업데이트**/
	public void updateBlog(BlogVo blogVo);
	
}
