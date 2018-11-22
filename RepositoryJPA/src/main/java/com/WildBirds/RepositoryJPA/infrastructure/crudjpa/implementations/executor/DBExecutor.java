package com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.executor;

import com.WildBirds.RepositoryJPA.domain.model.Meal;

import java.util.ArrayList;

public class DBExecutor {
    public <A1> DBParam<A1> arguments(A1 a1){
        return new DBParam<A1>(a1);
    }


    public static void main(String[] args) {

        DBExecutor dbExecutor = new DBExecutor();




        dbExecutor.arguments(new Meal()).out("").execute((meal, repo) -> {


            repo.MEAL().insert(meal);
            repo.PRODUCT().insert(meal.ge)


            return "";
        });
    }
}
