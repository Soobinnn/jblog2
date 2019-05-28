package com.cafe24.jblog2.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="ID", required=true, defaultValue="") String id,
			@RequestParam(value="PASSWORD", required=true, defaultValue="") String password, 
			HttpSession session, Model model)
	{
		UserVo authUser = userService.getUser(new UserVo(id, password));
		
		if(authUser == null) 
		{
			model.addAttribute("result", "fail");
			return "user/login";
		}
		
		// session 처리
		session.setAttribute("authUser", authUser);
		
		return "redirect:/";
	}
	
	/** 로그아웃 **/
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	/** 회원가입 **/
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join()
	{
		return "user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo, Model model)
	{
		//예외처리하기
	/*  if(result.hasErrors())
		{
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list)
			{
				System.out.println(error);
			}
			
			model.addAllAttributes(result.getModel());
			
			return "/user/join";
		}*/

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
