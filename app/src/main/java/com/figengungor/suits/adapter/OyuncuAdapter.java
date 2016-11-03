package com.figengungor.suits.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.figengungor.suits.R;
import com.figengungor.suits.model.Oyuncu;

import java.util.ArrayList;

/**
 * Created by figengungor on 29.08.2016.
 */
public class OyuncuAdapter extends RecyclerView.Adapter<OyuncuAdapter.ViewHolder> {

    private static final String TAG = OyuncuAdapter.class.getSimpleName();
    int createSayac = 1;
    int bindSayac = 1;
    ArrayList<Oyuncu> oyuncuListesi;
    int itemLayout;
    ItemListener itemListener;

    public OyuncuAdapter(ArrayList<Oyuncu> oyuncuListesi, int itemLayout) {
        this.oyuncuListesi = oyuncuListesi;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "OnCreateViewHolder : " + createSayac++);
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder : " + bindSayac++);
        Oyuncu oyuncu = oyuncuListesi.get(position);
        holder.bindItem(oyuncu);
    }

    @Override
    public int getItemCount() {
        return oyuncuListesi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView foto;
        TextView isim;
        Oyuncu oyuncu;

        public ViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView)itemView.findViewById(R.id.foto);
            isim = (TextView)itemView.findViewById(R.id.isim);
            itemView.setOnClickListener(this);
        }

        public void bindItem(Oyuncu oyuncu) {
            this.oyuncu = oyuncu;
            isim.setText(oyuncu.getIsim());
            Glide.with(itemView.getContext()).load(oyuncu.getFoto()).into(foto);
        }

        @Override
        public void onClick(View v) {
            if(itemListener != null) {
                itemListener.onItemClicked(oyuncu);
            }
        }
    }

    public interface ItemListener{
        public void onItemClicked(Oyuncu oyuncu);
    }

    public void setItemListener(ItemListener itemListener){
        this.itemListener = itemListener;
    }

}
