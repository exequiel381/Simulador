/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DiaDeTrabajo;
import Modelo.Simulacion;
import Modelo.Tanda;
import Vistas.IngresoDeDatos;
import Vistas.Resultados;
import Vistas.primera;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fiume
 */
public class Controlador implements ActionListener {
    
    private primera _primeraVista;
    private IngresoDeDatos _ingresoDatos;
    private Resultados resultados ;
    private ArrayList<DiaDeTrabajo> diasDeTrabajo;
    private DecimalFormat formato = new DecimalFormat("#.00");
    
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
            _primeraVista.setVisible(false);
            _ingresoDatos.setVisible(true);
        }
        if (e.getActionCommand().equals(_ingresoDatos.SIMULAR)) {
            Simulacion s = new Simulacion();
            
            double CMP=0;
            double CL=0;
            double CPV=0;
            double CPC=0;
            double CPP=0;
            double PV=0;
            double PC=0;
            double PP=0;

            try {
                CMP = Double.parseDouble("69270");//Convierto todos los txt que recibo
                CL = Double.parseDouble("56000");
                CPV = Double.parseDouble("34");
                CPC = Double.parseDouble("30");
                CPP = Double.parseDouble("12");
                PV = Double.parseDouble("90");
                PC = Double.parseDouble("85");
                PP = Double.parseDouble("70");
                
                s.IniciarSimulacion(CMP, CL, CPV, CPP, CPC, PV, PP, PC);
                
                resultados = new Resultados();
                resultados.setControlador(this);
                diasDeTrabajo = s.getDiasTrabajados();
                this.RellenarTablaDias();
                _ingresoDatos.setVisible(false);
                resultados.ArmarGraficoBarras(diasDeTrabajo);
                resultados.ArmarGraficoTorta();
                resultados.setVisible(true);
                
            }catch(Exception q){
                JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS DEBEN TENER UN VALOR NUMERICO");
                System.out.println(q);
            }
           
        }
        
        if (e.getActionCommand().equals(resultados.VERTANDAS)){
            int diaSeleccionado = Integer.parseInt(resultados.seleccionarFila());
            DiaDeTrabajo dia = new DiaDeTrabajo();
            
            for(DiaDeTrabajo d : diasDeTrabajo){
                if(d.getNumero()==diaSeleccionado) dia = d;
            }
            
            this.RellenarTablaTandas(dia);
        }
        
        if (e.getActionCommand().equals(resultados.RESIMULAR)){
           resultados.setVisible(false);
           _primeraVista.setVisible(false);
           _ingresoDatos.setVisible(true);
        }
        
    }
    
    
    
    public void RellenarTablaDias() {
      
        ArrayList<String[]> lista = new ArrayList<String[]>();
        for (DiaDeTrabajo dt : diasDeTrabajo) {
            String linea[] = new String[5];
            linea[0] = ""+dt.getNumero();
            linea[1] = ""+dt.getCantidadTandas();
            linea[2] = ""+dt.getTotalDDLDia();
            linea[3] = ""+dt.getGanancia();
            linea[4] = "" +formato.format(dt.getTiempo());
            lista.add(linea);
            
           
            
            
        }
        resultados.cargarListaDias(lista);
       
    }
    
    
    public void RellenarTablaTandas(DiaDeTrabajo d) {
      
        ArrayList<String[]> lista = new ArrayList<String[]>();
        for (Tanda t : d.getTandasDelDia()) {
            String linea[] = new String[7];
            linea[0] = ""+t.getNumero();
            linea[1] = ""+t.getCantidadPotesVidrio();
            linea[2] = ""+t.getCantidadPotesCarton();
            linea[3] = ""+t.getCantidadPotesPlastico();
            linea[4] = ""+t.getEstadoLeche();
            linea[5] = ""+t.getProcesoDeteccion();
            linea[6] = "" +formato.format(t.getTiempoTotal());
            lista.add(linea);
            
           
            
            
        }
        resultados.cargarListaTandas(lista);
       
    }
    
    
}
