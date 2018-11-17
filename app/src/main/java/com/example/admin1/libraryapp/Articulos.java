package com.example.admin1.libraryapp;

public class Articulos {
    private Double precio;
    private String nombre;
    private String fecha;
    private String editorial;
    private String idioma;
    private String genero;
    private static Integer unidadesEnStock;
    private static Integer unidadesEnCompra;
    private boolean enListaCompra;


    public Articulos( Double precio, String nombre, String fecha, String editorial, String idioma, String genero) {

        this.precio = precio;
        this.nombre = nombre;
        this.fecha = fecha;
        this.editorial = editorial;
        this.idioma = idioma;
        this.genero = genero;
        this.enListaCompra = false;
    }


    public Double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isEnListaCompra() {
        return enListaCompra;
    }

    public static Integer getUnidadesEnStock() {
        return unidadesEnStock;
    }

    public static Integer getUnidadesEnCompra() {
        return unidadesEnCompra;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setEnListaCompra(boolean enListaCompra) {
        this.enListaCompra = enListaCompra;
    }

}
