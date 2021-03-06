package com.WildBirds.RepositoryJPA.domain.ports;

import com.WildBirds.RepositoryJPA.domain.model.Step;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

public interface RepositoryStep extends CrudEntity<Step> {
    Step someAdditionalLogic();
}
