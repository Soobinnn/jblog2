package com.cafe24.jblog2.service;

import java.util.Map;

import com.cafe24.jblog2.vo.PostVo;

public interface PostService 
{
	/** 블로그 글작성 **/
	public void postWrite(PostVo postVo);
	
	/** 메인 컨텐츠 가져오기**/
	public Map<String, Object> mainView(String id, Long categoryNo, Long postNo);
}
