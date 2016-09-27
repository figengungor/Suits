package com.figengungor.suits.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by figengungor on 26.09.2016.
 */
public class Status {

    @SerializedName("Response")
    private String response;
    @SerializedName("Error")
    private String error;

    public String getResponse() {
        return response;
    }

    public String getError() {
        return error;
    }
}
