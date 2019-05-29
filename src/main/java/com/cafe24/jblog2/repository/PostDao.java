package com.cafe24.jblog2.repository;

import com.cafe24.jblog2.vo.PostVo;

public interface PostDao 
{
	/** 블로그 글작성 **/
	public void write(PostVo postVo);
}
