package com.company.repository;

import com.company.interfaz.Repository;
import com.company.model.Club;
import com.company.model.Player;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClubRepository implements Repository<Player> {
    private static List<Club> clubs = new ArrayList<>();
    private final ObjectMapper mapper = new ObjectMapper();
    private final File fileClub = new File("clubs.json");

    @Override
    public void add(Player player) {

    }

    @Override
    public void retrieveData() {

        try {
            mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            clubs = mapper.readValue(fileClub, new TypeReference<ArrayList<Club>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            }).subList(0, 19);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public List<Club> getClubs() {
        retrieveData();
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        ClubRepository.clubs = clubs;
    }

    @Override
    public List<Player> getAll() {
        retrieveData();
        List<Player> players = new ArrayList<>();
        for (Club c :
                clubs) {
            for (Player p :
                    c.getPlayerList()) {
                players.add(p);
            }
        }
        return players;
    }

    @Override
    public boolean contains(Player player) {

        for (Club club :
                clubs) {
            if (club.getPlayerList().contains(player))
                return true;
        }
        return false;
    }


    @Override
    public boolean remove(Player player) {
        if (contains(player)) {
            for (Club club :
                    this.getClubs()) {
                if (club.getPlayerList().contains(player)) {
                    club.getPlayerList().remove(player);
                    return true;
                }
            }


        }
        return false;

    }

    @Override
    public boolean save() {


        try {
            mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
            this.mapper.writerWithDefaultPrettyPrinter().writeValue(fileClub, clubs);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


    }


}
