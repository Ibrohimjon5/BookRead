package com.ibrohimjon.bookreader.m_s_y_q_l;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.ibrohimjon.bookreader.Splash.XATOLIK_YOZISH;

public class c_i_c {

    public static HttpURLConnection c_nl_s(String ds) {
        try {
            URL url = new URL(ds);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(50000);
            con.setReadTimeout(50000);
            con.setDoInput(true);
//            con.setDoOutput(false);
//            con.connect();
            return con;
        } catch (MalformedURLException e) {
            XATOLIK_YOZISH(e);
        } catch (IOException e) {
            XATOLIK_YOZISH(e);
        }
        return null;
    }
}
