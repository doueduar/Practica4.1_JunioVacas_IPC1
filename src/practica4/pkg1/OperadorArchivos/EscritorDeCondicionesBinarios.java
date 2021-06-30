/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.OperadorArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import practica4.pkg1.Objetos.Condiciones;
import practica4.pkg1.Objetos.Juego.Cuadro;
import practica4.pkg1.Objetos.Personajes;

/**
 *
 * @author douglas2021
 */
public class EscritorDeCondicionesBinarios {
    public static final File  FILE_CONDICIONES= new File("/media/douglas2021/Dou_job/junio_vaquera/ArchivosBinarios");
    
    public void guardarCondiciones(ArrayList<Condiciones> condiciones) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
        GenerarCuadros tablero = new GenerarCuadros(condiciones);
        ArrayList<Cuadro> tableros = tablero.GenerarLosCuadros();
        for (Cuadro cuadro : tableros) {
            System.out.println(cuadro.getNombre());
            if(FILE_CONDICIONES.mkdirs()){
                System.out.println("no existe lo voy a tratar de generar");
            }else{
                System.out.println("existe");
            }
            cuadro.setInstancia();
            fileOutput = new FileOutputStream(FILE_CONDICIONES+"/"+cuadro.getNombre());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(cuadro);
            salida.close();
        }
    }
    public static final File  FILE_PERSONAJES= new File("/media/douglas2021/Dou_job/junio_vaquera/ArchivosBinarios/Personajes");
    
    public void guardarPersonajes(Personajes personaje)throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
        if(FILE_PERSONAJES.mkdirs()){
                System.out.println("no existe lo voy a tratar de generar");
            }else{
                System.out.println("existe");
        }
        fileOutput = new FileOutputStream(FILE_PERSONAJES+"/"+personaje.getNombre()+personaje.getID());
        salida = new ObjectOutputStream(fileOutput);
        salida.writeObject(personaje);
        salida.close();
            
    }
    
}
