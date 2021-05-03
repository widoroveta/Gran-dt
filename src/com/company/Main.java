package com.company;

import com.company.Request.AllSportsApi;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) {

       AllSportsApi api = new AllSportsApi();
        api.toUpdate();

    }
}

