package com.company.repository;

import com.company.interfaz.Repository;
import com.company.model.Fixture;
import com.company.model.Match;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FixtureRepository implements Repository<Match> {
    private  Fixture fixture;
    File fileFixture = new File("Fixture.json");
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void add(Match m) {
        this.retrieveData();
        fixture.getFixture().add(m);
        System.out.println(fixture);
        try {

            this.mapper.writerWithDefaultPrettyPrinter().writeValue(fileFixture, fixture.getFixture());
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    public boolean save() {

            try {
                mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
                mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
                this.mapper.writerWithDefaultPrettyPrinter().writeValue(fileFixture, fixture);
                return true;
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();


        }

        return false;

    }

    @Override
    public void retrieveData() {


        try {
            mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            fixture = this.mapper.readValue(fileFixture, new TypeReference<Fixture>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<Match> getAll() {
        retrieveData();
        return fixture.getFixture();

    }

    @Override
    public boolean contains(Match match) {
        return fixture.getFixture().contains(match);

    }

    @Override
    public boolean remove(Match match) {
        retrieveData();
        if (contains(match)) {
            fixture.getFixture().remove(match);
            save();
            return true;
        } else {
            return false;
        }
    }

    public void setFixture(Fixture fixture) {
      this.fixture = fixture;
    }
}
