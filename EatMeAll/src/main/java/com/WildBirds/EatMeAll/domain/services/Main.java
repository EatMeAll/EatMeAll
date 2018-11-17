package com.WildBirds.EatMeAll.domain.services;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Main implements MainRemote, MainLocal {

    public void Init(){
        System.out.println("Init Main");
    }


    @Override
    public void HelloWorld() {
        System.out.println("Hello world");
    }


    @PostConstruct
    public void init(){
        System.out.println();
        System.out.println();
        System.out.println("init ");
        System.out.println();
        System.out.println();

    }
}
