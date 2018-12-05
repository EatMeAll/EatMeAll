package com.authenticateService.appliacation.services;



import com.authenticateService.api.TokenDTO;
import com.authenticateService.appliacation.model.Token;
import com.authenticateService.appliacation.exceptions.UnauthorizedException;
import com.authenticateService.domain.ports.TokenRepository;
import com.authenticateService.infrastructure.MemoryTockenRepository.MemoryTokenRepository;
import com.authenticateService.infrastructure.MemoryTockenRepository.exceptions.TokenIsExpiredException;
import com.authenticateService.infrastructure.MemoryTockenRepository.exceptions.TokenNotFindException;

public class TokenAuthorizationService<Auth extends Comparable<Auth>> {

    public static TokenAuthorizationService configure(){
        TokenRepository tokenRepository = new MemoryTokenRepository();
        TokenGenerator tokenGenerator = new TokenGenerator();
        TokenMapper tokenMapper = new TokenMapper();
        return new TokenAuthorizationService(tokenRepository, tokenGenerator,tokenMapper);
    }

    private TokenRepository<Auth> tokenRepository;
    private TokenGenerator tokenGenerator;
    private TokenMapper tokenMapper;

    private TokenAuthorizationService(TokenRepository tokenRepository, TokenGenerator tokenGenerator, TokenMapper tokenMapper) {
        this.tokenRepository = tokenRepository;
        this.tokenGenerator = tokenGenerator;
        this.tokenMapper = tokenMapper;
    }

    public Token assignToken(Auth object)  {
        Token newToken = tokenGenerator.generate();
        tokenRepository.saveToken(object,newToken);
        return newToken;
    }

    public Auth authorize(TokenDTO tokenDTO) throws UnauthorizedException {


        Token token = tokenMapper.toToken(tokenDTO);

        try {
            return tokenRepository.findByToken(token);
        } catch (TokenNotFindException | TokenIsExpiredException e) {
            throw new UnauthorizedException(e.getMessage());
        }
    }


}
