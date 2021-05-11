package com.company;

import com.company.Class.Player;
import com.company.Class.User;
import com.company.Repository.Repository;
import com.company.Request.AllSportsApi;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) {

      /* AllSportsApi api = new AllSportsApi();
        api.toUpdate();
*/
        Repository r= new Repository();
    /*    r.add(new User("CARLOS","CARLITOS21","DASS","rodriguez","messi@gmail.com",3212312));
r.add(new Player());*/
      //  r.retrieveData();
    System.out.println( goalsSimulation(0.5));

    }
    private static int goalsSimulation (double probabilitie){
      byte goals=0;

        for(byte i =0 ;i<90 ;i++)
        {
            if(i==(int)90*probabilitie) {
         goals++;
            }
            else{

            }

        }
        return  (int )goals;
    }
}

