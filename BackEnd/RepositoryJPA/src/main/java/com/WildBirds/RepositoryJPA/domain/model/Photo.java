package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
public class Photo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhoto;
    private File photo;
    private String filename;
    private String filetype;

    private String extension;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User photoOwner;

    public Photo() {}

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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public User getPhotoOwner() {
        return photoOwner;
    }

    public void setPhotoOwner(User photoOwner) {
        this.photoOwner = photoOwner;
        photoOwner.getMyPhotosSet().add(this);
    }
}
