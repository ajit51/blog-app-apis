package com.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.blog.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "Username must be min of 4 characters !!")
	private String name;
	
	@NotEmpty
	@Email(message = "Email address is not valid")
	private String email;
	
	//@JsonIgnore
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars !!")
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<Role> roles = new HashSet<>();


}
