package com.ibrohimjon.bookreader.Asosiy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibrohimjon.bookreader.R;

import java.util.ArrayList;

public class Frag_asosiy extends Fragment {

    RecyclerView recyclerView;
    Asosiy_recyclerView_adapter myAdapter;
    ArrayList<Asosiy_list> lstBook;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_asosiy, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        lstBook = new ArrayList<>();
        lstBook.add(new Asosiy_list("1", "Rich Dad and Poor Dad", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "Rich Dad and Poor Dad", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "Rich Dad and Poor Dad", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "Rich Dad and Poor Dad", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "Rich Dad and Poor Dad", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));
        lstBook.add(new Asosiy_list("1", "The Vegitarian", "Categorie Book", "Description book", "asa"));

        myAdapter = new Asosiy_recyclerView_adapter(getContext(), lstBook);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(myAdapter);

        return view;
    }

}
