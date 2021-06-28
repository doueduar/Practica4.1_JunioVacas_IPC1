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
            fileOutput = new FileOutputStream(FILE_CONDICIONES+"/"+cuadro.getNombre());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(cuadro);
            salida.close();
        }
    }
    
}
