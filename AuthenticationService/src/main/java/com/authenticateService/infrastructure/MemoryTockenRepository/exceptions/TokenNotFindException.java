package com.authenticateService.infrastructure.MemoryTockenRepository.exceptions;

public class TokenNotFindException extends RuntimeException {
    public TokenNotFindException(String message) {
        super(message);
    }
}
