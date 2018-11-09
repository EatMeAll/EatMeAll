module com.WildBirds.RepositoryJPA {
    exports com.WildBirds.RepositoryJPA.application;
    exports com.WildBirds.RepositoryJPA.domain.model;

    requires javaee.api;
    requires com.WildBirds.CrudJPA;
}