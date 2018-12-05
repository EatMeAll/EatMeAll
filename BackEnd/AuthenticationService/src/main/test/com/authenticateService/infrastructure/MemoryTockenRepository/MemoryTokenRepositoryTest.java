package com.authenticateService.infrastructure.MemoryTockenRepository;

import com.authenticateService.appliacation.model.Token;
import com.authenticateService.infrastructure.MemoryTockenRepository.exceptions.TokenIsExpiredException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MemoryTokenRepositoryTest {


    private MemoryTokenRepository<String> memoryTokenRepository;

    @Before
    public void init(){
        this.memoryTokenRepository = new MemoryTokenRepository<>();
    }

    @Test
    public void shouldGetAuthByToken() {

        //Given
        Token token = new Token("TOKEN", 1);

        //When
        memoryTokenRepository.saveToken("USER",token);
        String authResult = memoryTokenRepository.getAuth(token);

        //Then
        Assert.assertEquals("USER",authResult);
    }

    @Test
    public void shouldFindAuthByToken() {

        //Given
        Token token = new Token("TOKEN", 1);

        //When
        memoryTokenRepository.saveToken("USER",token);
        String authResult = memoryTokenRepository.findByToken(token);

        //Then
        Assert.assertEquals("USER",authResult);
    }


    @Test
    public void shouldThrowExceptionTokenIsExpiredByToken() {

        //Given
        Token token = new Token("TOKEN", -1);

        //When
        memoryTokenRepository.saveToken("USER",token);
        try {

            String authResult = memoryTokenRepository.findByToken(token);
            Assert.fail("Should throw exception");
        }catch (TokenIsExpiredException e){
            //Then
            Assert.assertTrue(true);
        }



    }
}
