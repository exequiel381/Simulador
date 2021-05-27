/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.IngresoDeDatos;
import Vistas.primera;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author fiume
 */
public class Controlador implements ActionListener {
    
    private primera _primeraVista;
    private IngresoDeDatos _ingresoDatos;
    
    public Controlador(){
        _primeraVista = new primera();
        _primeraVista.setControlador(this);
        _primeraVista.setVisible(true);
        
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(_primeraVista.INICIAR)) {
           _ingresoDatos=new IngresoDeDatos();
            _ingresoDatos.setControlador(this);
            _ingresoDatos.setVisible(true);
        }
        if (e.getActionCommand().equals(_ingresoDatos.SIMULAR)) {
            System.out.println("AQUI SIMULAMOS");
        }
        
    }
    
    
}
