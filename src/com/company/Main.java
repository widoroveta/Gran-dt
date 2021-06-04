package com.company;

import com.company.Views.AdminMenu;
import com.company.Views.UserMenu;
import com.company.model.Club;
import com.company.model.Fixture;
import com.company.model.MyTeam;
import com.company.model.User;
import com.company.repository.ClubRepository;
import com.company.repository.FixtureRepository;
import com.company.request.AllSportsApi;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserMenu uMenu=new UserMenu(new User("Pablo","123", "Pedro","Morales","pablo@mail.com",4751111));
        uMenu.menu();
    }

}


