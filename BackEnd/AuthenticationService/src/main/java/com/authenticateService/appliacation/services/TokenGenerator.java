package com.authenticateService.appliacation.services;



import com.authenticateService.appliacation.model.Token;

import java.util.Random;


public class TokenGenerator {


    public static final int TTL_IN_MINUTES = 5;

    public Token generate() {
        StringBuilder rawToken = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 36; i++) {
            int number = random.nextInt(128);
            rawToken.append((char) number);
        }

        return new Token(rawToken.toString(),TTL_IN_MINUTES);


    }
}


