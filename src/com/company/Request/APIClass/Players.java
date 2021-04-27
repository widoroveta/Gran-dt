package com.company.Request.APIClass;

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
}
