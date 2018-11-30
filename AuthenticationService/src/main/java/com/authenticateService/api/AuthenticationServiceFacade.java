package com.authenticateService.api;


import com.authenticateService.appliacation.dto.Token;
import com.authenticateService.appliacation.exceptions.Unauthorized;
import com.authenticateService.appliacation.services.TokenAuthorizationService;

public class AuthenticationServiceFacade<Auth extends Comparable<Auth>> {

    public static AuthenticationServiceFacade configure(){


        TokenAuthorizationService tokenAuthorizationService = TokenAuthorizationService.configure();
        return new AuthenticationServiceFacade(tokenAuthorizationService);
    }

    private TokenAuthorizationService<Auth> tokenAuthorizationService;

    private AuthenticationServiceFacade(TokenAuthorizationService tokenAuthorizationService) {
        this.tokenAuthorizationService = tokenAuthorizationService;
    }

    Auth authorize(TokenDTO tokenDTO) throws Unauthorized {
        return tokenAuthorizationService.authorize(tokenDTO);
    }

    public TokenDTO assignToken(Auth object){
        return tokenAuthorizationService.assignToken(object).toTokenDTO();
    }
}
