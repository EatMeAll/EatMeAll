package com.authenticateService.infrastructure.MemoryTockenRepository.exceptions;

public class TokenIsExpiredException extends RuntimeException {
    public TokenIsExpiredException(String message) {
        super(message);
    }
}
