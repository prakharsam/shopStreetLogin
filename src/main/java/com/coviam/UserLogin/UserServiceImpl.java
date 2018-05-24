package com.coviam.UserLogin;

import com.coviam.UserLogin.dto.UserDto;
import com.coviam.UserLogin.model.UserModel;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Boolean authorizeUser(String userName, String password){


        if (!userRepository.existsById(userName)) {
            return false;
        }

        UserModel userModel = userRepository.findByUserName(userName);
         return checkPass(password,userModel.getPassword());
    }

    public UserDto createUser(UserDto userDto) {

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);

        if (userRepository.existsById(userDto.getUserName())) {
            return null;
        }
        userModel.setPassword(hashPassword(userModel.getPassword()));
        userRepository.save(userModel);
        return userDto;
    }

    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    private boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword))
            return true;
        else
           return false;
    }

}
