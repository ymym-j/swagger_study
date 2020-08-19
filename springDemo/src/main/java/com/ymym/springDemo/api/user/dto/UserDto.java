package com.ymym.springDemo.api.user.dto;

import com.ymym.springDemo.core.constant.UserType;

import lombok.Data;

@Data
public class UserDto {
	private long userId;
	private String userName;
	private UserType type;
	private String phoneNumber;
}
