package com.bhd.user_api.user;

import com.bhd.user_api.error.UserError;
import com.bhd.user_api.user.dto.request.CreateUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity signup(CreateUserRequest request) {
        var newUser = UserMapper.toUser(request);
        var now = new Date();
        newUser.setLastLogin(now);
        newUser.setCreated(now);
        newUser.setModified(now);

        try {
            var createdUser = userRepository.save(newUser);

            log.info("User created successfully :: {}", createdUser);
            return ResponseEntity.ok(createdUser);
        } catch (Exception e) {
            log.error("Error creating user :: {}", e.getMessage());
            if (e.getMessage().toLowerCase().contains("duplicate entry")) {
                return ResponseEntity.badRequest().body(new UserError("E-mail already exists"));
            } else {
                return ResponseEntity.badRequest().body(new UserError("Error creating user"));
            }
        }
    }
}
