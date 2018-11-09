module com.WildBirds.RepositoryJPA {
    exports com.WildBirds.ReposiotryJPA.application;
    exports com.WildBirds.ReposiotryJPA.domain.model;

    requires javaee.api;
    requires com.WildBirds.CrudJPA;
}