package com.company.Class;

public class Player {
    private  String playerName;

    private String playerNumber;
    private String playerCountry;
    private String playerType;
    private int playerMatchPlayed;
    private int playerGoals;
    private int playerYellowCards;
    private int playerRedCards;

    public Player(String playerName, String playerNumber, String playerCountry, String playerType, int playerMatchPlayed, int playerGoals, int playerYellowCards, int playerRedCards) {
        this.playerName = playerName;
        this.playerNumber = playerNumber;
        this.playerCountry = playerCountry;
        this.playerType = playerType;
        this.playerMatchPlayed = playerMatchPlayed;
        this.playerGoals = playerGoals;
        this.playerYellowCards = playerYellowCards;
        this.playerRedCards = playerRedCards;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerNumber='" + playerNumber + '\'' +
                ", playerCountry='" + playerCountry + '\'' +
                ", playerType='" + playerType + '\'' +
                ", playerMatchPlayed=" + playerMatchPlayed +
                ", playerGoals=" + playerGoals +
                ", playerYellowCards=" + playerYellowCards +
                ", playerRedCards=" + playerRedCards +
                '}';
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerCountry() {
        return playerCountry;
    }

    public void setPlayerCountry(String playerCountry) {
        this.playerCountry = playerCountry;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public int getPlayerMatchPlayed() {
        return playerMatchPlayed;
    }

    public void setPlayerMatchPlayed(int playerMatchPlayed) {
        this.playerMatchPlayed = playerMatchPlayed;
    }

    public int getPlayerGoals() {
        return playerGoals;
    }

    public void setPlayerGoals(int playerGoals) {
        this.playerGoals = playerGoals;
    }

    public int getPlayerYellowCards() {
        return playerYellowCards;
    }

    public void setPlayerYellowCards(int playerYellowCards) {
        this.playerYellowCards = playerYellowCards;
    }

    public int getPlayerRedCards() {
        return playerRedCards;
    }

    public void setPlayerRedCards(int playerRedCards) {
        this.playerRedCards = playerRedCards;
    }
}
