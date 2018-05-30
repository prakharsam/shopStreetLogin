package com.coviam.UserLogin.service;

import com.coviam.UserLogin.dto.ResponseDto;
import com.coviam.UserLogin.dto.ReturnDto;
import com.coviam.UserLogin.dto.UserDto;

public interface UserService {

    ResponseDto authorizeUser(String userName, String password);

    ResponseDto createUser(UserDto userDto);

    ReturnDto getUser(long userId);

    }
