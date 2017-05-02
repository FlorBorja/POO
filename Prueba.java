package poo;

import cstio.Dialog;
import cstio.Pizarra;

import java.io.File;
import java.io.IOException;

/**
 * Created by monsh on 22/03/2017.
 */
public class Prueba {
    Pizarra p = new Pizarra();
    Dialog d = new Dialog();
    Prueba t = new Prueba();
    
    
    
    File file = new File("C://prueba.txt");
    int opc, o, res;

    void datos() {
        p.setVisible(true);
        p.out("Escribe el nombre del archivo: " + file);

    }//datos

    //calculos
    void ShowString() throws IOException {

        file.getAbsolutePath();
        file.getCanonicalPath();
        file.getName();
        file.getParentFile();
        file.getPath();
        file.getParent();
    }

    void Mutativos() throws IOException {

        file.createNewFile();
        file.delete();
        file.mkdir();
        file.mkdirs();
        file.renameTo(file);
        file.setReadable(true);
        file.setExecutable(true);
        file.setExecutable(true, true);
        file.setLastModified(opc);
        file.setReadable(true, true);
        file.setReadOnly();
        file.setWritable(true);
        file.setWritable(true, true);
    }

    void Predicados() {
        file.canExecute();
        file.canRead();
        file.canWrite();
        file.isAbsolute();
        file.exists();
        file.isDirectory();
        file.isFile();
        file.isHidden();
        file.equals(opc);
    }

    void ShowFile() throws IOException {
        file.getAbsoluteFile();
        file.getCanonicalFile();
        file.getParentFile();
    }

    void ShowLong() {
        file.getTotalSpace();
        file.getFreeSpace();
        file.getUsableSpace();
        file.lastModified();
        file.length();
    }

    void ShowInt() {
        file.compareTo(file);
        file.hashCode();
    }

    void ShowMiscelaneos() {
        file.list();
        file.listFiles();
    }

    void resultados() throws IOException {
        do {
            p.setVisible(true);
            opc = Integer.parseInt(d.readString("¿Que deseas hacer "
                    + "con el archivo? \n1.-ShowString \n2.-ShowBoolean"
                    + " \n3.-ShowFile \n4.-ShiwLong \n5.-ShowInt "
                    + "\n6.-ShowMiscelaneos"));
            switch (opc) {
                case 1:
                    t.ShowString();
                    break;
                case 2:
                    o = Integer.parseInt(d.readString("Menu: "
                            + "\n1.-Predicados \n2.-Mutativos"));
                    switch (o) {
                        case 1:
                            t.Predicados();
                            break;
                        case 2:
                            t.Mutativos();
                            break;
                    }//switch
                    break;
                case 3:
                    t.ShowFile();
                    break;
                case 4:
                    t.ShowLong();
                    break;
                case 5:
                    t.ShowInt();
                    break;
                case 6:
                    t.ShowMiscelaneos();
                    break;

            }//switch
            res = Integer.parseInt(d.readString("¿Deseas elegir"
                    + " otro metodo? \n1.-Si \n2.-No"));
        } while (res == 1);
    }//resultados

    public static void main(String args[]) throws IOException {
       Prueba p = new Prueba();
       p.datos();
       p.resultados();

    }//main    
}
