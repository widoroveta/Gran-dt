package com.company.model;

import com.company.interfaz.Tactic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyTeam implements Tactic {
    private final List<Player> players = new ArrayList<>();
    private String teamName;
    private int money;
    private transient int score;

    public MyTeam() {
        this.score = 0;
        this.money = 35000;
    }

    public boolean change(Player player1, Player player2) {
        if (players.contains(player1)) {
            players.remove(player1);
            boolean b = players.add(player2);
            if (!b) {
                players.add(player1);
                return false;
            } else {
                return true;
            }
        } else return false;
    }

    public boolean remove(Player player) {
        if (!players.isEmpty()) {
            if (players.contains(player)) {
                return players.remove(player);
            }
        }
        return false;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money -= money;
    }


    public boolean addPlayer(Player player) {

        if (isCanAdd(player)) {

            this.setMoney(player.getPrice());
           return this.players.add(player);
        } else {
            return false;
        }

    }

    public boolean isCanAdd(Player player) {
        if (player.getPrice() < this.money) {
            if (players.size() >= 11) {
                return false;
            } else {
                if (players.size() == 0) return true;
                int i = 0;
                for (Player p : players) {
                    boolean b = p.getClass().equals(player.getClass());
                    if (b) {
                        i++;
                    }

                }
                if (player instanceof Goalkeeper) return i > 1 ? false : true;
                if (player instanceof Defender) return i > 3 ? false : true;
                if (player instanceof Midfielder) return i > 3 ? false : true;
                if (player instanceof Forward) return i > 1 ? false : true;
            }
        } else {
            return false;

        }
        return false;

    }

    @Override
    public String toString() {
        return "MyTeam{" +
                "teamName='" + teamName + '\'' +
                tactic() +
                ", money=" + money +
                ", score=" + score +
                '}';
    }

    public String tactic() {
        String result = "";
        Collections.sort(players);
        for (Player p : this.players) {
            result += p.toString();
        }
        return result;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
