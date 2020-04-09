package com.ibrohimjon.bookreader.Asosiy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibrohimjon.bookreader.Asosiy.info.Book_info;
import com.ibrohimjon.bookreader.R;
import com.ibrohimjon.bookreader.Splash;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ibrohimjon on 07.04.2020
 */

public class Asosiy_recyclerView_adapter extends RecyclerView.Adapter<Asosiy_recyclerView_adapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Asosiy_list> mData;
    SharedPreferences.Editor editor;
    SharedPreferences preferences;


    public Asosiy_recyclerView_adapter(Context mContext, ArrayList<Asosiy_list> mData) {
        this.mContext = mContext;
        this.mData = mData;
        preferences = mContext.getSharedPreferences("book", Activity.MODE_PRIVATE);
        editor = preferences.edit();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_kitob, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.txt_nomi.setText(mData.get(position).getNomi());
//        holder.image_kitob.setImageResource(R.drawable.icon_rich_dad);
        Picasso.with(mContext).load(Splash.tz_r() + mData.get(position).getImage_url()).into(holder.image_kitob);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Asosiy_list list = mData.get(position);
                Mal_saqlash("id", list.getId());
                Mal_saqlash("nomi", list.getNomi());
                Mal_saqlash("categ", list.getCategory());
                Mal_saqlash("desc", list.getDescription());
                Mal_saqlash("book", list.getBook_url());
                Mal_saqlash("image", list.getImage_url());
                Intent intent = new Intent(mContext, Book_info.class);
                mContext.startActivity(intent);

            }
        });


    }

    public void Mal_saqlash(String kalit, String qiymat) {
        editor.putString(kalit, qiymat);
        editor.commit();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_nomi;
        ImageView image_kitob;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_nomi = (TextView) itemView.findViewById(R.id.txt_nomi);
            image_kitob = (ImageView) itemView.findViewById(R.id.image_kitob);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}
