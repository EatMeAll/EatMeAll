package com.WildBirds.RepositoryJPA.domain.ports;

import com.WildBirds.RepositoryJPA.domain.model.Receipt;
import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.interfaces.CrudEntity;

public interface RepositoryReceipt extends CrudEntity<Receipt> {

    Receipt someAdditionalLogic();
}
