package com.cafe24.jblog2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jblog2.service.BlogService;
import com.cafe24.jblog2.vo.BlogVo;

@Controller
public class BlogController 
{
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("test")
	public String test()
	{
		return "blog/blog-main";
	}
	@RequestMapping("test1")
	public String test1()
	{
		return "blog/blog-admin-basic";
	}
	@RequestMapping("test2")
	public String test2()
	{
		return "blog/blog-admin-category";
	}
	@RequestMapping("test3")
	public String test3()
	{
		return "blog/blog-admin-write";
	}
	
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
}
