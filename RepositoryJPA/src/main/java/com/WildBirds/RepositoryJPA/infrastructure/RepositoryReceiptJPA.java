package com.WildBirds.RepositoryJPA.infrastructure;

import com.WildBirds.RepositoryJPA.domain.model.Receipt;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryReceipt;
import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.implementations.CrudEntityJpa;
import com.WildBirds.RepositoryJPA.infrastructure.crudjpa.interfaces.CrudEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RepositoryReceiptJPA extends CrudEntityJpa<Receipt> implements RepositoryReceipt {

    public RepositoryReceiptJPA() {
        super(Receipt.class);
    }

    @Override
    public Receipt someAdditionalLogic() {
        return null;
    }
}
