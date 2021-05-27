/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;


import Controlador.Controlador;
import Modelo.DistribucionesDeProbabilidad;
import Modelo.Generador;
import Vistas.primera;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fiume
 */
public class Simulador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
     //Controlador controlador = new Controlador();
     
        DistribucionesDeProbabilidad d = new DistribucionesDeProbabilidad();
        int i=0;
        while(i<30){
            System.out.println(d.getPoisson(3.0));
            i++;
        }
        
        
     
        
     
     
     
        //Si quiero el primer elemnto
        //System.out.println(g.GenerarNumerosAleatorio(5631,1317,547,1).get(0));
     
     
     
     
      
    }
    
}
