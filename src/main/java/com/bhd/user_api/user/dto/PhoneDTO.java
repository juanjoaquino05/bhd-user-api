package com.bhd.user_api.user.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PhoneDTO {
    private String number;
    private String cityCode;
    private String countryCode;
}
