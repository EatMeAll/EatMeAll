package com.authenticateService.appliacation.services;



import com.authenticateService.appliacation.dto.TokenDTO;
import com.authenticateService.appliacation.exceptions.Unauthorized;
import com.authenticateService.domain.ports.TokenRepository;
import com.authenticateService.infrastructure.MemoryTockenRepository.MemoryTokenRepository;
import com.authenticateService.infrastructure.MemoryTockenRepository.exceptions.TokenNotFindException;

import javax.security.auth.callback.TextOutputCallback;

public class TokenAuthorization<T> {

    public static TokenAuthorization configure(){
        TokenRepository tokenRepository = new MemoryTokenRepository();
        TokenGenerator tokenGenerator = new TokenGenerator();
        return new TokenAuthorization(tokenRepository, tokenGenerator);
    }

    private TokenRepository<T> tokenRepository;
    private TokenGenerator tokenGenerator;

    private TokenAuthorization(TokenRepository tokenRepository, TokenGenerator tokenGenerator) {
        this.tokenRepository = tokenRepository;
        this.tokenGenerator = tokenGenerator;
    }

    public TokenDTO assignToken(T object)  {
        TokenDTO newToken = tokenGenerator.generate();
        tokenRepository.saveToken(object,newToken);
        return newToken;
    }

    public T authorize(TokenDTO tokenDTO) throws Unauthorized {

        try {
            T authorizedObject = tokenRepository.findByToken(tokenDTO);
            TokenDTO token = tokenRepository.getToken(authorizedObject);
            // TODO: 13.10.2018 I need method in token isExpired but i get TokenDTO [ it is correct? ]
            return authorizedObject;

        } catch (TokenNotFindException e) {
            throw new Unauthorized("Token not exist");
        }
    }


}
