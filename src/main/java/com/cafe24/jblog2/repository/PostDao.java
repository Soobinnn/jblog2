package com.cafe24.jblog2.repository;

import java.util.List;

import com.cafe24.jblog2.vo.PostVo;

public interface PostDao 
{
	/** 블로그 글작성 **/
	public void write(PostVo postVo);
	
	/** 해당 카테고리 포스트 목록 가져오기 **/
	public List<PostVo> getPostList(String id); 
}
