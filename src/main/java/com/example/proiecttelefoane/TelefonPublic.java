package com.example.proiecttelefoane;

public class TelefonPublic extends Telefon{
    private String sanatateBaterie = "baterie duracell";
    private String culoareTelefon = "culoare rosie";
    private String dimensiuniTelefon = "nicio dimensiune";
    private int dimensiuneaCabinei;

    public TelefonPublic(String sanatateBaterie, String culoareTelefon, String dimensiuniTelefon, int dimensiuneaCabinei) {
        this.sanatateBaterie = sanatateBaterie;
        this.culoareTelefon = culoareTelefon;
        this.dimensiuniTelefon = dimensiuniTelefon;
        this.dimensiuneaCabinei = dimensiuneaCabinei;
    }

    public TelefonPublic(TelefonPublic telefon) {
        this.pret = telefon.pret;
        this.model = telefon.model;
        this.culoareTelefon = telefon.culoareTelefon;
        this.dimensiuniTelefon = telefon.dimensiuniTelefon;
    }

    public TelefonPublic()   {
    }

    @Override
    void pretAbonament() {
        System.out.println("Pretul abonament pentru telefon public");

    }

    @Override
    void incarcareBaterie() {
        System.out.println("Pretul abonament pentru telefon public");

    }
    public String getModel(){
        return this.model;
    }

    public String getSanatateBaterie() {
        return sanatateBaterie;
    }

    public void setSanatateBaterie(String sanatateBaterie) {
        this.sanatateBaterie = sanatateBaterie;
    }

    public String getCuloareTelefon() {
        return culoareTelefon;
    }

    public void setCuloareTelefon(String culoareTelefon) {
        this.culoareTelefon = culoareTelefon;
    }

    public String getDimensiuniTelefon() {
        return dimensiuniTelefon;
    }

    public void setDimensiuniTelefon(String dimensiuniTelefon) {
        this.dimensiuniTelefon = dimensiuniTelefon;
    }

    public int getDimensiuneaCabinei() {
        return dimensiuneaCabinei;
    }

    public void setDimensiuneaCabinei(int dimensiuneaCabinei) {
        this.dimensiuneaCabinei = dimensiuneaCabinei;
    }
    @Override
    public String toString(){
        String mesaj;
        mesaj = "Specificaţii: " +
                "Culoarea - " + this.culoareTelefon +
                ",Dimensiuni - " + this.dimensiuniTelefon +
                ",Model - " + this.model +
                ",Pret - " + this.pret +
                ",Dimensiunea cabinei - " + this.dimensiuneaCabinei;

        return mesaj;
    }
}
