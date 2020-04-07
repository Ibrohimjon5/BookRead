package com.ibrohimjon.bookreader.Music;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibrohimjon.bookreader.R;

import java.util.ArrayList;

/**
 * Created by Ibrohimjon on 07.04.2020.
 */
public class Frag_music extends Fragment {


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_music, container, false);
        return view;
    }
}
