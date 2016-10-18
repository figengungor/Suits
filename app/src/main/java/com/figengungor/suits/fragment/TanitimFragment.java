package com.figengungor.suits.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.figengungor.suits.R;
import com.figengungor.suits.databinding.FragmentTanitimBinding;
import com.figengungor.suits.model.Tanitim;
import com.figengungor.suits.network.OmdbService;
import com.figengungor.suits.network.ServiceGenerator;

import java.io.IOException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TanitimFragment extends Fragment {

    OmdbService omdbService;
    Call<Tanitim> tanitimCall;
    Tanitim tanitim;
    FragmentTanitimBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        omdbService = ServiceGenerator.createService(OmdbService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tanitim, container, false);
        View view = binding.getRoot();

        tanitimCall = omdbService.tanitimBilgileriniCek("Suits");
        tanitimCall.enqueue(tanitimCallback);

        binding.progressWheelLayout.progressWheel.setVisibility(View.VISIBLE);

        swipeRefreshAyarla();

        return view;
    }

    private Callback<Tanitim> tanitimCallback = new Callback<Tanitim>() {

        @Override
        public void onResponse(Call<Tanitim> call, Response<Tanitim> response) {
            if (response.isSuccessful()) {
                tanitim = response.body();
                if (tanitim.getResponse().equalsIgnoreCase("False")) {
                    hataFragmentiniGoster(HataFragment.newInstance(R.drawable.ic_error_outline_24dp, tanitim.getError()));
                } else {
                    hataFragmentiniKaldir();
                    binding.content.setVisibility(View.VISIBLE);
                    binding.setTanitim(tanitim);
                }
            } else {
                hataFragmentiniGoster(HataFragment.newInstance(R.drawable.ic_error_outline_24dp,
                        response.code() + " : " + response.message() + getString(R.string.contactdeveloper)));
            }
            progressRefreshKaldir();
        }

        @Override
        public void onFailure(Call<Tanitim> call, Throwable t) {

            if (t instanceof SocketTimeoutException) {
                hataFragmentiniGoster(HataFragment.newInstance(R.drawable.ic_timeout, getString(R.string.timeout)));
            } else if (t instanceof IOException) {
                hataFragmentiniGoster(HataFragment.newInstance(R.drawable.ic_no_internet, getString(R.string.noInternet)));
            } else {
                hataFragmentiniGoster(HataFragment.newInstance(R.drawable.ic_error_outline_24dp, t.getMessage()));
            }

            progressRefreshKaldir();

        }
    };

    @Override
    public void onDestroy() {
        tanitimCall.cancel();
        super.onDestroy();
    }

    private void swipeRefreshAyarla() {
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tanitimCall.clone().enqueue(tanitimCallback);
            }
        });

        binding.swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        binding.swipeRefreshLayout.setSwipeableChildren(R.id.scrollView);
    }

    private void progressRefreshKaldir() {
        if (binding.progressWheelLayout.progressWheel.getVisibility() == View.VISIBLE)
            binding.progressWheelLayout.progressWheel.setVisibility(View.GONE);
        if (binding.swipeRefreshLayout.isRefreshing())
            binding.swipeRefreshLayout.setRefreshing(false);
    }

    public void hataFragmentiniGoster(Fragment fragment) {
        binding.content.setVisibility(View.GONE);
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment).commitAllowingStateLoss();
    }

    public void hataFragmentiniKaldir() {
        if (getChildFragmentManager().findFragmentById(R.id.fragmentContainer) != null)
            getChildFragmentManager()
                    .beginTransaction()
                    .remove(getChildFragmentManager().findFragmentById(R.id.fragmentContainer))
                    .commitAllowingStateLoss();
    }


}
