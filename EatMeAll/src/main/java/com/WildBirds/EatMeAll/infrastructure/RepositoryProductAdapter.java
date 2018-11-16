package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.ports.RepositoryProduct;
import com.WildBirds.RepositoryJPA.domain.model.Product;

import javax.ejb.Stateless;

@Stateless
public class RepositoryProductAdapter implements RepositoryProduct {


    @Override
    public Product someAdditionalLogic() {
        return null;
    }
}
