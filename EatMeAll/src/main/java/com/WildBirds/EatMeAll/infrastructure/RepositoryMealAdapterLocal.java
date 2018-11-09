package com.WildBirds.EatMeAll.infrastructure;

import com.WildBirds.EatMeAll.domain.model.Meal;
import com.WildBirds.EatMeAll.domain.ports.RepositoryCRUD;
import com.WildBirds.EatMeAll.domain.ports.RepositoryMeal;

import javax.ejb.Local;
@Local
public interface RepositoryMealAdapterLocal extends RepositoryCRUD<Meal>,RepositoryMeal{
}
