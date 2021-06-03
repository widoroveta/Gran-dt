package com.company.request;

import com.company.enums.Prices;
import com.company.model.*;
import com.company.repository.ClubRepository;
import com.company.request.APIClass.Players;
import com.company.request.APIClass.Teams;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AllSportsApi {
    private static final String appKey = "4f613aeef397a3ac7ed09e01692012de508c4f7f66277ac5a0eb798113e7081e";
    private final List<String> stringList = new ArrayList<>();
    private HttpURLConnection con = null;
    private final List<Club> clubs = new ArrayList<>();

    public void toUpdate() throws IOException {
        int i;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        for (i = 10; i <= 40; i++) {
            try {
                URL url = new URL("https://allsportsapi.com/api/football/?&met=Teams&teamId=26" + i + "&APIkey=" + appKey);

                con = (HttpURLConnection) url.openConnection();
                con.setDoOutput(true);

            } catch (
                    IOException e) {
                e.printStackTrace();
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                responseLine = br.readLine();
                String b = responseLine.substring(responseLine.indexOf("[") + 1, responseLine.length() - 2);
                Teams t = mapper.readValue(b, Teams.class);
                List<Player> players = new ArrayList<>();
                for (Players c : t.getPlayers()) {
                    int random = (int) (Math.random() * ((Prices.values().length - 1) + 1));
                    switch (c.getPlayer_type()) {
                        case "Goalkeepers":
                            players.add(new Goalkeeper(c.getPlayer_name(), Integer.parseInt(c.getPlayer_number()), t.getTeam_name(), Prices.values()[random].getPrice()));
                            break;
                        case "Defenders":
                            players.add(new Defender(c.getPlayer_name(), Integer.parseInt(c.getPlayer_number()), t.getTeam_name(), Prices.values()[random].getPrice()));

                            break;
                        case "Midfielders":
                            players.add(new Midfielder(c.getPlayer_name(), Integer.parseInt(c.getPlayer_number()), t.getTeam_name(), Prices.values()[random].getPrice()));

                            break;
                        case "Forwards":
                            players.add(new Forward(c.getPlayer_name(), Integer.parseInt(c.getPlayer_number()), t.getTeam_name(), Prices.values()[random].getPrice()));

                            break;
                        default:

                    }
                }
                Club club = new Club(t.getTeam_name(), players);
                clubs.add(club);

            }
            ClubRepository clubRepository = new ClubRepository();
            clubRepository.setClubs(clubs);
            clubRepository.save();


        }
    }

}
