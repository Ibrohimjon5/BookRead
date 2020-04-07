package com.ibrohimjon.bookreader;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ibrohimjon.bookreader.m_s_y_q_l.c_i_c;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Splash extends AppCompatActivity {

    public static String tz_r = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Asosiy_oyna.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }

    public static void XATOLIK_YOZISH(Exception e) {
        e.printStackTrace();
    }

    public static String tz_r() {
        tz_r = "http://www.balans-it.uz/gold_reader/";
//        for (int i_ : r_p) {
//            tz_r = String.format("%s%s", tz_r, s_d_b_h_p_r.g_r_t_c_d(i_));
//        }
        return tz_r;
    }

    public static String d_w_d_t(String s) {
        BufferedReader reader = null;

        Charset charset = null;
        try {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                charset = StandardCharsets.UTF_8;
            } else {
                charset = Charset.defaultCharset();
            }
        } catch (Exception e) {
            XATOLIK_YOZISH(e);
        }
        HttpURLConnection con = null;
        try {
            con = c_i_c.c_nl_s(s);
        } catch (Exception e) {
            XATOLIK_YOZISH(e);
        }
        if (con == null) {
            return "no";
        }
        try {
            if (con != null) {
                InputStream inputStream;
                inputStream = new BufferedInputStream(con.getInputStream());
                reader = new BufferedReader(new InputStreamReader(inputStream, charset));
                String result = reader.readLine();

                if (result != null) {
                    return result;
                } else {
                    return "no";
                }
            }
        } catch (SocketException e) {
            XATOLIK_YOZISH(e);
        } catch (SocketTimeoutException e) {
            XATOLIK_YOZISH(e);
        } catch (IOException e) {
            XATOLIK_YOZISH(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    XATOLIK_YOZISH(e);
                }
            }
            if (con != null) {
                con.disconnect();
            }
        }

        return null;
    }

    public static boolean i_s_o_n(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            assert cm != null;
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            XATOLIK_YOZISH(e);
        }
        return false;
    }
}
