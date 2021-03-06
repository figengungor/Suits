package com.figengungor.suits.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.figengungor.suits.R;
import com.figengungor.suits.adapter.OyuncuAdapter;
import com.figengungor.suits.model.Oyuncu;

import java.util.ArrayList;

public class GridRecyclerViewActivity extends BaseActivity implements OyuncuAdapter.ItemListener {
    RecyclerView recyclerView;
    OyuncuAdapter adapter;
    ArrayList<Oyuncu> oyuncuListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recyclerview);
        oyuncuListesiniDoldur();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new OyuncuAdapter(oyuncuListesi, R.layout.item__grid_oyuncu);
        adapter.setItemListener(this);
        recyclerView.setAdapter(adapter);

        setTitle(R.string.gridRecylerView);
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
        Toast.makeText(GridRecyclerViewActivity.this,
                oyuncu.getIsim() + ", tıklama gıdıklanıyorum dedi.",
                Toast.LENGTH_SHORT).show();
    }
}
