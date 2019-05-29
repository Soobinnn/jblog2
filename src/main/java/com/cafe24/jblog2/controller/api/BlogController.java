package com.cafe24.jblog2.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog2.dto.JSONResult;
import com.cafe24.jblog2.service.CategoryService;
import com.cafe24.jblog2.vo.CategoryVo;

@Controller("blogAPIController")
@RequestMapping("/blog/api")
public class BlogController 
{
	@Autowired
	private CategoryService categoryService;
	
	/** 카테고리 글 작성 **/
	@ResponseBody
	@RequestMapping(value="/categoryWrite", method=RequestMethod.POST)
	public JSONResult categoryWrite(@ModelAttribute CategoryVo categoryVo)
	{
		System.out.println(categoryVo.toString());
		// 카테고리 글 작성 후 리스트 반환
		List<CategoryVo> categoryList = categoryService.WriteGetList(categoryVo);
		return JSONResult.success(categoryList);
	}
}
