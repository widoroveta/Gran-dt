package com.company.repository;

import com.company.interfaz.Repository;
import com.company.model.User;

import java.util.List;

public class UserRepository implements Repository<User> {
    @Override
    public void add(User user) {

    }

    @Override
    public void retrieveData() {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
}
