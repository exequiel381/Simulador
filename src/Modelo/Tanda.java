/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author fiume
 */
public class Tanda {
    private int CantidadPotesVidrio;
    private int CantidadPotesCarton;
    private int CantidadPotesPlastico;
    private double Duracion;
    private boolean LecheCuajada;
    private String ProcesoDeteccion = "-";

    public Tanda() {
    }

    public int getCantidadPotesVidrio() {
        return CantidadPotesVidrio;
    }

    public void setCantidadPotesVidrio(int CantidadPotesVidrio) {
        this.CantidadPotesVidrio = CantidadPotesVidrio;
    }

    public int getCantidadPotesCarton() {
        return CantidadPotesCarton;
    }

    public void setCantidadPotesCarton(int CantidadPotesCarton) {
        this.CantidadPotesCarton = CantidadPotesCarton;
    }

    public int getCantidadPotesPlastico() {
        return CantidadPotesPlastico;
    }

    public void setCantidadPotesPlastico(int CantidadPotesPlastico) {
        this.CantidadPotesPlastico = CantidadPotesPlastico;
    }

    public double getDuracion() {
        return Duracion;
    }

    public void setDuracion(double Duracion) {
        this.Duracion = Duracion;
    }

    public boolean isLecheCuajada() {
        return LecheCuajada;
    }

    public void setLecheCuajada(boolean LecheCuajada) {
        this.LecheCuajada = LecheCuajada;
    }

    public String getProcesoDeteccion() {
        return ProcesoDeteccion;
    }

    public void setProcesoDeteccion(String ProcesoDeteccion) {
        this.ProcesoDeteccion = ProcesoDeteccion;
    }
    
    
}
