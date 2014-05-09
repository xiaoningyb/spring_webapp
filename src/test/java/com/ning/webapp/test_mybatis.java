package com.ning.webapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ning.webapp.user.dao.*;
import com.ning.webapp.user.model.*;

public class test_mybatis {

	public static void main(String[] args) 
	{
		ApplicationContext ctx=null;
		ctx=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
		UserEntityMapper userMapper=(UserEntityMapper)ctx.getBean("userMapper");
		UserEntity u=new UserEntity();
		u.setName("xiao");
		u.setPwd("123");
		Integer idx = 1;
		System.out.println(userMapper.selectByPrimaryKey(idx).getName());
		//插入（去掉下面的注释进行调试）
		/*
		User insertUser=new User();
		insertUser.setUsername("testUsername");
		insertUser.setPassword("testPassword");
		userMapper.insertUser(insertUser);
		*/
		//更新（去掉下面的注释进行调试）
		/*
		u.setId(1);
		u.setPassword("updatePassword");
		userMapper.updateUser(u);
		*/
		//删除（去掉下面的注释进行调试）
		/*
		userMapper.deleteUser(9);
		*/
	}
}
