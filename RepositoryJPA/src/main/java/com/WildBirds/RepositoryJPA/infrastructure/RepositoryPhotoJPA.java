package com.WildBirds.RepositoryJPA.infrastructure;

import com.WildBirds.RepositoryJPA.domain.model.Photo;
import com.WildBirds.RepositoryJPA.domain.model.User;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryPhoto;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryUser;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RepositoryPhotoJPA extends CrudEntityJpa<Photo> implements RepositoryPhoto {

    public RepositoryPhotoJPA() {
        super(Photo.class);
    }

}
