package com.example.proiecttelefoane;

abstract class Telefon{
    public Object name;
    protected int pret = 0;
    protected String model = "fara model";
    protected int calitateFoto = 0;
    protected String sistemDeOperare = "inexistent";
    abstract void pretAbonament();
    abstract void incarcareBaterie();
}