package com.figengungor.suits;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

/**
 * Created by figengungor on 04.09.2016.
 */
public class ReplikAdapter extends RecyclerView.Adapter<ReplikAdapter.ViewHolder> {
    ArrayList<Replik> replikListesi;
    Context context;
    int itemLayout;

    public ReplikAdapter(ArrayList<Replik> replikListesi, Context context, int itemLayout) {
        this.replikListesi = replikListesi;
        this.context=context;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Replik replik = replikListesi.get(position);
        holder.replik.setText(replik.getReplik());
        holder.karakterAdi.setText(replik.getKarakterAdi());
        Glide.with(context).load(replik.getFoto()).into(holder.foto);

    }

    @Override
    public int getItemCount() {
        return replikListesi.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView foto;
        TextView replik;
        TextView karakterAdi;

        public ViewHolder(View itemView) {
            super(itemView);
            foto = (RoundedImageView)itemView.findViewById(R.id.foto);
            replik = (TextView)itemView.findViewById(R.id.replik);
            karakterAdi = (TextView) itemView.findViewById(R.id.karakterAdi);
        }
    }
}
