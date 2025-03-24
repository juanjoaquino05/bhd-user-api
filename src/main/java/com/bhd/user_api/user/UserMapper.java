package com.bhd.user_api.user;

import com.bhd.user_api.user.dto.request.CreateUserRequest;
import com.bhd.user_api.user.entity.User;

public class UserMapper {
    public static User toUser(CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setPhones(request.getPhones());
        return user;
    }
}
