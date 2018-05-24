package com.coviam.UserLogin;

import com.coviam.UserLogin.dto.UserDto;

public interface UserService {

    public Boolean authorizeUser(String userName, String password);

    public UserDto createUser(UserDto userDto);

    }
