package com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.executor.methods;

import com.WildBirds.RepositoryJPA.application.RepositoryFacade;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface ExecuteMethod<a1,out> {


   out execute(a1 a1, RepositoryFacade em);
}
