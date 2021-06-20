package com.smarthunter.api.contracts.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {

    private String token;
    private String type;

    public TokenResponse(String token, String type) {
        this.token = token;
        this.type = type;
    }
}
