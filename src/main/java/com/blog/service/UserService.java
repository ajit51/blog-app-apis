package com.blog.service;

import java.util.List;

import com.blog.payloads.UserDto;

public interface UserService {
	
	UserDto registerNewUser(UserDto userDto);
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto, Integer userId);
	UserDto getUserById(Integer userID);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);

}
