package com.company;

import com.company.Request.AllSportsApi;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String appKey = "4f613aeef397a3ac7ed09e01692012de508c4f7f66277ac5a0eb798113e7081e";
        URL url = null;
        List<String> stringList=new ArrayList<>();
        HttpURLConnection con = null;
        String jsonInputString = "{\"country_key\": \"country_name\"}";
        try {
            url = new URL("https://allsportsapi.com/api/football/?met=Countries&APIkey=" + appKey);
            con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
                //System.out.println(os)
                System.out.println(jsonInputString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
              //  while ((responseLine = br.readLine()) != null) {
                  responseLine= br.readLine();
               // }

              String d=responseLine.replaceAll("country_key","countryKey");
              String t=d.replaceAll("country_name","countryName");
              d=t.replaceAll("country_iso","countryIso");
              t=d.replaceAll("country_logo","countryLogo");
              System.out.println(t);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

