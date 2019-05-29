package com.cafe24.jblog2.service;

import com.cafe24.jblog2.vo.PostVo;

public interface PostService 
{
	/** 블로그 글작성 **/
	public void postWrite(PostVo postVo);
}
