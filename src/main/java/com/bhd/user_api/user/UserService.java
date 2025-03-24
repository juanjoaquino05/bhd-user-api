package com.bhd.user_api.user;

import com.bhd.user_api.user.dto.request.CreateUserRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity signup(CreateUserRequest request);
}
