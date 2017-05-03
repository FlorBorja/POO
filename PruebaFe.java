
package poo;
import cstio.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
        
public class PruebaFe {
    
    Pizarra p=new Pizarra();
    Dialog d= new Dialog();
    Calendar fe=new GregorianCalendar(); 
    int año= fe.get(Calendar.YEAR);
    int mes= fe.get(Calendar.MONTH);
    int dia=fe.get(Calendar.DAY_OF_MONTH);
    Calendar cal = Calendar.getInstance();
    
    Date convertido;
    
    String fecha,num,cadena;
    String fa = dia+"/"+(mes+1)+"/"+año;
    Fecha f[] = new Fecha[100];
    Fecha k[] = new Fecha[100];
    int cuenta=0, n;
    
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
        String a3="Capture su fecha con formato dd/mm/yyyy, o enter";
        a3 +="\npara capturar la fecha actual ";
        do fecha=d.readString(a3+fa+" o \"fin\": ");
        while(fecha.length()==0);
        while(!fecha.equals("fin")&& cuenta<100){         
        f[cuenta]=new Fecha();
            if(fecha.equals("a")){
                f[cuenta].setFecha(fa);
                cuenta=cuenta+1;
                fecha=d.readString(a3+fa+" o \"fin\": ");
            }//if
            else{
                f[cuenta].setFecha(fecha);
                cuenta=cuenta+1;
                fecha=d.readString(a3+fa+" o \"fin\": ");  
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
        
    void showCalculoC()throws IOException{
        n = Integer.parseInt(num);
            for(int i=0; i<cuenta;i++){
             String con= f[i].getFecha();
                try{
                    DateFormat k = new SimpleDateFormat("dd/MM/yyyy");
                    convertido = k.parse(con);
                    }catch(ParseException e){
                
                    }
            Date nuevaFecha = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(convertido);
            calendar.add(Calendar.DATE,n);
            nuevaFecha = calendar.getTime();
            cadena=nuevaFecha.toString(); 
            
            
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
                p.out(cadena);
                p.out("\n");
            }
    }//resultados
        
    public static void main(String args[]){ 
        PruebaFe pm = new PruebaFe();
        pm.meta();
        pm.showA();
        pm.showC();
        pm.resultados();
    }//main
        
}//class PruebaFe
