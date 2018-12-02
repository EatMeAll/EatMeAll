package com.WildBirds.RepositoryJPA.infrastructure;

import com.WildBirds.RepositoryJPA.domain.model.Step;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryStep;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.CrudEntityJpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RepositoryStepJPA extends CrudEntityJpa<Step> implements RepositoryStep {

    public RepositoryStepJPA() {
        super(Step.class);
    }

    @Override
    public Step someAdditionalLogic() {
        return null;
    }
}
