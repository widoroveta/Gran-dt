package com.company.repository;

import com.company.interfaz.Repository;
import com.company.model.Fixture;
import com.company.model.Match;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FixtureRepository implements Repository<Match> {
    private Fixture fixture ;
    private ObjectMapper mapper;
    File fileFixture=new File("Fixture.json");
    @Override
    public void add(Match m) {
        mapper = new ObjectMapper();
        this.retrieveData();
        this.fixture.getFixture().add(m);
        System.out.println(this.fixture);
        try {

           this.mapper.writerWithDefaultPrettyPrinter().writeValue(fileFixture,this.fixture.getFixture());
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void retrieveData() {

        if (fileFixture.exists()){

        }
    }

    @Override
    public List<Match> getAll() {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
}
