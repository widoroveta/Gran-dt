package com.company;

import com.company.Views.AdminMenu;
import com.company.Views.MainMenu;
import com.company.repository.ClubRepository;
import com.company.repository.FixtureRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
     AdminMenu adminMenu = new AdminMenu();
        adminMenu.menu();
       /* SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
*/
    }

}


