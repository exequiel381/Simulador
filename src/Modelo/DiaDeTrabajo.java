/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author fiume
 */
public class DiaDeTrabajo {
    
    private ArrayList<Tanda> tandasDelDia;
    private double Ganancia;
    private double Tiempo;
    private double TotalDDLDia;
    private int Numero;
    private int cantidadTandas;

    public DiaDeTrabajo(int Numero,ArrayList<Tanda> tandasDelDia, double Ganancia, double Tiempo, double TotalDDLDia,int cantidadTandas) {
        this.tandasDelDia = tandasDelDia;
        this.Ganancia = Ganancia;
        this.Tiempo = Tiempo;
        this.TotalDDLDia = TotalDDLDia;
        this.Numero=Numero;
        this.cantidadTandas=cantidadTandas;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }
    
    

    public ArrayList<Tanda> getTandasDelDia() {
        return tandasDelDia;
    }

    public void setTandasDelDia(ArrayList<Tanda> tandasDelDia) {
        this.tandasDelDia = tandasDelDia;
    }
    
    public DiaDeTrabajo(ArrayList<Tanda> tandasDelDia ){
        
        this.tandasDelDia = tandasDelDia;
        
    }
    
    public int getCantidadTandas(){
        return tandasDelDia.size();
    }

    public double getGanancia() {
        return Ganancia;
    }

    public void setGanancia(double Ganancia) {
        this.Ganancia = Ganancia;
    }

    public double getTiempo() {
        return Tiempo;
    }

    public void setTiempo(double Tiempo) {
        this.Tiempo = Tiempo;
    }

    public double getTotalDDLDia() {
        return TotalDDLDia;
    }

    public void setTotalDDLDia(double TotalDDLDia) {
        this.TotalDDLDia = TotalDDLDia;
    }
    
    
}
