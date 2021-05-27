package com.company.request;

import com.company.model.*;
import com.company.request.APIClass.Players;
import com.company.request.APIClass.Teams;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AllSportsApi<T> {
    private static final String appKey = "4f613aeef397a3ac7ed09e01692012de508c4f7f66277ac5a0eb798113e7081e";
    private URL url = null;
    private List<String> stringList = new ArrayList<>();
    private HttpURLConnection con = null;
    private List<Club> clubs = new ArrayList<>();

    public void toUpdate() throws IOException {
        int i;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        for (i = 10; i <= 40; i++) {
            try {
                url = new URL("https://allsportsapi.com/api/football/?&met=Teams&teamId=26" + i + "&APIkey=" + appKey);

                con = (HttpURLConnection) url.openConnection();
                con.setDoOutput(true);

            } catch (
                    MalformedURLException e) {
                e.printStackTrace();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                String responseLine = null;
                responseLine = br.readLine();
                String b = responseLine.substring(responseLine.indexOf("[") + 1, responseLine.length() - 2);
                Teams t = mapper.readValue(b, Teams.class);
                List<Player> players = new ArrayList<>();
                for (Players c : t.getPlayers()) {
                    switch (c.getPlayer_type()) {
                        case "Goalkeepers":
                            players.add(new Goalkeeper(c.getPlayer_name(), Integer.parseInt(c.getPlayer_number()), t.getTeam_name()));
                            break;
                        case "Defenders":
                            players.add(new Defender(c.getPlayer_name(), Integer.parseInt(c.getPlayer_number()), t.getTeam_name()));

                            break;
                        case "Midfielders":
                            players.add(new Midfielder(c.getPlayer_name(), Integer.parseInt(c.getPlayer_number()), t.getTeam_name()));

                            break;
                        case "Forwards":
                            players.add(new Forward(c.getPlayer_name(), Integer.parseInt(c.getPlayer_number()), t.getTeam_name()));

                            break;
                        default:

                    }
                }
                Club club = new Club(t.getTeam_name(), players);
                clubs.add(club);

            }

            try {
              mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("clubs.json"), clubs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
