package com.company.repository;

import com.company.interfaz.Repository;
import com.company.model.Club;
import com.company.model.Player;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClubRepository implements Repository<Player> {
List<Club> clubs = new ArrayList<>();
ObjectMapper mapper =new ObjectMapper();
@Override
    public void add(Player player) {

    }

    @Override
    public void retrieveData() {
        try {
            mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            this.clubs =mapper.readValue(new File("clubs.json"), new TypeReference<ArrayList<Club>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Club> getClubs() {
    retrieveData();
        return clubs;
    }

    @Override
    public List<Player> getAll() {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

}
