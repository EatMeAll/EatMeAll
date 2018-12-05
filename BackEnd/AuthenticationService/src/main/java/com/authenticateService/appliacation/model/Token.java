package com.authenticateService.appliacation.model;

import com.authenticateService.api.TokenDTO;

import java.time.Instant;
import java.util.Objects;

public class Token implements Comparable<Token> {

    private String value;
    private Instant dateOfCreated;
    private Instant dateOfExpiry;
    private Integer TTL;

    public Token() {}

    public Token(String value){
        this.value = value;
    }

    public Token(String value, Integer TTL_IN_MINUTES) {
        this.value = value;
        this.dateOfCreated = Instant.now();
        this.TTL = TTL_IN_MINUTES;
        this.renew();
    }

    public void renew(){
        this.dateOfExpiry = Instant.now().plusNanos(1_000_000_000 * 60 * this.TTL);
    }

    public boolean isExpired(){
        return this.getDateOfExpire().isAfter(Instant.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(value, token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String getValue() {
        return value;
    }

    public Instant getDateOfCreated() {
        return dateOfCreated;
    }


    public Instant getDateOfExpire() {
        return dateOfExpiry;
    }


    @Override
    public int compareTo(Token o) {
        return this.value.compareTo(o.value);
    }
}
