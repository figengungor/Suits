package com.figengungor.suits;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

public class CardRecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ReplikAdapter adapter;
    ArrayList<Replik> replikListesi;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recyclerview);
        replikListesiniDoldur();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new ReplikAdapter(replikListesi, this, R.layout.item__card_replik);
        recyclerView.setAdapter(adapter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.cardRecylerView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void replikListesiniDoldur() {
        replikListesi = new ArrayList<Replik>();
        replikListesi.add(new Replik(R.drawable.harvey1, "Ben ihtimallere oynamam. Adama oynarım.", "Harvey Specter"));
        replikListesi.add(new Replik(R.drawable.harvey2, "Avukatlık doktorluğa çok benzer, acıtana kadar bastırırsın ve böylece nereye bakman gerektiğini anlarsın.", "Harvey Specter"));
        replikListesi.add(new Replik(R.drawable.harvey3, "İşte aramızdaki fark bu; Sen küçük kaybetmek istiyorsun ben ise büyük kazanmak.", "Harvey Specter"));
        replikListesi.add(new Replik(R.drawable.harvey4, "Benim hayallerim yok, hedeflerim var.", "Harvey Specter"));
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
