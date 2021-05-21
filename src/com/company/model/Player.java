package com.company.model;

import com.company.interfaz.Simulation;

public class Player implements Simulation {
    protected String playerName;
    protected int playerNumber;
    protected int Price;
    protected String clubName;


    //Transient
    protected transient boolean playerStatus;
    protected transient boolean mvp;
    protected transient int datePoint;
    protected transient int goals;
    protected transient boolean yellowCard;
    protected transient boolean redCard;

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

    public int getDatePoint() {
        return datePoint;
    }

    public void setDatePoint(int datePoint) {
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


    public int getPoints() {
        return 0;
    }
}
