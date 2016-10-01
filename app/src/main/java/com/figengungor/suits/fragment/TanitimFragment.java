package com.figengungor.suits.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.figengungor.suits.R;
import com.figengungor.suits.model.Tanitim;
import com.figengungor.suits.network.OmdbService;
import com.figengungor.suits.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TanitimFragment extends Fragment {

    OmdbService omdbService;
    Call<Tanitim> tanitimCall;
    TextView year, released, runtime, genre, writer, actors, plot, imdbRating, imdbVotes, awards;
    ImageView poster;
    Tanitim tanitim;

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
        imdbVotes  = (TextView) view.findViewById(R.id.imdbVotes );
        awards  = (TextView) view.findViewById(R.id.awards );
        poster = (ImageView) view.findViewById(R.id.poster);

        tanitimCall = omdbService.tanitimBilgileriniCek("Suits");
        tanitimCall.enqueue(tanitimCallback);

        return view;
    }

    private Callback<Tanitim> tanitimCallback = new Callback<Tanitim>() {

        @Override
        public void onResponse(Call<Tanitim> call, Response<Tanitim> response) {
            if (response.isSuccessful()) {
                tanitim = response.body();
                if(tanitim.getResponse().equalsIgnoreCase("False")){
                    Toast.makeText(getContext(), tanitim.getError(), Toast.LENGTH_SHORT).show();
                }
                else {
                    year.setText(tanitim.getYear());
                    released.setText(tanitim.getReleased());
                    runtime.setText(tanitim.getRuntime());
                    genre.setText(tanitim.getGenre());
                    writer.setText(tanitim.getWriter());
                    actors.setText(tanitim.getActors());
                    plot.setText(tanitim.getPlot());
                    imdbRating.setText(tanitim.getImdbRating()+" /10");
                    imdbVotes.setText(tanitim.getImdbVotes());
                    awards.setText(tanitim.getAwards());
                    Glide.with(getContext()).load(tanitim.getPoster()).into(poster);
                }

            } else {
                Toast.makeText(getContext(), response.code() + " " + response.message(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<Tanitim> call, Throwable t) {
            Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onDestroy() {
        tanitimCall.cancel();
        super.onDestroy();
    }

}
