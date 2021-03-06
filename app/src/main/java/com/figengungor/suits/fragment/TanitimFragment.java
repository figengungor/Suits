package com.figengungor.suits.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.figengungor.suits.R;
import com.figengungor.suits.model.Tanitim;
import com.figengungor.suits.network.OmdbService;
import com.figengungor.suits.network.ServiceGenerator;
import com.figengungor.suits.ui.MultiSwipeRefreshLayout;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.io.IOException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TanitimFragment extends Fragment {

    OmdbService omdbService;
    Call<Tanitim> tanitimCall;
    TextView year, released, runtime, genre, writer, actors, plot, imdbRating, imdbVotes, awards;
    ImageView poster;
    Tanitim tanitim;
    ProgressWheel progressWheel;
    LinearLayout content;
    MultiSwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        omdbService = ServiceGenerator.createService(OmdbService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tanitim, container, false);
        year = (TextView) view.findViewById(R.id.year);
        released = (TextView) view.findViewById(R.id.released);
        runtime = (TextView) view.findViewById(R.id.runtime);
        genre = (TextView) view.findViewById(R.id.genre);
        writer = (TextView) view.findViewById(R.id.writer);
        actors = (TextView) view.findViewById(R.id.actors);
        plot = (TextView) view.findViewById(R.id.plot);
        imdbRating = (TextView) view.findViewById(R.id.imdbRating);
        imdbVotes = (TextView) view.findViewById(R.id.imdbVotes);
        awards = (TextView) view.findViewById(R.id.awards);
        poster = (ImageView) view.findViewById(R.id.poster);
        content = (LinearLayout) view.findViewById(R.id.content);
        progressWheel = (ProgressWheel) view.findViewById(R.id.progressWheel);
        swipeRefreshLayout = (MultiSwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        tanitimCall = omdbService.tanitimBilgileriniCek("Suits");
        tanitimCall.enqueue(tanitimCallback);

        progressWheel.setVisibility(View.VISIBLE);

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
                    content.setVisibility(View.VISIBLE);
                    year.setText(tanitim.getYear());
                    released.setText(tanitim.getReleased());
                    runtime.setText(tanitim.getRuntime());
                    genre.setText(tanitim.getGenre());
                    writer.setText(tanitim.getWriter());
                    actors.setText(tanitim.getActors());
                    plot.setText(tanitim.getPlot());
                    imdbRating.setText(tanitim.getImdbRating() + " /10");
                    imdbVotes.setText(tanitim.getImdbVotes());
                    awards.setText(tanitim.getAwards());
                    Glide.with(getContext()).load(tanitim.getPoster()).into(poster);
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
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tanitimCall.clone().enqueue(tanitimCallback);
            }
        });

        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setSwipeableChildren(R.id.scrollView);
    }

    private void progressRefreshKaldir() {
        if (progressWheel.getVisibility() == View.VISIBLE)
            progressWheel.setVisibility(View.GONE);
        if (swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);
    }

    public void hataFragmentiniGoster(Fragment fragment) {
        content.setVisibility(View.GONE);
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
