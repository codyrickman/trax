package com.creatovemindstudios.trax.particle;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import elemental.json.Json;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {

    static JsonArray getRequest() {
        try {
            String url = "http://" + this.mod_properties.getProperty("mod_ip") + ":8080/rest/things/";

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setConnectTimeout(3000);
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + "");

            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            //System.out.println(response.toString());
            JsonArray resp = new JsonParser().parse(response.toString()).getAsJsonArray();
            return resp;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonArray();
    }

    static JsonObject postRequest() {
        try {
            String url = "/";

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setConnectTimeout(3000);
            con.setRequestMethod("POST");

            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + "");

            String urlParameters = "";
            // Send put request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            //System.out.println(response.toString());
            JsonObject resp = new JsonParser().parse(response.toString()).getAsJsonObject();
            return resp;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonObject();
    }
}
