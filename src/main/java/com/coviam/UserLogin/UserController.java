package com.coviam.UserLogin;

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
    public boolean authorizeUser(@RequestParam String userName,@RequestParam String password){

        Boolean e = userService.authorizeUser(userName,password);
        return(e);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public UserDto addEmployee(@RequestBody UserDto userDto){

        UserDto userDtoReturn = userService.createUser(userDto);
        return userDtoReturn;
    }

}
