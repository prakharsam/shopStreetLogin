package com.coviam.UserLogin.service.serviceImpl;

import com.coviam.UserLogin.dto.SignUpUserDto;
import com.coviam.UserLogin.dto.UserAuthorizationResponseDto;
import com.coviam.UserLogin.dto.UserDetailsProfileDto;
import com.coviam.UserLogin.model.UserModel;
import com.coviam.UserLogin.repository.UserRepository;
import com.coviam.UserLogin.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserAuthorizationResponseDto authorizeUser(String userName, String password) {

        UserAuthorizationResponseDto userAuthorizationResponseDto = new UserAuthorizationResponseDto();

        if (!userRepository.existsByUserName(userName)) {
            userAuthorizationResponseDto.setResponse(false);
            userAuthorizationResponseDto.setEmail("");
            userAuthorizationResponseDto.setUserId(0);
            return userAuthorizationResponseDto;
        }

        UserModel userModel = new UserModel();

        BeanUtils.copyProperties(userRepository.findByUserName(userName), userModel);
        boolean check = checkPass(password, userModel.getPassword());
        userAuthorizationResponseDto.setResponse(check);
        if (!check) {
            userAuthorizationResponseDto.setEmail("");
            userAuthorizationResponseDto.setUserId(0);
            return userAuthorizationResponseDto;

        }
        userAuthorizationResponseDto.setEmail(userModel.getEmail());
        userAuthorizationResponseDto.setUserId(userModel.getUserId());
        return userAuthorizationResponseDto;

    }

    public UserAuthorizationResponseDto createUser(SignUpUserDto signUpUserDto) {

        UserAuthorizationResponseDto userAuthorizationResponseDto = new UserAuthorizationResponseDto();
        UserModel userModel = new UserModel();
        if (userRepository.existsByUserName(signUpUserDto.getUserName()) || userRepository.existsByEmail(signUpUserDto.getEmail())) {
            userModel = userRepository.findByUserName(signUpUserDto.getUserName());
            userAuthorizationResponseDto.setResponse(false);
            userAuthorizationResponseDto.setEmail(userModel.getEmail());
            userAuthorizationResponseDto.setUserId(userModel.getUserId());
            return userAuthorizationResponseDto;
        }

        BeanUtils.copyProperties(signUpUserDto, userModel);

        userModel.setPassword(hashPassword(userModel.getPassword()));

        UserModel userModelCheck = userRepository.save(userModel);

        if (userModelCheck.equals(null)) {
            userAuthorizationResponseDto.setResponse(false);
            userAuthorizationResponseDto.setEmail("");
            userAuthorizationResponseDto.setUserId(0);
            return userAuthorizationResponseDto;
        }
        BeanUtils.copyProperties(userModel, userAuthorizationResponseDto);
        userAuthorizationResponseDto.setResponse(true);

        return userAuthorizationResponseDto;

    }

    @Override
    public UserDetailsProfileDto getUser(long userId) {


        UserDetailsProfileDto userDetailsProfileDto = new UserDetailsProfileDto();

        UserModel userModel = userRepository.findById(userId).get();
        if (userModel.equals(null)) {
            userDetailsProfileDto.setResponse(false);
            return userDetailsProfileDto;
        }
        BeanUtils.copyProperties(userModel, userDetailsProfileDto);

        return userDetailsProfileDto;
    }

    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    private boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword))
            return true;
        else
            return false;
    }

}
