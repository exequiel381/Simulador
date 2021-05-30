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
    private int CantidadPotesVidrio=0;
    private int CantidadPotesCarton=0;
    private int CantidadPotesPlastico=0;
    private double Duracion=0;
    private boolean LecheCuajada=false;
    private String ProcesoDeteccion = "-";
    private double DDLProducidoEnTanda = 0;
    private double TiempoTotal = 0;
    private double  CostoTanda=0;
    private double Perdida=0;

    public Tanda(double DDLProducidoEnTanda,double TiempoTotal,int CantidadPotesVidrio,int CantidadPotesCarton,int CantidadPotesPlastico,boolean LecheCuajada,String ProcesoDeteccion,double CostoTanda) {
        this.CantidadPotesCarton= CantidadPotesCarton;
        this.CantidadPotesPlastico = CantidadPotesPlastico;
        this.CantidadPotesVidrio = CantidadPotesVidrio;
        this.DDLProducidoEnTanda = DDLProducidoEnTanda;
        this.TiempoTotal =TiempoTotal;
        this.LecheCuajada = LecheCuajada;
        this.ProcesoDeteccion = ProcesoDeteccion;
        this.CostoTanda = CostoTanda;
    }

    public double getDDLProducidoEnTanda() {
        return DDLProducidoEnTanda;
    }

    public void setDDLProducidoEnTanda(double DDLProducidoEnTanda) {
        this.DDLProducidoEnTanda = DDLProducidoEnTanda;
    }

    public double getTiempoTotal() {
        return TiempoTotal;
    }

    public void setTiempoTotal(double TiempoTotal) {
        this.TiempoTotal = TiempoTotal;
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
