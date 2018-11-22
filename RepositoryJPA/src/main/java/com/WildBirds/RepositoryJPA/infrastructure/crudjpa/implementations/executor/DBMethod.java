package com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.executor;

import com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.executor.methods.ExecuteMethod;

public class DBMethod<A1, out> {

    private A1 h1;
    private out out;

    public DBMethod(A1 h1, out out) {

        this.h1 = h1;
        this.out = out;
    }

    public out execute(ExecuteMethod<A1,out> method){
        return method.execute(h1);
    }
}
