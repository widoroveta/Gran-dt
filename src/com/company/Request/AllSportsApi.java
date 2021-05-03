package com.company.Request;

import com.company.Class.Club;
import com.company.Class.Player;
import com.company.Request.APIClass.Players;
import com.company.Request.APIClass.Teams;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
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
private List<Club> clubs =new ArrayList<>();
    public void toUpdate() {
        int i;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        for (i = 10; i < 41; i++) {
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
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {

                String responseLine = null;

                responseLine = br.readLine();
                System.out.println();
   String b=  responseLine.substring(responseLine.indexOf("[")+1,responseLine.length()-2);
               // String [] m =b.split("\\{");



       Teams t =mapper.readValue(b,Teams.class);
    List <Player> players = new ArrayList<>();
                for (Players c:
                     t.getPlayers()) {
                    players.add(new Player(c.getPlayer_name(),c.getPlayer_number(),c.getPlayer_country(),c.getPlayer_type(),c.getPlayer_match_played(),c.getPlayer_goals(),c.getPlayer_yellow_cards(),c.getPlayer_red_cards()));
                }
    Club club = new Club(t.getTeam_name(),players);
clubs.add(club);
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("clubs"),clubs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
