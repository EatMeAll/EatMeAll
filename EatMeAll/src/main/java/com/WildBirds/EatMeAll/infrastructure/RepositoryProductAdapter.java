package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.ports.RepositoryProduct;
import com.WildBirds.RepositoryJPA.application.RepositoryProductFacade;
import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.crudjpa.appliaction.interfaces.Crud;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RepositoryProductAdapter implements RepositoryProduct {


    @Override
    public Product someAdditionalLogic() {
        return null;
    }
}
