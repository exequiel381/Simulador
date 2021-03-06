package Modelo;

import java.text.DecimalFormat;
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
    
    //variables por mes
    double TiempoMes;
    double TotalDDLMes;
    double GananciaNeta;
    double GastoMensual;
    double GastosEmpresa;
    double GastoTotalMensual;
    double GanaciaMensual;

    //Variables por dia 
    int i;
    int TandasPorDia;
    double TandaCompleta;
    double TotalDDLDia;
    double TiempoDia;
    double GastoDia;
    double GananciaDia;

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
    
    //VARIABLES PARA LAS TANDAS
    double GanaciaPlasticoEnTanda;
    double GanaciaVidrioEnTanda;
    double GananciaCartonEnTanda;
    double DDLProducidoEnTanda;

    private DecimalFormat formato = new DecimalFormat("#.00");

    
    public Simulacion() {
       
        g = new Generador();
        aleatorias = g.GenerarNumerosAleatorio(1000000);
        ColeccionTandasPorDia = new ArrayList<>();
        DiasTrabajados = new ArrayList<>();
        
    }

    public String[] IniciarSimulacion(double costoMateriaPrima,double costoLeche ,double costoPoteVidrio ,double costoPotePlastico,double costoPoteCarton,double precioPoteVidrio,double precioPotePlastico,double precioPoteCarton) {
        
       
        posicionTablaAleatoria=0;
        //esto va ?

        d = 1;
        TiempoMes = 0;
        TotalDDLMes = 0;
        GananciaNeta = 0;
        GastoMensual = 0;
        GastosEmpresa = 0;
        GastoTotalMensual = 0;
        GanaciaMensual = 0;

       

        while(d<=30){//3
            
            ColeccionTandasPorDia = new ArrayList<>();//ESTO AVECES FALLA ASI QUE SI NO SE LIMPIA , LO IGUALAMOS A UN ARRAY VACIO // O LO INSTANCIAMOS AQUI ASI SEA UNO NUEVO
            //esto ahora anda
            i = 1;
            TandaCompleta = 0;
            TotalDDLDia = 0;
            TiempoDia = 0;
            GastoDia = 0;
            GananciaDia = 0;
            
            TandasPorDia = distribuciones.Uniforme(1,4,this.ObtenerVariableAleatoria());//Bien
           
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
                
                GanaciaPlasticoEnTanda = 0;
                GanaciaVidrioEnTanda = 0;
                GananciaCartonEnTanda = 0;
                DDLProducidoEnTanda = 0;
                
                if(this.ObtenerVariableAleatoria()<=0.95){      //BINOMIAL 1
                    TiempoCM = distribuciones.Normal(120,15);
                    if (this.ObtenerVariableAleatoria() <= 0.97) {      //BINOMIAL 2
                       TiempoEnf = distribuciones.Uniforme(25,30,this.ObtenerVariableAleatoria());
                        if (this.ObtenerVariableAleatoria() <= 0.99) {      //BINOMIAL 3
                            TiempoEnv = distribuciones.Exponencial(1, 60, this.ObtenerVariableAleatoria());
                            CantPotes = distribuciones.Uniforme(3375, 3565, this.ObtenerVariableAleatoria());
                            int ip=1;
                            while(ip<=CantPotes){ // 1 
                                double u1=this.ObtenerVariableAleatoria();
                                if(u1<=0.65){
                                    PotesPlastico++;
                                }else{
                                    if(u1>=0.65 && u1<=0.90){
                                        PotesCarton++;
                                    }else PotesVidrio++;
                                }
                                ip++;// vuelvo a 1
                            }
                            //Salida del while ip<=CantPotes RAGUEB
                            if (this.ObtenerVariableAleatoria()<=0.99){
                                DDLProducidoEnTanda= distribuciones.Uniforme(1350,1425,this.ObtenerVariableAleatoria());
                                TotalDDLDia=TotalDDLDia+DDLProducidoEnTanda;
                                TandaCompleta++;
                                TiempoTotal=TiempoCM+TiempoEnf+TiempoEnv;
                                TiempoDia=TiempoDia+TiempoTotal;
                                GastoPlastico=PotesPlastico*costoPotePlastico;
                                GastoCarton=PotesCarton*costoPoteCarton;
                                GastoVidrio=PotesVidrio*costoPoteVidrio;
                                GastoPotes=GastoPlastico+GastoCarton+GastoVidrio;
                                Perdida=costoMateriaPrima+costoLeche+GastoPotes;
                                GastoDia=GastoDia+Perdida;
                                GanaciaPlasticoEnTanda=PotesPlastico*precioPotePlastico;
                                GanaciaVidrioEnTanda=PotesVidrio*precioPoteVidrio;
                                GananciaCartonEnTanda=PotesCarton*precioPoteCarton;
                                GananciaDia= GananciaDia+GanaciaPlasticoEnTanda+GanaciaVidrioEnTanda+GananciaCartonEnTanda;
                                
                                ColeccionTandasPorDia.add(new Tanda(i,DDLProducidoEnTanda,TiempoTotal,PotesVidrio,PotesCarton,PotesPlastico,false,"-",Perdida));
                                
                                System.out.println("La leche esta en buen estado ");
                                System.out.println("Cantidad de potes de plastico producidos: "+PotesPlastico);
                                System.out.println("Cantidad de potes de carton producidos: "+PotesCarton);
                                System.out.println("Cantidad de potes de vidrio producidos: "+PotesVidrio);
                                System.out.println("Tiempo total de produccion: "+TiempoTotal);
                            }else{
                                GastoPlastico=PotesPlastico*costoPotePlastico;
                                GastoCarton=PotesCarton*costoPoteCarton;
                                GastoVidrio=PotesVidrio*costoPoteVidrio;
                                GastoPotes=GastoPlastico+GastoCarton+GastoVidrio;
                                Perdida=costoMateriaPrima+costoLeche+GastoPotes;
                                TiempoTotal=TiempoCM+TiempoEnf+TiempoEnv;
                                TiempoDia=TiempoDia+TiempoTotal;
                                
                                ColeccionTandasPorDia.add(new Tanda(i,0,TiempoTotal,PotesVidrio,PotesCarton,PotesPlastico,true,"ENVASADO",Perdida));
                                
                                System.out.println("La leche est?? cuajada\n"
                                    + "Se la detect?? en el proceso de Envasado\n"
                                    + "Tiempo perdido: "+TiempoTotal);
                                System.out.println("Cantidad de potes de plastico desperdiciados: "+PotesPlastico);
                                System.out.println("Cantidad de potes de carton desperdiciados: "+PotesCarton);
                                System.out.println("Cantidad de potes de vidrio desperdiciados: "+PotesVidrio);
                                GastoDia=GastoDia+Perdida;
                            }//agregue hasta aca la salida del while de ip<=CantidadPotes RAGUEB
                        }else{
                            Perdida = costoMateriaPrima + costoLeche;
                            GastoDia = GastoDia + Perdida;
                            TiempoTotal = TiempoCM + TiempoEnf;
                            TiempoDia = TiempoDia + TiempoTotal;
                            //AQUI YA DEBERIAMOS INSTANCIAR UNA TANDA CON LECHE CUAJADA 
                            
                            ColeccionTandasPorDia.add(new Tanda(i,0,TiempoTotal,0,0,0,true,"ENFRIAMIENTO",Perdida));
                            
                            System.out.println("La leche est?? cuajada\n"
                                    + "Se la detect?? en el proceso de Enfriamiento\n"
                                    + "Tiempo perdido: "+TiempoTotal);
                        }
                        
                    }else{
                        Perdida = costoMateriaPrima + costoLeche;
                        GastoDia = GastoDia + Perdida;
                        TiempoDia = TiempoDia + TiempoCM;
                        //AQUI YA DEBERIAMOS INSTANCIAR UNA TANDA CON LECHE CUAJADA 
                        ColeccionTandasPorDia.add(new Tanda(i,0,TiempoCM,0,0,0,true,"COCCION Y MEZCLA",Perdida));
                        System.out.println("La leche est?? cuajada\n"
                                + "Se la detect?? en el proceso de Cocci??n y Mezclado\n"
                                + "Tiempo de cocci??n: "+TiempoCM);
                    }
                    
                    
                } else {
                    Perdida = costoLeche;
                    GastoDia += Perdida;//AQUI YA DEBERIAMOS INSTANCIAR UNA TANDA CON LECHE CUAJADA Y SU PRODUCCION 0
                    
                    ColeccionTandasPorDia.add(new Tanda(i,0,0,0,0,0,true,"RECEPCION",Perdida));
                    
                    System.out.println("La leche est?? cuajada\n"
                            + "Se la detect?? en el proceso de Recepci??n de Ingredientes");
                }
                //SI TODO SALE BIEN, INSTANCIAMOS UNA TANDA Y LA AGREGAMOS A LA COLECCION DE TANDAS,LUEGO CREAMOS UN DIA CON ESA COLECCION Y LIMPIAMOS  AL INGRESAR POR DIA
                
                i++; // vuelvo a 2
            }
            
            //Salida del while de tandas RAGUEB
            System.out.println("Se completaron las tandas del dia");//consultar esto
            System.out.println("El total de dulce de leche producido en el dia fue de: "+TotalDDLDia);
            System.out.println("El tiempo de produccion del dia fue de : "+TiempoDia);
            System.out.println("La ganancia del dia de hoy fue de: "+GananciaDia +"\n" +"\n"+ "\n");
            int cantidadTandas = ColeccionTandasPorDia.size();
            
            DiasTrabajados.add(new DiaDeTrabajo(d,ColeccionTandasPorDia,GananciaDia,TiempoDia,TotalDDLDia,cantidadTandas));
            
            
            
            TiempoMes=TiempoMes+TiempoDia;
            TotalDDLMes=TotalDDLMes+TotalDDLDia;
            GastoMensual=GastoMensual+GastoDia;
            GanaciaMensual=GanaciaMensual+GananciaDia;
            d++;
            //Hastta aca salida del while de tandas RAGUEB
        }
       //Salida del while de d<=30 RAGUEB
       GastosEmpresa = distribuciones.Normal(2200000,150000);
       GastoTotalMensual=GastosEmpresa+GastoMensual;
       GananciaNeta=GanaciaMensual-GastoTotalMensual;
       
       
       
       System.out.println("La ganancia neta del mes fue de: "+GananciaNeta);
       System.out.println("El tiempo total de produccion de leche del mes fue de: "+TiempoMes);
       System.out.println("El total de dulce de leche producido en el mes fue de: "+TotalDDLMes);
       //Hasta aca salida del while de d<=30 Ragueb
       
       
       String retorno[]= {"$"+formato.format(GananciaNeta), ""+formato.format(TiempoMes/60)+" hs", ""+formato.format(TotalDDLMes)+" Kg"};
       return retorno;
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

    

    public double getGananciaNeta() {
        return GananciaNeta;
    }

    public void setGananciaNeta(double GanaciaNeta) {
        this.GananciaNeta = GanaciaNeta;
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
/*
    ERRORES
    1) Hace mas de carton que de plastico
    2) Hace mas potes que la media 
*/