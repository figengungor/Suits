package com.figengungor.suits.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.figengungor.suits.BR;
import com.figengungor.suits.model.Replik;

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
        holder.binding.setVariable(BR.replik, replik);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return replikListesi.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewDataBinding binding;
        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
