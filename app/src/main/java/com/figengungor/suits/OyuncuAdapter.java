package com.figengungor.suits;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by figengungor on 29.08.2016.
 */
public class OyuncuAdapter extends RecyclerView.Adapter<OyuncuAdapter.ViewHolder> {

    private static final String TAG = OyuncuAdapter.class.getSimpleName();
    int createSayac = 1;
    int bindSayac = 1;
    ArrayList<Oyuncu> oyuncuListesi;
    Context context;

    public OyuncuAdapter(ArrayList<Oyuncu> oyuncuListesi, Context context) {
        this.oyuncuListesi = oyuncuListesi;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "OnCreateViewHolder : " + createSayac++);
        View v = LayoutInflater.from(context).inflate(R.layout.item_oyuncu, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder : " + bindSayac++);
        Oyuncu oyuncu = oyuncuListesi.get(position);
        holder.isim.setText(oyuncu.getIsim());
        holder.foto.s
        Glide.with(context).load(oyuncu.getFoto()).into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return oyuncuListesi.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView foto;
        TextView isim;

        public ViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView)itemView.findViewById(R.id.foto);
            isim = (TextView)itemView.findViewById(R.id.isim);
        }
    }




}
