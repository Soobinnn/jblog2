package com.cafe24.jblog2.service;

import java.util.ArrayList;
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
		PostVo postView = new PostVo();
		List<PostVo> postList = new ArrayList<PostVo>();
		
		if(categoryNo ==0 && postNo ==0)
		{
			System.out.println("default");
			// 최근 포스트 내용 가져오기
			postView = postDao.getPostView(id);
			// 포스트 목록가져오기
			postList = postDao.getPostList(postView.getCATEGORY_NO()); 
			
		}
		else if(categoryNo == 0 && postNo >0)
		{
			System.out.println("카테고리0");
			return null;
		}
		else
		{
			System.out.println("포스트0 or AL");
			// 해당 카테고리의 최근 포스트 내용 가져오기
			postView = postDao.getPostView(categoryNo);
			
			if(postView != null)
			{
				// 포스트 목록가져오기
				postList = postDao.getPostList(postView.getCATEGORY_NO());
			}
		}


		// 카테고리 가져오기
		List<CategoryVo> categoryList = categoryDao.getCategoryList(id);
		
		Map<String, Object> mainContent = new HashMap<String, Object>();
		
		mainContent.put("postView", postView);
		mainContent.put("postList", postList);
		mainContent.put("categoryList", categoryList);
		
		
		return mainContent;
	}
}
