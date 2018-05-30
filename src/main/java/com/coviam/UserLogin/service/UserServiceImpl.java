package com.coviam.UserLogin.service;

import com.coviam.UserLogin.repository.UserRepository;
import com.coviam.UserLogin.dto.ResponseDto;
import com.coviam.UserLogin.dto.ReturnDto;
import com.coviam.UserLogin.dto.UserDto;
import com.coviam.UserLogin.model.UserModel;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class  UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseDto authorizeUser(String userName, String password){

        ResponseDto responseDto = new ResponseDto();

        if (!userRepository.existsByUserName(userName)) {
            responseDto.setResponse(false);
            responseDto.setEmail("");
            responseDto.setUserId(0);
            return responseDto;
        }

        UserModel userModel = new UserModel();

        BeanUtils.copyProperties(userRepository.findByUserName(userName), userModel);
        boolean check = checkPass(password,userModel.getPassword());
        responseDto.setResponse(check);
        if(!check) {
            responseDto.setEmail("");
            responseDto.setUserId(0);
            return responseDto;

        }
        responseDto.setEmail(userModel.getEmail());
        responseDto.setUserId(userModel.getUserId());
        return responseDto;

    }

    public ResponseDto createUser(UserDto userDto) {

        ResponseDto responseDto = new ResponseDto();
        UserModel userModel = new UserModel();
        if (userRepository.existsByUserName(userDto.getUserName())||userRepository.existsByEmail(userDto.getEmail())) {
            userModel = userRepository.findByUserName(userDto.getUserName());
            responseDto.setResponse(false);
            responseDto.setEmail(userModel.getEmail());
            responseDto.setUserId(userModel.getUserId());
            return responseDto;
        }

        BeanUtils.copyProperties(userDto, userModel);

        userModel.setPassword(hashPassword(userModel.getPassword()));
        userRepository.save(userModel);
        BeanUtils.copyProperties(userModel,responseDto);
        responseDto.setResponse(true);

        return responseDto;
    }

    @Override
    public ReturnDto getUser(long userId) {

        UserModel   userModel = userRepository.findById(userId).get();
        ReturnDto returnDto = new ReturnDto();

        BeanUtils.copyProperties(userModel,returnDto);

        return returnDto;
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
