/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.OperadorArchivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import practica4.pkg1.Objetos.Condiciones;

/**
 *
 * @author douglas2021
 */
public class LectorDeCondionesBinarios {
    public ArrayList<Condiciones> leerVehiculos() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Condiciones> vehiculos = new ArrayList<>();
        String[]  archivos= EscritorDeCondicionesBinarios.FILE_CONDICIONES.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorDeCondicionesBinarios.FILE_CONDICIONES+"/"+archivo));
            Condiciones v =(Condiciones)lector.readObject();
            vehiculos.add(v);
            lector.close();
        }
        return vehiculos;
    }
}
