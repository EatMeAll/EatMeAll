package com.authenticateService.appliacation.services;

import com.authenticateService.api.TokenDTO;
import com.authenticateService.appliacation.model.Token;

public class TokenMapper {

    public Token toToken(TokenDTO tokenDTO){
        return new Token(tokenDTO.getValue());
    }

    public TokenDTO toTokenDTO(Token token){
        return new TokenDTO(token.getValue());
    }
}
