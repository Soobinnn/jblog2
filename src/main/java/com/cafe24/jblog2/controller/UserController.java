package com.cafe24.jblog2.controller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.jblog2.service.UserService;
import com.cafe24.jblog2.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	/** 로그인 **/
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login()
	{
		return "user/login";
	}
	
	
	/** 회원가입 **/
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute UserVo userVo)
	{
		return "user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model)
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
			
			return "/user/join";
		}

		userService.join(userVo);
		
		return "redirect:/user/joinsuccess";
	}
	
	/** 가입성공 **/
	@RequestMapping("/joinsuccess")
	public String joinSuccess()
	{
		return "user/joinsuccess";
	}
	
	
}
