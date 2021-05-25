package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class MyTeam {
    private String teamName;
    private List<Player> players = new ArrayList<>();
    private transient  int score;

    public List<Player> getPlayers() {
        return players;
    }
}
