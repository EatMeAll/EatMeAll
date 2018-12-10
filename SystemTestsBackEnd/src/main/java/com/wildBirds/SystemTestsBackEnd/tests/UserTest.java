package com.wildBirds.SystemTestsBackEnd.tests;


import com.wildBirds.SystemTestsBackEnd.domain.model.enums.UserType;
import com.wildBirds.SystemTestsBackEnd.domain.model.full_.UserDTO;
import com.wildBirds.SystemTestsBackEnd.domain.model.new_.UserNewDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

public class UserTest {

    RestTemplate restTemplate = new RestTemplate();


    @Value("${eatmeall.server.address.url}")
    private String serverAddress = "http://localhost:8080/app";

    private String subDomain = "/users/";




    @Test
    public void shouldGetUserById() {
        //given
        final Integer userId = 1;
        UserDTO expectedUser = new UserDTO();
        expectedUser.setIdUser(1);
        //when

        ResponseEntity<UserDTO> userDTOResponse = restTemplate.getForEntity(serverAddress + subDomain + userId, UserDTO.class);
        //then
        UserDTO userDTO = userDTOResponse.getBody();

        Assert.assertEquals(expectedUser.getIdUser(), userDTO.getIdUser());
        Assert.assertNotNull(userDTO.getEmail());
        Assert.assertNotNull(userDTO.getNick());
        Assert.assertNotNull(userDTO.getUserType());
    }

    @Test
    public void shouldRegisterUserAndLoginFinallyRemoveUser() {
        //given
        UserNewDTO expectedUser = new UserNewDTO();
        expectedUser.setEmail("someEmail@gmail.com");
        expectedUser.setNick("someNick");
        expectedUser.setUserType(UserType.CASUAL);
        expectedUser.setPassword("abcde");
        //when
        ResponseEntity<UserDTO> newDTOResponse
                = restTemplate.postForEntity(serverAddress + subDomain, expectedUser, UserDTO.class);
        Integer registeredUserId = newDTOResponse.getBody().getIdUser();

        //then
        Assert.assertNotNull(registeredUserId);

        // try to login regstered user

        //given
        String nick = expectedUser.getNick();
        String password = expectedUser.getPassword();
        Integer expectedUserId = registeredUserId;

        UserNewDTO loginUser = new UserNewDTO();
        loginUser.setNick(nick);
        loginUser.setPassword(password);
        //when
        ResponseEntity<UserDTO> loginedUserEntity = restTemplate.postForEntity(serverAddress + "/login", loginUser, UserDTO.class);
        //then
        UserDTO userBeforeLogging = loginedUserEntity.getBody();

        Assert.assertEquals(nick, userBeforeLogging.getNick());
        Assert.assertEquals(expectedUserId, userBeforeLogging.getIdUser());


        //given
        Integer idUserToRemove = registeredUserId;
        //when
        restTemplate.delete(serverAddress + subDomain + idUserToRemove);
        try {
            //then
            ResponseEntity<UserDTO> forEntity = restTemplate.getForEntity(serverAddress + subDomain + idUserToRemove, UserDTO.class);
            forEntity.getBody();
            Assert.assertTrue(false);
        } catch (RestClientException e) {
            //user not found
            Assert.assertTrue(true);
        }

    }


}
