package com.bhd.user_api.user;

import com.bhd.user_api.user.dto.PhoneDTO;
import com.bhd.user_api.user.dto.request.CreateUserRequest;
import com.bhd.user_api.user.dto.response.CreateUserResponse;
import com.bhd.user_api.user.entity.Phone;
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

    public static CreateUserResponse toCreateUserResponse(User user) {
        return CreateUserResponse.builder()
                .id(user.getId().toString())
                .name(user.getName())
                .email(user.getEmail())
                .phones(user.getPhones().stream().map(UserMapper::toPhoneDTO).toList())
                .build();
    }

    public static PhoneDTO toPhoneDTO(Phone phone) {
        return PhoneDTO.builder()
                .number(phone.getNumber())
                .cityCode(phone.getCityCode())
                .countryCode(phone.getCountryCode())
                .build();
    }
}
