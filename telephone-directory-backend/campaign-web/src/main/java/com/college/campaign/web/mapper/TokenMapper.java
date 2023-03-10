package com.college.campaign.web.mapper;

import com.college.campaign.web.token.TokenDTO;


public class TokenMapper {

    private TokenMapper() {
    }

    public static TokenDTO convertTokenDTO(String token, String username) {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(token);
        tokenDTO.setUsername(username);
        tokenDTO.setPrefix("ADMIN_TOKEN");

        return tokenDTO;
    }

    public static TokenDTO convertToTokenDTO(String token) {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(token);
        return tokenDTO;
    }
}
