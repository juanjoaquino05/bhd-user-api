package com.bhd.user_api.user.dto.response;

import com.bhd.user_api.user.dto.PhoneDTO;
import com.bhd.user_api.user.entity.Phone;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public class CreateUserResponse {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "phones")
    private List<PhoneDTO> phones;

}
