package com.WildBirds.EatMeAll.infrastructure.services;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class Mapper {

    private MapperFactory mapperFactory;


    public Mapper() {
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public MapperFacade getFacade(){
        return this.mapperFactory.getMapperFacade();
    }

    public void register(Class<?> source ,Class<?> target){
        this.mapperFactory.classMap(
                source, target)
                .byDefault()
                .register();
    }
}