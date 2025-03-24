package com.bhd.user_api.user.dto.request;

import com.bhd.user_api.user.entity.Phone;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateUserRequest {

    @NotEmpty(message = "Nombre no puede ser vacio")
    @JsonProperty(value = "name", required = true)
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Correo invalido")
    @NotEmpty(message = "Email no puede ser vacio")
    @JsonProperty(value = "email", required = true)
    private String email;

    @NotEmpty(message = "Clave no puede ser vacio")
    @JsonProperty(value = "password", required = true)
    private String password;

    @NotEmpty(message = "Telefonos no puede ser vacio")
    @JsonProperty(value = "phones", required = true)
    private List<Phone> phones;
}
