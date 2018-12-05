package com.authenticateService.api;


import com.authenticateService.appliacation.exceptions.UnauthorizedException;
import com.authenticateService.appliacation.model.Token;
import com.authenticateService.appliacation.services.TokenAuthorizationService;
import com.authenticateService.appliacation.services.TokenMapper;

public class AuthenticationServiceFacade<Auth extends Comparable<Auth>> {

    public static AuthenticationServiceFacade configure(){

        TokenMapper tokenMapper = new TokenMapper();
        TokenAuthorizationService tokenAuthorizationService = TokenAuthorizationService.configure();
        return new AuthenticationServiceFacade(tokenAuthorizationService, tokenMapper);
    }

    private TokenAuthorizationService<Auth> tokenAuthorizationService;
    private TokenMapper tokenMapper;

    private AuthenticationServiceFacade(TokenAuthorizationService tokenAuthorizationService, TokenMapper tokenMapper) {
        this.tokenAuthorizationService = tokenAuthorizationService;
        this.tokenMapper = tokenMapper;
    }

    Auth authorize(TokenDTO tokenDTO) throws UnauthorizedException {
        return tokenAuthorizationService.authorize(tokenDTO);
    }

    public TokenDTO assignToken(Auth object){
        Token token = tokenAuthorizationService.assignToken(object);
        return tokenMapper.toTokenDTO(token);
    }
}
