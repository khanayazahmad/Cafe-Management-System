package com.cmpe202.starbucks.controller;

import com.cmpe202.starbucks.dto.CurrentUserDto;
import com.cmpe202.starbucks.model.response.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.cmpe202.starbucks.dto.UserDto;
import com.cmpe202.starbucks.service.UserService;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

	private final UserService userService;
	
	@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")

    public @ResponseBody UserResponseModel registerUser(@RequestBody UserDto userDto) throws Exception{

		UserResponseModel returnModel = new UserResponseModel();
		UserDto returnedDto = new UserDto();

		returnedDto =  userService.resgiterUser(userDto);

		ModelMapper mapper = new ModelMapper();
		mapper = new ModelMapper();
		returnModel = mapper.map(returnedDto, UserResponseModel.class);

		return returnModel;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get/currentUser")
	@PreAuthorize("hasRole('ROLE_USER')")
	public @ResponseBody
	CurrentUserDto getCurrentUser(){
		return userService.getCurrentUserDto();
	}
}
