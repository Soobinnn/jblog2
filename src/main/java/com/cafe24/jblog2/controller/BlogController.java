package com.cafe24.jblog2.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.jblog2.service.BlogService;
import com.cafe24.jblog2.service.CategoryService;
import com.cafe24.jblog2.service.PostService;
import com.cafe24.jblog2.vo.BlogVo;
import com.cafe24.jblog2.vo.CategoryVo;
import com.cafe24.jblog2.vo.PostVo;
import com.cafe24.jblog2.vo.UserVo;


@Controller
public class BlogController 
{
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	/** 블로그 메인 **/
	@RequestMapping("/{ID}")
	public String blog(@PathVariable String ID, Model model)
	{
		BlogVo blogVo = blogService.getInfo(ID);
		
		// 
		if(blogVo == null)
		{
			return "";
		}
		
		model.addAttribute("blogInfo",blogVo);
		return "blog/blog-main";
	}
	
	/** 블로그 관리페이지 **/
	@RequestMapping("/{ID}/admin")
	public String blogAdmin(@PathVariable String ID,HttpSession session, @RequestParam(value="n",required=false, defaultValue="1") int nav_no,Model model)
	{
			UserVo checkUser = (UserVo)session.getAttribute("authUser");
			
			// 본인 블로그가 아닌사람이 접근할 경우 예외처리
			if(checkUser==null || !(ID.equals(checkUser.getID())))
			{
				return "redirect:/";
			}
			
			BlogVo blogVo = blogService.getInfo(ID);
			
			model.addAttribute("nav_no",nav_no);
			model.addAttribute("blogInfo",blogVo);
			
			// 카테고리관리 페이지
			if(nav_no ==2)
			{
				/** 블로그 카테고리 목록 가져오기 **/
				List<CategoryVo> categoryList = categoryService.getCategoryList(ID);
				model.addAttribute("categoryList",  categoryList);
				
				return "blog/blog-admin-category";
			}
			// 포스트관리 페이지
			else if(nav_no ==3)
			{
				/** 카테고리명 가져오기 **/
				
				return "blog/blog-admin-write";
			}
			
			return "blog/blog-admin-basic";
	}
	
	/** 블로그 포스트 작성 **/
	@RequestMapping(value="/{ID}/postWrite", method=RequestMethod.POST)
	public String blogWrite(@PathVariable String ID, @ModelAttribute PostVo postVo, Model model)
	{
			postService.postWrite(postVo);
			//"redirect:/"+ID+"/Category/Post?no="+boardVo.getBoard_no();
			return "blog/Post";
	}
	
	
}
