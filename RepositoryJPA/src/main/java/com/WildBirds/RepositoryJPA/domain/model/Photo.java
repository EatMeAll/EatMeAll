package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;

import java.io.File;
import java.util.Objects;

public class Photo extends BaseEntity {

    private Integer idPhoto;
    private File photo;


    public Photo() {
    }

    public Integer getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(Integer idPhoto) {
        this.idPhoto = idPhoto;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo1 = (Photo) o;
        return Objects.equals(idPhoto, photo1.idPhoto) &&
                Objects.equals(photo, photo1.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPhoto, photo);
    }
}
