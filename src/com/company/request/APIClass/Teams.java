package com.company.request.APIClass;

import java.util.Arrays;

public class Teams {
    private int team_key;
    private String team_name;
    private String team_logo;
    private Players[] players;
    private Coaches[] coaches;

    public int getTeam_key() {
        return team_key;
    }

    public void setTeam_key(int team_key) {
        this.team_key = team_key;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_logo() {
        return team_logo;
    }

    public void setTeam_logo(String team_logo) {
        this.team_logo = team_logo;
    }

    public Players[] getPlayers() {
        return players;
    }

    public void setPlayers(Players[] players) {
        this.players = players;
    }

    public Coaches[] getCoaches() {
        return coaches;
    }

    public void setCoaches(Coaches[] coaches) {
        this.coaches = coaches;
    }

    public Teams(int team_key, String team_name, String team_logo, Players[] players, Coaches[] coaches) {
        this.team_key = team_key;
        this.team_name = team_name;
        this.team_logo = team_logo;
        this.players = players;
        this.coaches = coaches;
    }

    public Teams() {
    }

    @Override
    public String toString() {
        return "Teams{" +
                "team_key=" + team_key +
                ", team_name='" + team_name + '\'' +
                ", team_logo='" + team_logo + '\'' +
                ", players=" + Arrays.toString(players) +
                ", coaches=" + Arrays.toString(coaches) +
                '}';
    }
}
