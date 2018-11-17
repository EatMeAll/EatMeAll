package com.WildBirds.RepositoryJPA.infrastructure;

import com.WildBirds.RepositoryJPA.domain.model.User;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryUser;
import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RepositoryUserJPA extends CrudEntityJpa<User> implements RepositoryUser {

    public RepositoryUserJPA() {
        super(User.class);
    }

    @Override
    public User someAdditionalLogic() {
        return null;
    }
}
