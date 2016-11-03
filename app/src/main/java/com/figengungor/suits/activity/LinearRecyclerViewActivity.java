package com.figengungor.suits.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.figengungor.suits.R;
import com.figengungor.suits.adapter.OyuncuAdapter;
import com.figengungor.suits.model.Oyuncu;
import com.figengungor.suits.ui.DividerItemDecoration;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;

public class LinearRecyclerViewActivity extends BaseActivity implements OyuncuAdapter.ItemListener {
    RecyclerView recyclerView;
    OyuncuAdapter adapter;
    ArrayList<Oyuncu> oyuncuListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recyclerview);
        oyuncuListesiniDoldur();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new OyuncuAdapter(oyuncuListesi, R.layout.item__linear_oyuncu);
        adapter.setItemListener(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, R.drawable.divider));
        SlideInRightAnimationAdapter slideInRightAnimationAdapter = new SlideInRightAnimationAdapter(adapter);
        slideInRightAnimationAdapter.setFirstOnly(false);
        recyclerView.setAdapter(slideInRightAnimationAdapter);

        setTitle(R.string.linearRecyclerView);
    }

    public void oyuncuListesiniDoldur() {
        oyuncuListesi = new ArrayList<Oyuncu>();
        oyuncuListesi.add(new Oyuncu(R.drawable.gabrielmacht, "Gabriel Macht"));
        oyuncuListesi.add(new Oyuncu(R.drawable.patrickjadams, "Patrick J. Adams"));
        oyuncuListesi.add(new Oyuncu(R.drawable.sarahrafferty, "Sarah Rafferty"));
        oyuncuListesi.add(new Oyuncu(R.drawable.meghanmarkle, "Meghan Markle"));
        oyuncuListesi.add(new Oyuncu(R.drawable.rickhoffman, "Rick Hoffman"));
        oyuncuListesi.add(new Oyuncu(R.drawable.ginatorres, "Gina Torres"));
        oyuncuListesi.add(new Oyuncu(R.drawable.tomlipinski, "Tom Lipinski"));
        oyuncuListesi.add(new Oyuncu(R.drawable.vanessaray, "Vanessa Ray"));
        oyuncuListesi.add(new Oyuncu(R.drawable.rebeccaschull, "Rebecca Schull"));
        oyuncuListesi.add(new Oyuncu(R.drawable.poochhall, "Pooch Hall"));
        oyuncuListesi.add(new Oyuncu(R.drawable.melaniepaplia, "Melanie Paplia"));
        oyuncuListesi.add(new Oyuncu(R.drawable.maxtopplin, "Max Topplin"));
        oyuncuListesi.add(new Oyuncu(R.drawable.maxbeesley, "Max Beesley"));
        oyuncuListesi.add(new Oyuncu(R.drawable.garycole, "Gary Cole"));
        oyuncuListesi.add(new Oyuncu(R.drawable.ericclose, "Eric Close"));
        oyuncuListesi.add(new Oyuncu(R.drawable.davidcostabile, "David Costabile"));
        oyuncuListesi.add(new Oyuncu(R.drawable.amandaschull, "Amanda Schull"));
    }

    @Override
    public void onItemClicked(Oyuncu oyuncu) {
        Toast.makeText(LinearRecyclerViewActivity.this,
                oyuncu.getIsim() + ", tıklama gıdıklanıyorum dedi.",
                Toast.LENGTH_SHORT).show();
    }
}
