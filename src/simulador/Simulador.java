/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;


import Controlador.Controlador;
import Modelo.DistribucionesDeProbabilidad;
import Modelo.Generador;
import Modelo.Simulacion;
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
     
        Simulacion s = new Simulacion();
        s.IniciarSimulacion(69270.0,56000.0,34.0,12.0,30.0,90.0,75.0,80.0);
    }
    
}
