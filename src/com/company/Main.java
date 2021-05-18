package com.company;

import com.company.model.Player;
import com.company.repository.Repository;
import com.company.request.AllSportsApi;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

       AllSportsApi api = new AllSportsApi();
        try {
            api.toUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }


            Repository r= new Repository();
    r.add(new Player ("carlos",2,"carlos"));
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

