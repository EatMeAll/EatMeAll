package com.WildBirds.RepositoryJPA.infrastructure;

import com.WildBirds.RepositoryJPA.domain.ports.RepositoryCrud;
import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.implementations.CrudJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RepositoryCrudJPA extends CrudJpa implements RepositoryCrud {}
