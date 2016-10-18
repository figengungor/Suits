package com.figengungor.suits.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.figengungor.suits.R;
import com.figengungor.suits.adapter.ReplikAdapter;
import com.figengungor.suits.databinding.ActivityCardRecyclerviewBinding;
import com.figengungor.suits.model.Replik;

import java.util.ArrayList;

public class CardRecyclerViewActivity extends BaseActivity {
    ReplikAdapter adapter;
    ArrayList<Replik> replikListesi;
    ActivityCardRecyclerviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_card_recyclerview);
        replikListesiniDoldur();
        adapter = new ReplikAdapter(replikListesi, this, R.layout.item_card_replik);
        binding.recyclerView.setAdapter(adapter);

        setToolbarAndTitle(binding.toolbarLayout.toolbar, getString(R.string.cardRecylerView));
    }

    public void replikListesiniDoldur() {
        replikListesi = new ArrayList<Replik>();
        replikListesi.add(new Replik(R.drawable.harvey1, "Ben ihtimallere oynamam. Adama oynarım.", "Harvey Specter"));
        replikListesi.add(new Replik(R.drawable.harvey2, "Avukatlık doktorluğa çok benzer, acıtana kadar bastırırsın ve böylece nereye bakman gerektiğini anlarsın.", "Harvey Specter"));
        replikListesi.add(new Replik(R.drawable.harvey3, "İşte aramızdaki fark bu; Sen küçük kaybetmek istiyorsun ben ise büyük kazanmak.", "Harvey Specter"));
        replikListesi.add(new Replik(R.drawable.harvey4, "Benim hayallerim yok, hedeflerim var.", "Harvey Specter"));
    }
}
