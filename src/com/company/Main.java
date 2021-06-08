package com.company;

import com.company.Views.AdminMenu;
import com.company.Views.MainMenu;
import com.company.enums.Dates;
import com.company.model.*;
import com.company.repository.FixtureRepository;
import com.company.repository.ResultsRepository;
import com.company.repository.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MainMenu menu=new MainMenu();
        menu.menuMain();
    }
}