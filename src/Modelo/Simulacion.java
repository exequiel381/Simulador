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
public class Simulacion {

    private DistribucionesDeProbabilidad distribuciones = new DistribucionesDeProbabilidad();
    private ArrayList<Double> aleatorias;
    private Generador g;
    int posicionTablaAleatoria=0;
    
    int d;
    double TiempoMes;
    double TotalDDLMes;
    double GanaciaNeta;
    double GastoMensual;
    double GastosEmpresa;
    double GastoTotalMensual;
    double GanaciaMensual;

    int i;
    int TandasPorDia;
    double TandaCompleta;
    double TotalDDLDia;
    double TiempoDia;
    double GastoDia;
    double GanaciaDIa;

    int PotesPlastico;
    int PotesCarton;
    int PotesVidrio;
    double GastoPlastico;
    double GastoCarton;
    double GastoVidrio;
    double GastoPotes;
    double Perdida;
    double TiempoTotal;

    public Simulacion() {
       
        g = new Generador();
        aleatorias = g.GenerarNumerosAleatorio(100);
        
    }

    public void Simular() {
        
       
        posicionTablaAleatoria=0;
        
        d = 1;
        TiempoMes = 0;
        TotalDDLMes = 0;
        GanaciaNeta = 0;
        GastoMensual = 0;
        GastosEmpresa = 0;
        GastoTotalMensual = 0;
        GanaciaMensual = 0;

       

        while(d<=30){//dias
            
            i = 0;
            TandaCompleta = 0;
            TotalDDLDia = 0;
            TiempoDia = 0;
            GastoDia = 0;
            GanaciaDIa = 0;
            
            TandasPorDia = distribuciones.Uniforme(1,3);
            
            while(i<=TandasPorDia){
                
                i++;
            }
            
        }
    }
    
    public double ObtenerVariableAleatoria(){
        double u = aleatorias.get(posicionTablaAleatoria);
        posicionTablaAleatoria++;
        return u;
    }
    
}
