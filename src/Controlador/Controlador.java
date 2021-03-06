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
    
    private int diaCon1Tanda=0;
    private int diaCon2Tanda=0;
    private int diaCon3Tanda=0;
    private int diaCon4Tanda=0;
    
    
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
                CMP = Double.parseDouble(_ingresoDatos.txtCMP.getText());//Convierto todos los txt que recibo
                CL = Double.parseDouble(_ingresoDatos.txtCL.getText());
                CPV = Double.parseDouble(_ingresoDatos.txtCPV.getText());
                CPC = Double.parseDouble(_ingresoDatos.txtCPC.getText());
                CPP = Double.parseDouble(_ingresoDatos.txtCPP.getText());
                PV = Double.parseDouble(_ingresoDatos.txtPV.getText());
                PC = Double.parseDouble(_ingresoDatos.txtPC.getText());
                PP = Double.parseDouble(_ingresoDatos.txtPP.getText());
                
                String retornoDatosDelMes[]= s.IniciarSimulacion(CMP, CL, CPV, CPP, CPC, PV, PP, PC);
              
                resultados = new Resultados();
                resultados.setControlador(this);
                diasDeTrabajo = s.getDiasTrabajados();
                this.RellenarTablaDias();
                _ingresoDatos.setVisible(false);
                resultados.ArmarGraficoBarras(diasDeTrabajo);
                
                this.ContarDiasPorTanda();
                
                resultados.ArmarGraficoTorta(diaCon1Tanda,diaCon2Tanda,diaCon3Tanda,diaCon4Tanda);
                resultados.setVisible(true);
                
                resultados.jLabel1.setText(retornoDatosDelMes[0]);
                resultados.jLabel2.setText(retornoDatosDelMes[1]);
                resultados.jLabel7.setText(retornoDatosDelMes[2]);
                
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
    
    public void ContarDiasPorTanda(){
        for(DiaDeTrabajo t : diasDeTrabajo ){
            if(t.getCantidadTandas()==1){
                diaCon1Tanda++;
            }
             if(t.getCantidadTandas()==2){
                diaCon2Tanda++;
            }
             if(t.getCantidadTandas()==3){
                diaCon3Tanda++;
            }
             if(t.getCantidadTandas()==4){
                diaCon4Tanda++;
            }
            
        }
    }
    
    
}
