package com.company;

import com.company.Class.Club;
import com.company.Class.Team;
import com.company.Request.APIClass.Players;
import com.company.Request.APIClass.Teams;
import com.company.Request.AllSportsApi;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.AbstractPreferences;

public class Main {

    public static void main(String[] args) {

       AllSportsApi api = new AllSportsApi();
        api.toUpdate();
    }
}

