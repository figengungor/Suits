package com.figengungor.suits;

/**
 * Created by figengungor on 29.08.2016.
 */
public class Oyuncu {

    private int foto;
    private String isim;

    public Oyuncu(int foto, String isim) {
        this.foto = foto;
        this.isim = isim;
    }

    public int getFoto() {
        return foto;
    }

    public String getIsim() {
        return isim;
    }
}
