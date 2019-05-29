package com.cafe24.jblog2.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog2.dto.JSONResult;
import com.cafe24.jblog2.service.UserService;

@Controller("userAPIController")
@RequestMapping("/user/api")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkId")
	public JSONResult checkId(@RequestParam(value="ID", required=true, defaultValue="") String id)
	{
		Boolean check = userService.checkId(id);
		return JSONResult.success(check);
	}
	

}
