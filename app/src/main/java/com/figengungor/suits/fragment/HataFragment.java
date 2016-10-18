package com.figengungor.suits.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.figengungor.suits.R;
import com.figengungor.suits.databinding.FragmentHataBinding;

/**
 * Created by figengungor on 2.10.2016.
 */
public class HataFragment extends Fragment {
    int ikonId;
    String aciklama;
    FragmentHataBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        ikonId = bundle.getInt("ikon");
        aciklama = bundle.getString("aciklama");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hata, container, false);
        View view = binding.getRoot();
        binding.aciklama.setText(aciklama);
        binding.ikon.setImageResource(ikonId);
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
