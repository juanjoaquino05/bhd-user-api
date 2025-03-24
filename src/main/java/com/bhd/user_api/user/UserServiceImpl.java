package com.bhd.user_api.user;

import com.bhd.user_api.error.UserError;
import com.bhd.user_api.user.dto.request.CreateUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import static com.bhd.user_api.user.UserMapper.toCreateUserResponse;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity signup(CreateUserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        var newUser = UserMapper.toUser(request);
        var now = new Date();
        newUser.setLastLogin(now);
        newUser.setCreated(now);
        newUser.setModified(now);

        try {
            var createdUser = userRepository.save(newUser);

            log.info("User created successfully :: {}", createdUser);
            return ResponseEntity.ok(toCreateUserResponse(createdUser));
        } catch (Exception e) {
            log.error("Error creating user :: {}", e.getMessage());
            if (e.getMessage().toLowerCase().contains("duplicate entry")) {
                return ResponseEntity.badRequest().body(new UserError("El correo ya esta registrado"));
            } else {
                return ResponseEntity.badRequest().body(new UserError("Error creando usuario"));
            }
        }
    }
}
