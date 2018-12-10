package com.authenticateService.infrastructure.MemoryTockenRepository;


import com.authenticateService.appliacation.model.Token;
import com.authenticateService.domain.ports.TokenRepository;
import com.authenticateService.infrastructure.MemoryTockenRepository.exceptions.TokenIsExpiredException;
import com.authenticateService.infrastructure.MemoryTockenRepository.exceptions.TokenNotFindException;

import java.util.*;

public class MemoryTokenRepository<Auth extends Comparable<Auth>> implements TokenRepository<Auth> {


    Map<Token, Auth> tokensMap = new TreeMap<>();
    Map<Auth, Token> authMap = new TreeMap<>();

    @Override
    public Token getToken(Auth object){
        return authMap.get(object);
    }

    @Override
    public Auth getAuth(Token token) {
        return tokensMap.get(token);
    }

    @Override
    public Auth findByToken(Token token) throws TokenNotFindException, TokenIsExpiredException {
        if (tokensMap.containsKey(token)) {

            Auth auth = tokensMap.get(token);
            Token tokenMap = authMap.get(auth);

            if(tokenMap.isExpired()){
                this.deleteToken(tokenMap);
                throw new TokenIsExpiredException("Token is Expired");
            }
            tokenMap.renew();
            return auth;
        } else {
            throw new TokenNotFindException("Token not found in Repository");
        }
    }


    @Override
    public void saveToken(Auth object, Token token) {
        this.tokensMap.put(token,object);
        this.authMap.put(object, token);
    }

    @Override
    public synchronized void deleteToken(Auth object) {
        Token token = this.authMap.remove(object);
        this.tokensMap.remove(token);
    }

    @Override
    public void deleteToken(Token token) {
        Auth auth = this.tokensMap.remove(token);
        this.authMap.remove(auth);
    }

    public void clearExpiredTokens() {

        Set<Token> tokens = this.tokensMap.keySet();
        List<Token> tokenToDelete = new LinkedList<>();

        for (Token token : tokens) {
            if (token.isExpired()) {
                tokenToDelete.add(token);
            }
        }

        for (Token token : tokenToDelete) {
            this.deleteToken(token);
        }
    }
}
