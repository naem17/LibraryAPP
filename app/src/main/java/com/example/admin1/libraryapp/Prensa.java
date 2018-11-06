package com.example.admin1.libraryapp;

public class Prensa extends Articulos {
    private String alcance;
    private String periodicidad;
    private boolean tipoPrensa; //True si es periodico
    private String contenido;

    public Prensa(Double precio, String nombre, String fecha, String editorial, String idioma, String genero, String alcance, String periodicidad, boolean tipoPrensa, String contenido) {
        super(precio, nombre, fecha, editorial, idioma, genero);
        this.alcance = alcance;
        this.periodicidad = periodicidad;
        this.tipoPrensa = tipoPrensa;
        this.contenido = contenido;
    }

    public String getAlcance() {
        return alcance;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public boolean isTipoPrensa() {
        return tipoPrensa;
    }

    public String getContenido() {
        return contenido;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public void setTipoPrensa(boolean tipoPrensa) {
        this.tipoPrensa = tipoPrensa;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
