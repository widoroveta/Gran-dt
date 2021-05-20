package com.company.model;

import com.company.interfaz.Simulation;

public class Player implements Simulation {
    private String playerName;
    private int playerNumber;
    private int Price;
    private String clubName;


    //Transient
    private transient boolean playerStatus;
    private transient boolean mvp;
    private transient double datePoint;
    private transient int goals;
    private transient boolean yellowCard;
    private transient boolean redCard;

    public Player(String playerName, int playerNumber, String clubName) {
        this.playerName = playerName;
        this.playerNumber = playerNumber;

        this.clubName = clubName;
    }

    public Player() {

    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public boolean isPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(boolean playerStatus) {
        this.playerStatus = playerStatus;
    }

    public boolean isMvp() {
        return mvp;
    }

    public void setMvp(boolean mvp) {
        this.mvp = mvp;
    }

    public double getDatePoint() {
        return datePoint;
    }

    public void setDatePoint(double datePoint) {
        this.datePoint = datePoint;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public boolean isYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(boolean yellowCard) {
        this.yellowCard = yellowCard;
    }

    public boolean isRedCard() {
        return redCard;
    }

    public void setRedCard(boolean redCard) {
        this.redCard = redCard;
    }

    @Override
    public int getPoints() {
        if (this.isPlayerStatus()) {
            int points = 0;
            points=(int)datePoint;
            if (this.isRedCard()) {

            }
            if (this.isYellowCard()) {

            }
            if (this.isMvp()) {

            }
            if (this.goals != 0)
            {

            }

            return points;
        } else {
            return 0;
        }
    }
}
