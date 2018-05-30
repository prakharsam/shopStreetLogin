package com.coviam.UserLogin.repository;

import com.coviam.UserLogin.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    UserModel findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

}
