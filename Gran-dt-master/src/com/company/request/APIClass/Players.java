package com.company.request.APIClass;

public class Players {
    private long player_key;
    private String player_name;
    private String player_number;
    private String player_country;
    private String player_type;
    private String player_a;
    private String player_age;
    private int player_match_played;
    private int player_goals;
    private int player_yellow_cards;
    private int player_red_cards;

    public Players() {
    }

    public Players(long player_key, String player_name, String player_number, String player_country, String player_type, String player_age, int player_match_played, int player_goals, int player_yellow_cards, int player_red_cards) {

        this.player_key = player_key;
        this.player_name = player_name;
        this.player_number = player_number;
        this.player_country = player_country;
        this.player_type = player_type;
        this.player_age = player_age;
        this.player_match_played = player_match_played;
        this.player_goals = player_goals;
        this.player_yellow_cards = player_yellow_cards;
        this.player_red_cards = player_red_cards;
    }

    @Override
    public String toString() {
        return "Players{" +
                "player_key=" + player_key +
                ", player_name='" + player_name + '\'' +
                ", player_number='" + player_number + '\'' +
                ", player_country='" + player_country + '\'' +
                ", player_type='" + player_type + '\'' +
                ", player_age=" + player_age +
                ", player_match_played=" + player_match_played +
                ", player_goals=" + player_goals +
                ", player_yellow_cards=" + player_yellow_cards +
                ", player_red_cards=" + player_red_cards +
                '}';
    }

    public long getPlayer_key() {
        return player_key;
    }

    public void setPlayer_key(long player_key) {
        this.player_key = player_key;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_number() {
        return player_number;
    }

    public void setPlayer_number(String player_number) {
        this.player_number = player_number;
    }

    public String getPlayer_country() {
        return player_country;
    }

    public void setPlayer_country(String player_country) {
        this.player_country = player_country;
    }

    public String getPlayer_type() {
        return player_type;
    }

    public void setPlayer_type(String player_type) {
        this.player_type = player_type;
    }

    public String getPlayer_a() {
        return player_a;
    }

    public void setPlayer_a(String player_a) {
        this.player_a = player_a;
    }

    public String getPlayer_age() {
        return player_age;
    }

    public void setPlayer_age(String player_age) {
        this.player_age = player_age;
    }

    public int getPlayer_match_played() {
        return player_match_played;
    }

    public void setPlayer_match_played(int player_match_played) {
        this.player_match_played = player_match_played;
    }

    public int getPlayer_goals() {
        return player_goals;
    }

    public void setPlayer_goals(int player_goals) {
        this.player_goals = player_goals;
    }

    public int getPlayer_yellow_cards() {
        return player_yellow_cards;
    }

    public void setPlayer_yellow_cards(int player_yellow_cards) {
        this.player_yellow_cards = player_yellow_cards;
    }

    public int getPlayer_red_cards() {
        return player_red_cards;
    }

    public void setPlayer_red_cards(int player_red_cards) {
        this.player_red_cards = player_red_cards;
    }
}
