package com.company.repository;

import com.company.interfaz.Repository;
import com.company.model.Result;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ResultsRepository implements Repository<Result> {
   List<Result> results =new ArrayList<>();
   File fileResult =new File("Result.json");
   ObjectMapper mapper=new ObjectMapper();
   
   
   @Override
    public void add(Result result) {
	//retrieveData();
	   results.add(result);
	   try {
		mapper.writerWithDefaultPrettyPrinter().writeValue(this.fileResult, results);
	} catch (JsonGenerationException e) {
		e.printStackTrace();
	} catch (JsonMappingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
    }

    @Override
    public void retrieveData() {
    	try {
    this.results=this.mapper.readValue(this.fileResult, new TypeReference<ArrayList<Result>>(){
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
    public List<Result> getAll() {
        retrieveData();
    	return results;
    }

    @Override
    public boolean contains(Result result) {
        return results.contains(result);
    }

    @Override
    public boolean remove(Result result) {
        if (contains(result)) {
            this.remove(result);
            return true;
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
            this.mapper.writerWithDefaultPrettyPrinter().writeValue(fileResult, results);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
