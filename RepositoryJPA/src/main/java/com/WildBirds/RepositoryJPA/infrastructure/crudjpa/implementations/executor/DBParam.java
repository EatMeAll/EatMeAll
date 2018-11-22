package com.WildBirds.RepositoryJPA.infrastructure.CrudJPA.implementations.executor;

public class DBParam<A1> {

    private A1 a1;

    public DBParam(A1 a1) {
        this.a1 = a1;
    }
    public<out> DBMethod<A1, out> out(out out){
        return new DBMethod<A1,out>(a1,out);
    }
}
