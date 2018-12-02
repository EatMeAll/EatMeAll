package com.WildBirds.RepositoryJPA.infrastructure;

import com.WildBirds.RepositoryJPA.domain.model.Day;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.User;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryDay;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

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

    @Override
    public List<Day> getHistory(Instant fromDate, Instant toDate, Integer idUser) {


        //round to the day
        toDate = toDate.plus(1, ChronoUnit.DAYS);

        String query= "SELECT day FROM Day day " +
                "JOIN day.dayOwner dayOwner " +
                "WHERE dayOwner.idUser =:idUser " +
                "AND day.date >: fromDate " +
                "AND day.date <: toDate";


        return this.entityManager.createQuery(query,Day.class)
                .setParameter("idUser" ,idUser)
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getResultList();

    }


}
