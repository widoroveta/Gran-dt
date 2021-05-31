package com.company.repository;

import com.company.interfaz.Repository;
import com.company.model.Result;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ResultsRepository implements Repository<Result> {
   List<Result> results =new ArrayList<>();
   File fileResult =new File("Result.json");
   @Override
    public void add(Result result) {

    }

    @Override
    public void retrieveData() {

    }

    @Override
    public List<Result> getAll() {
        return null;
    }

    @Override
    public boolean contains(Result result) {
        return false;
    }

    @Override
    public boolean remove(Result result) {
        return false;
    }

    @Override
    public boolean save() {
        return false;
    }
}
