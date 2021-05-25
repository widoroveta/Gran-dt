package com.company.repository;

import com.company.interfaz.Repository;
import com.company.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<User> {
    List<User> users =new ArrayList<>();
    ObjectMapper mapper;
    @Override
    public void add(User user) {
        retrieveData();
        users.add(user);
    }

    @Override
    public void retrieveData() {
        try {
            users=mapper.readValue(new File("User.json"), new TypeReference<List<User>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            }) ;
           if(users.isEmpty())
           {
               add(new User("admin","admin"," "," "," ",0));
               mapper.writerWithDefaultPrettyPrinter().writeValue(new File("User.json"),users);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
