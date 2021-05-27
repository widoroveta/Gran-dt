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
    ObjectMapper mapper=new ObjectMapper();
    private final static File FILE=new File("User.json");
    @Override
    public void add(User user) {
        retrieveData();
        users.add(user);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(FILE,users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void retrieveData() {
        try {
            if(FILE.exists()) {
                users = mapper.readValue(FILE, new TypeReference<List<User>>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                });}
            else {
                this.users.add(new User("admin", "admin", "", "", "", 0));
                mapper.writerWithDefaultPrettyPrinter().writeValue(FILE, users);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        try {
            this.users=mapper.readValue(FILE, new TypeReference<List<User>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.users;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
}
