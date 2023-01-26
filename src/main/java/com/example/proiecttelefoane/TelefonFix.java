package com.example.proiecttelefoane;

public class TelefonFix extends Telefon{
    private int razaDeActiune = 0;
    private String culoareTelefon = "nicio culoare";

    public TelefonFix(int razaDeActiune, String culoareTelefon) {
        this.razaDeActiune = razaDeActiune;
        this.culoareTelefon = culoareTelefon;
    }

    public TelefonFix(TelefonFix telefon) {
        this.pret = telefon.pret;
        this.model = telefon.model;
        this.sistemDeOperare = telefon.sistemDeOperare;
        this.razaDeActiune = telefon.razaDeActiune;
        this.culoareTelefon = telefon.culoareTelefon;
    }

    public TelefonFix() {
    }



    @Override
    void pretAbonament() {
        System.out.println("Pretul abonament pentru telefon fix");

    }

    @Override
    void incarcareBaterie() {
        System.out.println("Pretul abonament pentru telefon fix");

    }

    public int getRazaDeActiune() {
        return razaDeActiune;
    }

    public void setRazaDeActiune(int razaDeActiune) {
        this.razaDeActiune = razaDeActiune;
    }

    public String getCuloareTelefon() {
        return culoareTelefon;
    }

    public void setCuloareTelefon(String culoareTelefon) {
        this.culoareTelefon = culoareTelefon;
    }
    @Override
    public String toString(){
        String mesaj;
        mesaj = "Speciticaţii : " +
                "Culoarea - " + this.culoareTelefon +
                ",Sistem de operare - " + this.sistemDeOperare +
                ",Model - " + this.model +
                ",Pret - " + this.pret +
                ",Raza de actiune - " + this.razaDeActiune;

        return mesaj;
    }
}
