package com.coviam.UserLogin;

import com.coviam.UserLogin.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {

    public UserModel findByUserName(String userName);

}
