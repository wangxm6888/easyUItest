package com.huatian.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huatian.entity.Login;
import com.huatian.util.JsonResult;

@Controller
@RequestMapping(value = "/userController")
public class UserController {
	@RequestMapping(value = "/login.do")
	@ResponseBody
	public JsonResult<List<Login>> login(Login login) {
		System.out.println("eeeeee" + login.getName()  + "  " + login.getPassword());
		Map<String, String> map = new HashMap<String,String>();
		Login login2 = new Login();
		login2.setId("2");
		login2.setName("小明");
		login2.setPassword("hehe");
		List<Login> list = new ArrayList<Login>();
		list.add(login2);
		return new JsonResult<List<Login>>(0, "访问成功", list);
	}
	
	
	@RequestMapping(value = "/value.do")
	@ResponseBody
	public List<Login> getLogin(String page,String rows)
	{
		System.out.println(page + "  :  " + rows);
		return getLoginList(page,rows);
	}
	
	@RequestMapping(value = "/value2.do")
	@ResponseBody
	public Map<String, Object> getMap(String page,String rows,String sort,String order)
	{
		Login log = new Login();
		BeanUtils.copyProperties(this, log);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("total", 12);
		map.put("rows", getLoginList(page, rows));
		return map;
	}
	
	public List<Login> getLoginList(String page,String rows)
	{
		
		List<Login> list = new ArrayList<>();
		for(int i = 1; i <= 30;i++)
		{
			Login login = new Login();
			login.setId(String.valueOf(i));
			login.setName("wangxiaoming " + i);
			login.setPassword("pass " + i);
			list.add(login);
		}
		return list;
	}
	public void writeJson(Object o)
	{
//		String json = getJsonString(o);
		
//		ServletActionContext.
	}

}
