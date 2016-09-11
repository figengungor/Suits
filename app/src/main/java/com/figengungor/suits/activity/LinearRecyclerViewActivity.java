package com.figengungor.suits.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.figengungor.suits.ui.DividerItemDecoration;
import com.figengungor.suits.model.Oyuncu;
import com.figengungor.suits.adapter.OyuncuAdapter;
import com.figengungor.suits.R;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;

public class LinearRecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    OyuncuAdapter adapter;
    ArrayList<Oyuncu> oyuncuListesi;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recyclerview);
        oyuncuListesiniDoldur();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new OyuncuAdapter(oyuncuListesi, this, R.layout.item__linear_oyuncu);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,R.drawable.divider));
        SlideInRightAnimationAdapter slideInRightAnimationAdapter = new SlideInRightAnimationAdapter(adapter);
        slideInRightAnimationAdapter.setFirstOnly(false);
        recyclerView.setAdapter(slideInRightAnimationAdapter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.linearRecyclerView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
