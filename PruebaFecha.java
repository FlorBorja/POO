
package poo;
import cstio.*;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PruebaFecha {
    Pizarra p=new Pizarra();
    Dialog d= new Dialog();
    
    String fecha,num,total;
    int cuenta=0;
    
    Fecha f[]= new Fecha[100];
    Fecha po[]=new Fecha[100];
    SimpleDateFormat sdf = new SimpleDateFormat(
        "dd/MM/yyyy");
    Date fechaDate = new Date();
    String fe=sdf.format(fechaDate);
    
    public Date sumarRestarDiasFecha(){
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(fecha);
    }
    
    void meta() {
        String aux="Fecha:\n";
        p.out(aux);
        p.setVisible(true);
        String a="\na)Capturar fechas en un arreglo de apunutadores";
        a +=" a objetos con el formato dd/mm/yyyy y sugerir la";
        a +=" fecha de hoy como omisión. Si el usuario da enter";
        a +=" aceptela fecha actual de otro modo valide la fecha";
        a +=" tecleada y acéptelas si es válida terminando la";
        a +=" captura usando un dato centinela.";
        a +="\nb)Para cada par de fechas consecutivas en el arreglo";
        a +=" determine la distancia en años, meses  y días entre ellas.";
        a +="\nc)Capture un número entero que represente un número de";
        a +=" días posterior a cada fecha y con el determine en otro";
        a +=" arreglo de fecha un conjunto igual a la fecha posterior";
        a +=" transcurrido ese número de días.";
        a +="\nd)Calcule y despliegue el tiempo que se ejecuta la aplicación\n";
        p.out(a);
    }//meta

    boolean isNum(String cad){
        try{
            Integer.parseInt(cad);
            return true;
        } catch (NumberFormatException nfe){
            d.display("Solo se aceptan valores numéricos");
            return false;
        }
    }//boolean

    
    void showA(){        
        String a3="Capture su fecha con formato dd/mm/yyyy, enter";
        a3 +="\npara capturar la fecha actual ";
        do fecha=d.readString(a3+fe+" o \"fin\": ");
        while(fecha.length()==0);
        while(!fecha.equals("fin")&& cuenta<100){         
        f[cuenta]=new Fecha();
            if(fecha.equals("a")){
                f[cuenta].setFecha(fe);
                cuenta=cuenta+1;
                fecha=d.readString(a3+fe+" o \"fin\": ");
            }//if
            else{
                f[cuenta].setFecha(fecha);
                cuenta=cuenta+1;
                fecha=d.readString(a3+fe+" o \"fin\": ");  
            }//else 
        }//while
    }//showA
    
    void showB(){
        
    }//showB
    
    void showC(){
        String a4="Ingrese un número entero para calcular fechas";
        a4 +=" posterias a las que fueron ingresadas anteriormente: ";
        num=d.readString(a4);
    }//showC

    void showD(){
        
    }//showD
    
    void showCalculoC(){
        for(int i=0; i<cuenta;i++){
            total=(f[i].getFecha()+num);
            po[i].setFecha(total);
        }//for
    }//showCalculoC
    void resultados(){
        p.out("\nFechas Capturadas:");
        p.out("\n___________________\n");
        for(int i=0; i<cuenta; i++){
            p.out(f[i].getFecha());
            p.out("\n");
        }
        p.out("\nFechas Posteriores:");
        p.out("\n___________________\n");
        for(int i=0; i<cuenta; i++){
            p.out(po[i].getFecha());
            p.out("\n");
        }
        
    }//resultados
    
    public static void main(String args[]){ 
        PruebaFecha pm=new PruebaFecha();
        pm.meta();
        pm.showA();
        pm.resultados();
    }//main
    
}//class
