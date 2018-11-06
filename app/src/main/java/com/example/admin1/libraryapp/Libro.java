package com.example.admin1.libraryapp;

public class Libro extends Articulos {
    private String autor;
    private boolean tipotapa; //True si es dura
    private String tipoLibro;

    public Libro(Double precio, String nombre, String fecha, String editorial, String idioma, String genero, String autor, boolean tipotapa, String tipoLibro) {
        super(precio, nombre, fecha, editorial, idioma, genero);
        this.autor = autor;
        this.tipotapa = tipotapa;
        this.tipoLibro = tipoLibro;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isTipotapa() {
        return tipotapa;
    }

    public String getTipoLibro() {
        return tipoLibro;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTipotapa(boolean tipotapa) {
        this.tipotapa = tipotapa;
    }

    public void setTipoLibro(String tipoLibro) {
        this.tipoLibro = tipoLibro;
    }
}
