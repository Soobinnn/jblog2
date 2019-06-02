package com.cafe24.jblog2.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.jblog2.service.BlogService;
import com.cafe24.jblog2.service.CategoryService;
import com.cafe24.jblog2.service.FileuploadService;
import com.cafe24.jblog2.service.PostService;
import com.cafe24.jblog2.vo.BlogVo;
import com.cafe24.jblog2.vo.CategoryVo;
import com.cafe24.jblog2.vo.PostVo;
import com.cafe24.jblog2.vo.UserVo;
import com.cafe24.security.Auth;


@Controller
@RequestMapping({"/{ID:^(?!assets)(?!images).*}", "/{ID:^(?!assets)(?!images).*}/{categoryno}","/{ID:^(?!assets)(?!images).*}/{categoryno}/{postno}"})
public class BlogController 
{
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FileuploadService fileuploadService;
	
	/** 블로그 메인 **/
	@RequestMapping("")
	public String blog(@PathVariable String ID,@PathVariable Optional<Long> categoryno,@PathVariable Optional<Long> postno, Model model)
	{
		long categoryNo = categoryno.isPresent() ? categoryno.get() : 0;
		long postNo = postno.isPresent() ? postno.get() : 0;
		
		/** 메인 컨텐츠 가져오기 **/
		Map<String, Object> mainView = postService.mainView(ID, categoryNo, postNo);
		
		/**블로그 정보 **/
		BlogVo blogVo = blogService.getInfo(ID);
		
		//예외처리
		if(blogVo == null || mainView == null)
		{
			return "";
		}

		model.addAttribute("blogInfo",blogVo);
		model.addAttribute("mainView", mainView);
		return "blog/blog-main";
	}
	
	/** 블로그 관리페이지 **/
	@Auth
	@RequestMapping("/admin")
	public String blogAdmin(@PathVariable String ID, @RequestParam(value="n",required=false, defaultValue="1") int nav_no, 
			@ModelAttribute PostVo postVo, Model model)
	{
			
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
				List<CategoryVo> categoryNameList = categoryService.getCategoryNameList(ID);
				model.addAttribute("categoryNameList",categoryNameList);
				return "blog/blog-admin-write";
			}
			
			return "blog/blog-admin-basic";
	}
	
	/** 블로그 포스트 작성 **/
	@Auth
	@RequestMapping(value="/postWrite", method=RequestMethod.POST)
	public String blogWrite(@PathVariable String ID, @ModelAttribute @Valid PostVo postVo, BindingResult result, Model model)
	{
		
		  //예외처리하기
		  if(result.hasErrors())
			{
				List<ObjectError> list = result.getAllErrors();
				for(ObjectError error : list)
				{
					System.out.println(error);
				}
				
				model.addAllAttributes(result.getModel());
				
				List<CategoryVo> categoryNameList = categoryService.getCategoryNameList(ID);
				BlogVo blogVo = blogService.getInfo(ID);
				
				model.addAttribute("categoryNameList",categoryNameList);
				model.addAttribute("nav_no",3);
				model.addAttribute("blogInfo",blogVo);
				
				return "blog/blog-admin-write";
			}
		  
			postService.postWrite(postVo);
			System.out.println(postVo.toString());
			//"redirect:/"+ID+"/Category/Post?no="+boardVo.getBoard_no();
			return "redirect:/"+ID+"/"+postVo.getCATEGORY_NO()+"/"+postVo.getPOST_NO();
	}
	
	/** 블로그 정보 업데이트**/
	@Auth
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(
	@PathVariable String ID,
	@RequestParam(value="title", required=true, defaultValue="") String title,
	@RequestParam(value="logo-file") MultipartFile multipartFile,
	Model model) 
	{
		String url = fileuploadService.restore( multipartFile );
		
		
		BlogVo blogVo = new BlogVo();
		
		blogVo.setID(ID);
		blogVo.setTITLE(title);
		blogVo.setLOGO(url);
		
		blogService.updateBlog(blogVo);
		
		System.out.println(url);
		
		return "redirect:/"+ID+"/admin";
	}
	
}
