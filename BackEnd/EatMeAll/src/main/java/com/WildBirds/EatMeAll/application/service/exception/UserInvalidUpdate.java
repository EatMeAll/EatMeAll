package com.WildBirds.EatMeAll.application.service.exception;

import javax.ejb.EJBException;

public class UserInvalidUpdate extends EJBException {
    public UserInvalidUpdate(String message) {
        super(message);
    }
}
