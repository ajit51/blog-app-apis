package com.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entities.User;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.UserDto;
import com.blog.service.UserService;

@SuppressWarnings({ "unchecked", "unchecked", "rawtypes", "unchecked" })
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUser = userService.createUser(userDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer userId) {
		UserDto updateUser = userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updateUser);
	}

	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
		UserDto userDto = userService.getUserById(userId);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
	}

}
