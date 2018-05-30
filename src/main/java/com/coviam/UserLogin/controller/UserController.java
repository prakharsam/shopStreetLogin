package com.coviam.UserLogin.controller;

import com.coviam.UserLogin.service.UserService;
import com.coviam.UserLogin.dto.ResponseDto;
import com.coviam.UserLogin.dto.ReturnDto;
import com.coviam.UserLogin.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authorize",method = RequestMethod.GET)
    public ResponseDto authorizeUser(@RequestParam String userName, @RequestParam String password){

        ResponseDto responseDto = userService.authorizeUser(userName,password);
        return(responseDto);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDto addUser(@RequestBody UserDto userDto){

        ResponseDto responseDto = userService.createUser(userDto);
        return responseDto;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ReturnDto getUser(@RequestParam long userId){

        ReturnDto returnDto = userService.getUser(userId);
        return returnDto;
    }

}
