package com.authenticateService.domain.ports;


import com.authenticateService.appliacation.model.Token;
import com.authenticateService.infrastructure.MemoryTockenRepository.exceptions.TokenIsExpiredException;
import com.authenticateService.infrastructure.MemoryTockenRepository.exceptions.TokenNotFindException;

public interface TokenRepository<Auth extends Comparable<Auth>> {

    public Token getToken(Auth object);

    public Auth getAuth(Token token);

    public Auth findByToken(Token token) throws TokenNotFindException, TokenIsExpiredException;

    void saveToken(Auth object, Token token);

    void deleteToken(Auth object);

    void deleteToken(Token token);


}
