package com.figengungor.suits.model;

/**
 * Created by figengungor on 04.09.2016.
 */
public class Replik {

    private int foto;
    private String replik;
    private String karakterAdi;

    public Replik(int foto, String replik, String karakterAdi) {
        this.foto = foto;
        this.replik = replik;
        this.karakterAdi = karakterAdi;
    }

    public int getFoto() {
        return foto;
    }

    public String getReplik() {
        return replik;
    }

    public String getKarakterAdi() {
        return karakterAdi;
    }
}
