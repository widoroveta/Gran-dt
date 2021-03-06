package com.company.model;

import com.company.interfaz.Simulation;

public class Player implements Simulation,Comparable<Player>,Cloneable {
    protected String playerName;
    protected int playerNumber;
    protected int price;
    protected String clubName;

    //Transient
    protected transient boolean playerStatus;
    protected transient boolean mvp;
    protected transient int goals;
    protected transient boolean yellowCard;
    protected transient boolean redCard;
    protected transient int points;

    public Player(String playerName, int playerNumber, String clubName, int price) {
        this.playerName = playerName;
        this.playerNumber = playerNumber;
        this.price = price;
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
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public boolean playYellowCard() {
        int random = 1 + (int) (Math.random() * ((1000 - 1) + 1));
        setYellowCard(random > 700);
        return yellowCard;
    }

    public boolean isRedCard() {
        return redCard;
    }

    public void setRedCard(boolean redCard) {
        this.redCard = redCard;
    }

    public void playRedCard(boolean redCard) {
        this.redCard = redCard;
    }

    public boolean playRedCard() {
        int random = 1 + (int) (Math.random() * ((1000 - 1) + 1));
        setRedCard(random > 960);
        return redCard;
    }


    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerNumber=" + playerNumber +
                ", price=" + price +
                ", clubName='" + clubName + '\'' +
                ", playerStatus=" + playerStatus +
                ", mvp=" + mvp +
                ", goals=" + goals +
                ", yellowCard=" + yellowCard +
                ", redCard=" + redCard +
                ", points=" + points +
                '}';
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void doPoints() { }

    @Override
    public int compareTo(Player o) {
     if(this instanceof Goalkeeper && (o instanceof Defender || o instanceof Midfielder || o instanceof Forward ))
     {
         return -1;
     }
        if( this instanceof Defender && (o instanceof Midfielder || o instanceof Forward ))
        {
            return -1;
        }
        if( this instanceof Midfielder && o instanceof Forward )
        {
            return -1;
        }
        return 0;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
