package com.figengungor.suits.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.figengungor.suits.R;

/**
 * Created by figengungor on 2.10.2016.
 */
public class HataFragment extends Fragment {
    TextView aciklamaTxt;
    ImageView ikon;
    int ikonId;
    String aciklama;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        ikonId = bundle.getInt("ikon");
        aciklama = bundle.getString("aciklama");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hata, container, false);

        aciklamaTxt = (TextView) view.findViewById(R.id.aciklama);
        ikon = (ImageView) view.findViewById(R.id.ikon);
        aciklamaTxt.setText(aciklama);
        ikon.setImageResource(ikonId);

        return view;
    }

    public static HataFragment newInstance(int ikon, String aciklama) {

        Bundle args = new Bundle();
        args.putInt("ikon", ikon);
        args.putString("aciklama", aciklama);
        HataFragment fragment = new HataFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
