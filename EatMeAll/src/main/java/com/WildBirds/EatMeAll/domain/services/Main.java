package com.WildBirds.EatMeAll.domain.services;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local(MainLocal.class)
@Remote(MainRemote.class)
public class Main implements MainRemote, MainLocal {

    public void Init(){
        System.out.println("Init Main");
    }


    @Override
    public void HelloWorld() {
        System.out.println("Hello world");
    }
}
