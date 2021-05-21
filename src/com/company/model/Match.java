package com.company.model;

import java.time.LocalDate;
import java.util.*;

public class Match {
    private int id;
    private String nameLocal;
    private String nameVisitor;
    private HashSet<Player> localTeam;
    private HashSet<Player> visitorTeam;
    private LocalDate date;

    public Match(int id, String nameLocal, String nameVisitor) {
        this.id = id;
        this.nameLocal = nameLocal;
        this.nameVisitor = nameVisitor;

    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", nameLocal='" + nameLocal + '\'' +
                ", nameVisitor='" + nameVisitor + '\'' +
                ", localTeam=" + localTeam +
                ", visitorTeam=" + visitorTeam +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLocal() {
        return nameLocal;
    }

    public void setNameLocal(String nameLocal) {
        this.nameLocal = nameLocal;
    }

    public String getNameVisitor() {
        return nameVisitor;
    }

    public void setNameVisitor(String nameVisitor) {
        this.nameVisitor = nameVisitor;
    }

    public HashSet<Player> getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(HashSet<Player> localTeam) {
        this.localTeam = localTeam;
    }

    public HashSet<Player> getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(HashSet<Player> visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
