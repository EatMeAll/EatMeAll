package com.WildBirds.RepositoryJPA.infrastructure;

import com.WildBirds.RepositoryJPA.domain.model.Day;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryDay;
import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RepositoryDayJPA extends CrudEntityJpa<Day> implements RepositoryDay {

    public RepositoryDayJPA() {
        super(Day.class);
    }

    @Override
    public Day someAdditionalLogic() {
        return null;
    }
}