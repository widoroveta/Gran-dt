package com.company.model;

public class Player {
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

}
