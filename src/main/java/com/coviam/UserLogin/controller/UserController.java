package com.coviam.UserLogin.controller;

import com.coviam.UserLogin.service.UserService;
import com.coviam.UserLogin.dto.UserAuthorizationResponseDto;
import com.coviam.UserLogin.dto.UserDetailsProfileDto;
import com.coviam.UserLogin.dto.SignUpUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authorize",method = RequestMethod.GET)
    public UserAuthorizationResponseDto authorizeUser(@RequestParam String userName, @RequestParam String password){

        UserAuthorizationResponseDto userAuthorizationResponseDto = userService.authorizeUser(userName,password);
        return(userAuthorizationResponseDto);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public UserAuthorizationResponseDto addUser(@RequestBody SignUpUserDto signUpUserDto){

        UserAuthorizationResponseDto userAuthorizationResponseDto = userService.createUser(signUpUserDto);
        return userAuthorizationResponseDto;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public UserDetailsProfileDto getUser(@RequestParam long userId){

        UserDetailsProfileDto userDetailsProfileDto = userService.getUser(userId);
        return userDetailsProfileDto;
    }

}
