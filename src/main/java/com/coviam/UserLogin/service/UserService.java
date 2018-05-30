package com.coviam.UserLogin.service;

import com.coviam.UserLogin.dto.UserAuthorizationResponseDto;
import com.coviam.UserLogin.dto.UserDetailsProfileDto;
import com.coviam.UserLogin.dto.SignUpUserDto;

public interface UserService {

    UserAuthorizationResponseDto authorizeUser(String userName, String password);

    UserAuthorizationResponseDto createUser(SignUpUserDto signUpUserDto);

    UserDetailsProfileDto getUser(long userId);

    }
