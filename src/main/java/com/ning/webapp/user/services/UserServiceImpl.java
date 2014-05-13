package com.ning.webapp.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ning.webapp.user.model.UserEntity;
import com.ning.webapp.user.dao.UserEntityMapper;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Override
	public UserEntity getUserById(int id) {
		// TODO Auto-generated method stub
		UserEntity usr = userMapper.selectByPrimaryKey(id);
		return usr;
	}
	
	private UserEntityMapper userMapper;
	
	public UserEntityMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserEntityMapper userMapper) {
		this.userMapper = userMapper;
	}

}
