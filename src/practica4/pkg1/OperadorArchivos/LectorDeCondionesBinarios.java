/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.OperadorArchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import practica4.pkg1.Objetos.Condiciones;
import practica4.pkg1.Objetos.Juego.Cuadro;
import practica4.pkg1.Objetos.Personajes;

/**
 *
 * @author douglas2021
 */
public class LectorDeCondionesBinarios {
    
    public ArrayList<Cuadro> leerCondiciones() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Cuadro> cuadros = new ArrayList<>();
        String[]  archivos = EscritorDeCondicionesBinarios.FILE_CONDICIONES.list();
        ObjectInputStream lector;   
        System.out.println("Archivos logitud: "+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            System.out.println(archivo);
            if(!archivo.equals("Dimenciones")){
                lector = new ObjectInputStream(new FileInputStream(EscritorDeCondicionesBinarios.FILE_CONDICIONES+"/"+archivo));
                Cuadro v = (Cuadro)lector.readObject();
                cuadros.add(v);
                lector.close();
            }
        }
        return cuadros;
    }
    
    public static final File  FILE_CONDICIONES= new File("/media/douglas2021/Dou_job/junio_vaquera/ArchivosBinarios/Dimenciones/dimenciones1");
    
    public Cuadro leerCondicionesDimenciones() throws FileNotFoundException,IOException,ClassNotFoundException{
        Cuadro cuadros;
        ObjectInputStream lector;   
        lector = new ObjectInputStream(new FileInputStream(FILE_CONDICIONES));
        cuadros = (Cuadro)lector.readObject();
        lector.close();
        return cuadros;
    }
    //public static final File  FILE_PERSONAJES= new File("/media/douglas2021/Dou_job/junio_vaquera/ArchivosBinarios/Personajes");
    
    public ArrayList<Personajes> leerPersonajes() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Personajes> personajes = new ArrayList<>();
        String[]  archivos = EscritorDeCondicionesBinarios.FILE_PERSONAJES.list();
        ObjectInputStream lector;   
        System.out.println("Archivos logitud: "+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            System.out.println(archivo);
                lector = new ObjectInputStream(new FileInputStream(EscritorDeCondicionesBinarios.FILE_PERSONAJES+"/"+archivo));
                Personajes v = (Personajes)lector.readObject();
                personajes.add(v);
                lector.close();
        }
        return personajes;
    }
}
