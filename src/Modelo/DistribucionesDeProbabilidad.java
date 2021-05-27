/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author fiume
 */
public class DistribucionesDeProbabilidad {
    
    private Generador g;
    
    public DistribucionesDeProbabilidad(){
        g = new Generador();
    }
    
    public int Uniforme(int a,int b){
        double u = g.GenerarNumerosAleatorio(1).get(0);
        double valor = a + (b-a)*u;
        return (int)valor;
    }
    
    public double Normal(double media,double desviacion){
        Random r = new Random();
        return r.nextGaussian()*desviacion+media;
    }
    
     public double Exponencial(double cantidad,double tiempo){
        double u = g.GenerarNumerosAleatorio(1).get(0);
        double  a = cantidad/tiempo;
        double E = 1/a;
        
        return -E*Math.log(u);
    }
     
   
     
    public int getPoisson(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;
        do {
            k++;
            p *= Math.random();
        } while (p > L);
        return k - 1;
    }
}
