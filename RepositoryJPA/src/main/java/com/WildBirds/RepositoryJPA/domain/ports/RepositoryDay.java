package com.WildBirds.RepositoryJPA.domain.ports;

import com.WildBirds.RepositoryJPA.domain.model.Day;
import com.WildBirds.RepositoryJPA.domain.model.User;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

import java.time.Instant;
import java.util.List;

public interface RepositoryDay extends CrudEntity<Day> {

    Day someAdditionalLogic();

    List<Day> getHistory(Instant fromDate, Instant toDate, Integer idUser);
}

