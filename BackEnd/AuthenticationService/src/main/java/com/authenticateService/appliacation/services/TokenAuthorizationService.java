package com.authenticateService.appliacation.services;



import com.authenticateService.api.TokenDTO;
import com.authenticateService.appliacation.dto.Token;
import com.authenticateService.appliacation.exceptions.Unauthorized;
import com.authenticateService.domain.ports.TokenRepository;
import com.authenticateService.infrastructure.MemoryTockenRepository.MemoryTokenRepository;
import com.authenticateService.infrastructure.MemoryTockenRepository.exceptions.TokenIsExpiredException;
import com.authenticateService.infrastructure.MemoryTockenRepository.exceptions.TokenNotFindException;

public class TokenAuthorizationService<Auth extends Comparable<Auth>> {

    public static TokenAuthorizationService configure(){
        TokenRepository tokenRepository = new MemoryTokenRepository();
        TokenGenerator tokenGenerator = new TokenGenerator();
        return new TokenAuthorizationService(tokenRepository, tokenGenerator);
    }

    private TokenRepository<Auth> tokenRepository;
    private TokenGenerator tokenGenerator;

    private TokenAuthorizationService(TokenRepository tokenRepository, TokenGenerator tokenGenerator) {
        this.tokenRepository = tokenRepository;
        this.tokenGenerator = tokenGenerator;
    }

    public Token assignToken(Auth object)  {
        Token newToken = tokenGenerator.generate();
        tokenRepository.saveToken(object,newToken);
        return newToken;
    }

    public Auth authorize(TokenDTO tokenDTO) throws Unauthorized {

        try {
            return tokenRepository.findByToken(new Token(tokenDTO));
        } catch (TokenNotFindException | TokenIsExpiredException e) {
            throw new Unauthorized(e.getMessage());
        }
    }


}
