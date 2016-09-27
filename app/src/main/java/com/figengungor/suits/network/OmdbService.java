package com.figengungor.suits.network;

import com.figengungor.suits.model.Tanitim;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by figengungor on 25.09.2016.
 */
public interface OmdbService {

    @GET("./")
    Call<Tanitim> tanitimBilgileriniCek(@Query("t") String baslik);

}
