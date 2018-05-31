package com.coviam.UserLogin.service;

import com.coviam.UserLogin.dto.SignUpUserDto;
import com.coviam.UserLogin.dto.UserAuthorizationResponseDto;
import com.coviam.UserLogin.dto.UserDetailsProfileDto;

public interface UserService {

    UserAuthorizationResponseDto authorizeUser(String userName, String password);

    UserAuthorizationResponseDto createUser(SignUpUserDto signUpUserDto);

    UserDetailsProfileDto getUser(long userId);

}
