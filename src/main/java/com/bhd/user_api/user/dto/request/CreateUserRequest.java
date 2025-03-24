package com.bhd.user_api.user.dto.request;

import com.bhd.user_api.user.entity.Phone;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateUserRequest {

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "email", required = true)
    private String email;

    @JsonProperty(value = "password", required = true)
    private String password;

    @JsonProperty(value = "phones", required = true)
    private List<Phone> phones;
}
