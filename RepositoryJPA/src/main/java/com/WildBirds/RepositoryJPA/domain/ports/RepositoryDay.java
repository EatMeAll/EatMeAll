package com.WildBirds.RepositoryJPA.domain.ports;

import com.WildBirds.RepositoryJPA.domain.model.Day;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

import java.util.List;

public interface RepositoryDay extends CrudEntity<Day> {

    Day someAdditionalLogic();

}
