package dev.dankom.util.general;

import dev.dankom.util.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil implements Util {

    private final String readUrl;

    public HttpUtil(String url) {
        this.readUrl = url;
    }

    public StringBuilder getStringBuilder() throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = getURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result;
    }

    public URL getURL() {
        try {
            return new URL(readUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
