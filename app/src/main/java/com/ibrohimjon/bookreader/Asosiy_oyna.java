package com.ibrohimjon.bookreader;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.ibrohimjon.bookreader.Asosiy.Frag_asosiy;
import com.ibrohimjon.bookreader.Music.Frag_music;
import com.ibrohimjon.bookreader.R;

public class Asosiy_oyna extends AppCompatActivity {

    LinearLayout btn_asosiy, btn_music, btn_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asosiy_oyna);

        btn_asosiy = findViewById(R.id.btn_asosiy);
        btn_music = findViewById(R.id.btn_music);
        btn_video = findViewById(R.id.btn_video);

        btn_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_asosiy.setBackgroundResource(R.color.colorPrimaryDark);
                btn_video.setBackgroundResource(R.color.colorPrimaryDark);
                btn_music.setBackgroundResource(R.color.colorPrimary);
                float x = btn_music.getX();
                Frag_music asosiy = new Frag_music();
                Oyna_ozgar(asosiy, x);
            }
        });

        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_asosiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_asosiy.setBackgroundResource(R.color.colorPrimary);
                btn_video.setBackgroundResource(R.color.colorPrimaryDark);
                btn_music.setBackgroundResource(R.color.colorPrimaryDark);
                float x = btn_asosiy.getX();
                Frag_asosiy asosiy = new Frag_asosiy();
                Oyna_ozgar(asosiy, x);
            }
        });

        btn_asosiy.setBackgroundResource(R.color.colorPrimary);
        btn_video.setBackgroundResource(R.color.colorPrimaryDark);
        btn_music.setBackgroundResource(R.color.colorPrimaryDark);
        float x = btn_asosiy.getX();
        Frag_asosiy asosiy = new Frag_asosiy();
        Oyna_ozgar(asosiy, x);
    }

    float eski_x = -2;

    private void Oyna_ozgar(Fragment targetFragment, float x) {

        if (eski_x == x) {
        } else if (eski_x < x) {
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
                    .replace(R.id.asosiy_frame, targetFragment)
                    .commit();
        } else {
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.asosiy_frame, targetFragment)
                    .commit();
        }
        eski_x = x;
    }
}
