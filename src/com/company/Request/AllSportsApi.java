package com.company.Request;

import com.company.Class.Team;
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
private List<Teams> teams =new ArrayList<>();
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
    teams.add(t);

            } catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("Teams.json"),teams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
