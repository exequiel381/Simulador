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
    private boolean LecheCuajada=false;
    private String ProcesoDeteccion = "-";
    private double DDLProducidoEnTanda = 0;
    private double TiempoTotal = 0;
    private double  CostoTanda=0;
    private double Perdida=0;
    private int Numero=0;

    public Tanda(int Numero,double DDLProducidoEnTanda,double TiempoTotal,int CantidadPotesVidrio,int CantidadPotesCarton,int CantidadPotesPlastico,boolean LecheCuajada,String ProcesoDeteccion,double CostoTanda) {
        this.CantidadPotesCarton= CantidadPotesCarton;
        this.CantidadPotesPlastico = CantidadPotesPlastico;
        this.CantidadPotesVidrio = CantidadPotesVidrio;
        this.DDLProducidoEnTanda = DDLProducidoEnTanda;
        this.TiempoTotal =TiempoTotal;
        this.LecheCuajada = LecheCuajada;
        this.ProcesoDeteccion = ProcesoDeteccion;
        this.CostoTanda = CostoTanda;
        this.Numero=Numero;
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


    public String getEstadoLeche(){
        if(LecheCuajada==true){
            return "SI";
        }else return "NO";
    }
    
    public boolean LecheCuajada() {
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

    public double getCostoTanda() {
        return CostoTanda;
    }

    public void setCostoTanda(double CostoTanda) {
        this.CostoTanda = CostoTanda;
    }

    public double getPerdida() {
        return Perdida;
    }

    public void setPerdida(double Perdida) {
        this.Perdida = Perdida;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }
    
    
}
