package com.cafe24.jblog2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog2.repository.CategoryDao;
import com.cafe24.jblog2.repository.PostDao;
import com.cafe24.jblog2.vo.CategoryVo;
import com.cafe24.jblog2.vo.PostVo;

@Service
public class PostServiceImpl implements PostService
{
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	/** 블로그 글작성 **/
	@Override
	public void postWrite(PostVo postVo)
	{
		postDao.write(postVo);
	}
	
	/** 메인 컨텐츠 가져오기**/
	@Override
	public Map<String, Object> mainView(String id, Long categoryNo, Long postNo)
	{
		if(categoryNo ==0 && postNo ==0)
		{
			// 최근 포스트 내용 가져오기
			
		}
		else if(postNo == 0)
		{
				// 해당 카테고리의 최근 포스트 내용 가져오기
				PostVo postView = postDao.getPostView(categoryNo);
		}
		
		// 해당 포스트내용 가져오기
		PostVo postView = postDao.getPostView();
		
		// 포스트 목록가져오기
		List<PostVo> postList = postDao.getPostList(id); 

		// 카테고리 가져오기
		List<CategoryVo> categoryList = categoryDao.getCategoryList(id);
		
		Map<String, Object> mainView = new HashMap<String, Object>();
		
		return mainView;
	}
}
