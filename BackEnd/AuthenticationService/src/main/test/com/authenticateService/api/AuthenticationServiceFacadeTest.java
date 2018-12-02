package com.authenticateService.api;

import com.authenticateService.appliacation.exceptions.Unauthorized;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuthenticationServiceFacadeTest {

    private AuthenticationServiceFacade<String> authenticationServiceFacade;


    @Before
    public void before() {
        authenticationServiceFacade = AuthenticationServiceFacade.configure();
    }

    @Test
    public void shouldAuthorized() {

        //Given
        TokenDTO user = authenticationServiceFacade.assignToken("USER");
        //When
        String authorize = null;
        try {
            authorize = authenticationServiceFacade.authorize(user);

        } catch (Unauthorized unauthorized) {
            fail("Not authorized");
        }
        //Then
        System.out.println(user.getValue()+" <- Token");
        assertEquals("USER",authorize);


    }


    @Test
    public void shouldNotAuthorizedDueToBadToken() {

        //Given
        TokenDTO user = authenticationServiceFacade.assignToken("USER");
        TokenDTO invalidToken = new TokenDTO("TEST");
        //When
        String authorize = null;
        try {
            authorize = authenticationServiceFacade.authorize(invalidToken);
            fail("authorized");


        } catch (Unauthorized unauthorized) {
            //Then
            assertTrue(true);
        }


    }

    @Test
    public void shouldNotAuthorized() {

        //Given
        TokenDTO invalidToken = new TokenDTO("TEST");
        //When
        String authorize = null;
        try {
            authorize = authenticationServiceFacade.authorize(invalidToken);
            fail("authorized");

        } catch (Unauthorized unauthorized) {
            //Then
            assertTrue(true);
        }


    }

}