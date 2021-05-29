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
    private ArrayList<Tanda> ColeccionTandasPorDia;
    private ArrayList<DiaDeTrabajo> DiasTrabajados;

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
    
    double TiempoCM;
    double TiempoEnf;
    double TiempoEnv;
    int CantPotes;


    
    public Simulacion() {
       
        g = new Generador();
        aleatorias = g.GenerarNumerosAleatorio(200);
        ColeccionTandasPorDia = new ArrayList<>();
        DiasTrabajados = new ArrayList<>();
        
    }

    public void IniciarSimulacion(double costoMateriaPrima,double costoLeche ,double costoPoteVidrio ,double costoPotePlastico,double costoPoteCarton,double precioPoteVidrio,double precioPotePlastico,double precioPoteCarton) {
        
       
        posicionTablaAleatoria=0;
        
        d = 1;
        TiempoMes = 0;
        TotalDDLMes = 0;
        GanaciaNeta = 0;
        GastoMensual = 0;
        GastosEmpresa = 0;
        GastoTotalMensual = 0;
        GanaciaMensual = 0;

       

        while(d<=30){//3
            
            ColeccionTandasPorDia.clear();//ESTO AVECES FALLA ASI QUE SI NO SE LIMPIA , LO IGUALAMOS A UN ARRAY VACIO // O LO INSTANCIAMOS AQUI ASI SEA UNO NUEVO
            
            i = 0;
            TandaCompleta = 0;
            TotalDDLDia = 0;
            TiempoDia = 0;
            GastoDia = 0;
            GanaciaDIa = 0;
            
            TandasPorDia = distribuciones.Uniforme(1,3,this.ObtenerVariableAleatoria());
            
            while(i<=TandasPorDia){ // 2
                
                PotesPlastico = 0;
                PotesCarton = 0;
                PotesVidrio = 0;
                GastoPlastico = 0;
                GastoCarton = 0;
                GastoVidrio = 0;
                GastoPotes = 0;
                Perdida = 0;
                TiempoTotal = 0;
                
                if(this.ObtenerVariableAleatoria()<=0.95){      //BINOMIAL 1
                    TiempoCM = distribuciones.Normal(120,15);
                    if (this.ObtenerVariableAleatoria() <= 0.97) {      //BINOMIAL 2
                       TiempoEnf = distribuciones.Uniforme(25,30,this.ObtenerVariableAleatoria());
                        if (this.ObtenerVariableAleatoria() <= 0.99) {      //BINOMIAL 3
                            TiempoEnv = distribuciones.Exponencial(1, 60, this.ObtenerVariableAleatoria());
                            CantPotes = distribuciones.Uniforme(3375, 3565, this.ObtenerVariableAleatoria());
                            int ip=1;
                            while(ip<=CantPotes){ // 1
                                if(this.ObtenerVariableAleatoria()<=0.65){
                                    PotesPlastico++;
                                }
                                if(this.ObtenerVariableAleatoria()<=0.9){
                                    PotesCarton++;
                                }else PotesVidrio++;
                                
                                ip++;// vuelvo a 1
                            }
                        }else{
                            Perdida = costoMateriaPrima + costoLeche;
                            GastoDia = GastoDia + Perdida;
                            TiempoTotal = TiempoCM + TiempoEnf;
                            TiempoDia = TiempoDia + TiempoTotal;
                            //AQUI YA DEBERIAMOS INSTANCIAR UNA TANDA CON LECHE CUAJADA 
                            System.out.println("La leche está cuajada\n"
                                    + "Se la detectó en el proceso de Enfriamiento\n"
                                    + "Tiempo perdido: "+TiempoTotal);
                        }
                        
                    }else{
                        Perdida = costoMateriaPrima + costoLeche;
                        GastoDia = GastoDia + Perdida;
                        TiempoDia = TiempoDia + TiempoCM;
                        //AQUI YA DEBERIAMOS INSTANCIAR UNA TANDA CON LECHE CUAJADA 
                        System.out.println("La leche está cuajada\n"
                                + "Se la detectó en el proceso de Cocción y Mezclado\n"
                                + "Tiempo de cocción: "+TiempoCM);
                    }
                    
                    
                } else {
                    Perdida = costoLeche;
                    GastoDia += Perdida;//AQUI YA DEBERIAMOS INSTANCIAR UNA TANDA CON LECHE CUAJADA Y SU PRODUCCION 0
                    System.out.println("La leche está cuajada\n"
                            + "Se la detectó en el proceso de Recepción de Ingredientes");
                }
                //SI TODO SALE BIEN, INSTANCIAMOS UNA TANDA Y LA AGREGAMOS A LA COLECCION DE TANDAS,LUEGO CREAMOS UN DIA CON ESA COLECCION Y LIMPIAMOS  AL INGRESAR POR DIA
                i++; // vuelvo a 2
            }
            
        }
    }
    
    public double ObtenerVariableAleatoria(){
        double u = aleatorias.get(posicionTablaAleatoria);
        posicionTablaAleatoria++;
        return u;
    }
    
     public ArrayList<DiaDeTrabajo> getDiasTrabajados() {
        return DiasTrabajados;
    }

    public void setDiasTrabajados(ArrayList<DiaDeTrabajo> DiasTrabajados) {
        this.DiasTrabajados = DiasTrabajados;
    }

    

    public double getGanaciaNeta() {
        return GanaciaNeta;
    }

    public void setGanaciaNeta(double GanaciaNeta) {
        this.GanaciaNeta = GanaciaNeta;
    }

    public double getGastoMensual() {
        return GastoMensual;
    }

    public void setGastoMensual(double GastoMensual) {
        this.GastoMensual = GastoMensual;
    }

    public double getGastosEmpresa() {
        return GastosEmpresa;
    }

    public void setGastosEmpresa(double GastosEmpresa) {
        this.GastosEmpresa = GastosEmpresa;
    }

    public double getGastoTotalMensual() {
        return GastoTotalMensual;
    }

    public void setGastoTotalMensual(double GastoTotalMensual) {
        this.GastoTotalMensual = GastoTotalMensual;
    }

    public double getGanaciaMensual() {
        return GanaciaMensual;
    }

    public void setGanaciaMensual(double GanaciaMensual) {
        this.GanaciaMensual = GanaciaMensual;
    }

    public double getTotalDDLMes() {
        return TotalDDLMes;
    }

    public void setTotalDDLMes(double TotalDDLMes) {
        this.TotalDDLMes = TotalDDLMes;
    }

    public double getTiempoMes() {
        return TiempoMes;
    }

    public void setTiempoMes(double TiempoMes) {
        this.TiempoMes = TiempoMes;
    }
    
    
    
    
    
    
}
