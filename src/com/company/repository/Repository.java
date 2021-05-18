package com.company.repository;

import com.company.model.Player;
import com.company.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Repository <T>{
    private List<T> list = new ArrayList<>();
    private ObjectMapper mapper;
    public void add(T t){
        retrieveData();
       if(t instanceof User)
       {
           User user =(User) t;

       }
       else{

          switch (t.getClass().getSimpleName().toString())
          {
              case "Player":
              {

              }
          }
       }

    }
    public void retrieveData()
    {
        File file = new File("src/Users");
        T t = null;
        if(t instanceof User) {
            if (file.list().length != 0) {
                File[] files = file.listFiles();
                for (File file1 :files) {
                    try {
                        this.list.add(mapper.readValue(file1, new TypeReference<T>() {
                            @Override
                            public Type getType() {
                                return super.getType();
                            }
                        }));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                try {
                    this.mapper.readValue(new File(t.getClass().getSimpleName()+".json"),t.getClass().componentType());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


        }
}
