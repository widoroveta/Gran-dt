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
    private static Fixture fixture ;
    private ObjectMapper mapper= new ObjectMapper();
    File fileFixture=new File("Fixture.json");
    @Override
    public void add(Match m) {
        this.retrieveData();
        this.fixture.getFixture().add(m);
        System.out.println(this.fixture);
        try {

           this.mapper.writerWithDefaultPrettyPrinter().writeValue(fileFixture,this.fixture.getFixture());
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

    }
public boolean save(){
    if (fileFixture.exists() && fileFixture.canWrite()) {
        try {
            mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
            this.mapper.writerWithDefaultPrettyPrinter().writeValue(fileFixture, this.fixture);
            return true;
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();

        }
    }

        return false;

}
    @Override
    public void retrieveData() {

        if (fileFixture.exists() ) {
            try {
                mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
                mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
                mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                this.fixture = this.mapper.readValue(fileFixture, new TypeReference<Fixture>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Match> getAll() {
            retrieveData();
            return this.fixture.getFixture();

    }
    @Override
    public boolean contains(Match match) {
        return  this.fixture.getFixture().contains(match);

    }

    @Override
    public boolean remove(Match match) {
      retrieveData();
        if(contains(match))
      {
          this.fixture.getFixture().remove(match);
          save();
          return true;
      }
     else {
         return false;
      }
    }

    public void setFixture(Fixture fixture) {
        FixtureRepository.fixture = fixture;
    }
}
