package com.ning.webapp.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ning.webapp.user.model.UserEntity;
import com.ning.webapp.user.services.IUserService;
import com.ning.webapp.user.model.UserEntity;

@Controller  //类似Struts的Action
@RequestMapping("/user")
public class UserController {
	
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/{id}/index.do") // 请求url地址映射，类似Struts的action-mapping
	public ModelAndView testLogin(@PathVariable int id, HttpServletRequest request) {
		UserEntity u = userService.getUserById(id);
		if(u.getName().equalsIgnoreCase("nxiao"))
		{
			return new ModelAndView(new RedirectView("../../index.jsp"));
		}
		else
		{
			return new ModelAndView(new RedirectView(u.getName()));
		}
	}
	
	@RequestMapping("/users.do") // 请求url地址映射，类似Struts的action-mapping
	@ResponseBody
	public Object testAjax(HttpServletRequest request) {
		UserEntity u1 = userService.getUserById(1);
		UserEntity u2 = userService.getUserById(2);
		UserEntity u3 = userService.getUserById(3);
		List<String> list=new ArrayList<String>(); 
		list.add(u1.getName());
		list.add(u2.getName());
		list.add(u3.getName());
		return list;  
	}
	
	@RequestMapping("/hello.do")
    public String sayHello(ModelMap map) {
        System.out.println("say Hello ……");
        UserEntity u = userService.getUserById(1);
        map.addAttribute("name", u.getName());
        return "/hello.ftl";
    }
    
    @RequestMapping("/hi.do")
    public String sayHi(ModelMap map) {
        System.out.println("say hi ……");
        UserEntity u = userService.getUserById(2);
        map.put("name", u.getName());
        return "/hi.ftl";
    }
    
    @RequestMapping("/jsp.do")
    public String jspRequest(ModelMap map) {
        System.out.println("jspRequest ……");
        UserEntity u = userService.getUserById(3);
        map.put("name", u.getName());
        return "/temp";
    }

	/*
	@RequestMapping("/ning-webapp/login2.do")
	public ModelAndView testLogin2(String username, String password, int age){
		// request和response不必非要出现在方法中，如果用不上的话可以去掉
		// 参数的名称是与页面控件的name相匹配，参数类型会自动被转换
		
		if (!"admin".equals(username) || !"admin".equals(password) || age < 5) {
			return new ModelAndView("loginError"); // 手动实例化ModelAndView完成跳转页面（转发），效果等同于上面的方法返回字符串
		}
		return new ModelAndView(new RedirectView("../index.jsp"));  // 采用重定向方式跳转页面
		// 重定向还有一种简单写法
		// return new ModelAndView("redirect:../index.jsp");
	}
	*/

	/*
	@Resource(name = "loginService")  // 获取applicationContext.xml中bean的id为loginService的，并注入
	private LoginService loginService;  //等价于spring传统注入方式写get和set方法，这样的好处是简洁工整，省去了不必要得代码

	@RequestMapping("/ning/login4.do")
	public String testLogin4(User user) {
		if (loginService.login(user) == false) {
			return "loginError";
		}
		return "loginSuccess";
	}
	*/
}