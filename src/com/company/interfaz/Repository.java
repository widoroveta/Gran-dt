package com.company.interfaz;

import java.util.List;

public interface Repository <T>{
     void add(T t );
    void retrieveData();
    List <T> getAll();
    boolean contains(Object o);
}
