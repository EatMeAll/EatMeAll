module com.WildBirds.RepositoryJPA {
    exports com.WildBirds.RepositoryJPA.application;
    exports com.WildBirds.RepositoryJPA.domain.ports;
    exports com.WildBirds.RepositoryJPA.domain.model;
    exports com.WildBirds.RepositoryJPA.domain.model.enums;

    requires javaee.api;
    requires lombok;

    requires java.naming;
}