package com.WildBirds.RepositoryJPA.domain.model;

import java.io.File;

public class Photo {

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
}
