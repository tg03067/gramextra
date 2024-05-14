package com.green.gramextra.user;

import com.green.gramextra.user.model.SignInReq;
import com.green.gramextra.user.model.User;
import com.green.gramextra.user.model.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpReq p);
    User selUserById(String uid);
}
