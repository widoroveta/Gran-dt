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
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FixtureRepository implements Repository<Match> {
    private Fixture fixture ;
    private ObjectMapper mapper= new ObjectMapper();;
    File fileFixture=new File("Fixture.json");
    @Override
    public void add(Match m) {
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
public void saveFixture(Fixture fixture){
    try {
        mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        this.mapper.writerWithDefaultPrettyPrinter().writeValue(fileFixture,fixture);
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
        try {
            mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
            mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            this.fixture=this.mapper.readValue(fileFixture, new TypeReference<Fixture>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.fixture.getFixture();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
}
