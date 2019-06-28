    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpConnections;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Mario
 */
public class Globals {
    public static String host = "http://localhost:3000/";
    /*public static Retrofit RetrofitClient = new Retrofit
            .Builder()
            .baseUrl("http://localhost:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();*/
    public static String USER_AGENT = "Mozilla/5.0";
    public static JsonElement sendGet(String path) throws Exception {

        String url = host + path;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
        }
        in.close();
        JsonParser json = new JsonParser();
        JsonElement objeto = json.parse(response.toString());
        //print result
        return objeto;
    }
}

