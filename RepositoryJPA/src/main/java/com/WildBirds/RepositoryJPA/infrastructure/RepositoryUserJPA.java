package com.WildBirds.RepositoryJPA.infrastructure;

import com.WildBirds.RepositoryJPA.domain.model.User;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryUser;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.CrudEntityJpa;

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

    @Override
    public User getUserByNickPass(String nick, String password) {

        String query = ("SELECT user FROM User user " +
                "WHERE user.nick = :nick AND " +
                "user.password=: password");

        return this.entityManager.createQuery(query,User.class)
                .setParameter("nick", nick)
                .setParameter("password", password)
                .getSingleResult();

    }
}
