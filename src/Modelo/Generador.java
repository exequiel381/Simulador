/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fiume
 */
public class Generador {

    public Generador() {
    }
    //POR CONGRUENCIAL MULTIPLICATIVO
    public ArrayList<Double> GenerarNumerosAleatorio(int iteraciones){//podemos enviarle por parametro los numeros o calcularlos aqui
        ArrayList<Double> conjunto = new ArrayList<>();
        double numero;
       
        //Sobreescribo o creo numeros ramdon
        
        Random r = new Random();
        int a = r.nextInt(10000);
        int inicial = r.nextInt(10000);
        int m = r.nextInt(10000);
        
        
        for(int i=0;i<iteraciones;i++){
            
            numero = (a*inicial) % m;
            conjunto.add(numero/m);
            inicial = (a*inicial) % m;
            
        }
        
       return conjunto;
    }
    
    
}
