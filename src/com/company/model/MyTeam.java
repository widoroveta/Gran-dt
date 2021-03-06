package com.company.model;

import com.company.interfaz.Tactic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyTeam implements Tactic {
    private final List<Player> players = new ArrayList<>();
    private String teamName;
    private int money;
    private int score;

    public MyTeam() {
    }

    public void change(Player player1, Player player2) {

        if ( players.contains(player1) ) {
            players.remove(player1);
            addPlayer(player2);
            }
        }


    public boolean remove(Player player) {
        if ( players.contains(player) ) {
                return players.remove(player);
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
        this.money = money;
    }


    public boolean addPlayer(Player player) {

        if ( isCanAdd(player) ) {

            this.setMoney(this.getMoney() - player.getPrice());
            return this.players.add(player);
        } else {
            return false;
        }

    }

    public boolean isCanAdd(Player player) {
        if ( player.getPrice() < this.money ) {
            if ( players.size() >= 11 ) {
                System.out.println("No se pueden agregar mas de 11 jugadores");
                return false;
            } else {
                if ( players.size() == 0 ) return true;
                int i = 0;
                for (Player p : players) {
                    boolean b = p.getClass().equals(player.getClass());
                    if ( b ) {
                        i++;
                    }

                }
                if ( player instanceof Goalkeeper ) return i > 0 ? false : true;//TODO VER SI SE PUEDE AGREGAR ALERTA
                if ( player instanceof Defender ) return i > 3 ? false : true;
                if ( player instanceof Midfielder ) return i > 3 ? false : true;
                if ( player instanceof Forward ) return i > 1 ? false : true;
            }
        } else {
            System.out.println("Fondos insuficientes.");
            return false;

        }
        return false;

    }
    private void checkPlayerType(){

    }

    public int getPointDate() {
        int score = 0;
        for (Player player :
                this.players) {
            score += player.getPoints();
        }
        return score;
    }

    @Override
    public String toString() {
        return "MyTeam{" +
                "players=" + players +
                ", teamName='" + teamName + '\'' +
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
