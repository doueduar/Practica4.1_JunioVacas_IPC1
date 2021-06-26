/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.OperadorArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;
import practica4.pkg1.Objetos.Condiciones;

/**
 *
 * @author douglas2021
 */
public class LectorDeCondicionesEnTexto {
    
     public ArrayList<Condiciones> leerFichero(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        // crea el arreglo para ingresar el vehiculo
        ArrayList<Condiciones> condiciones = new ArrayList<>();
        
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos = separarCampos(linea);
            //pasamos el texto a objeto
            if(verificar(campos[0])){
                Condiciones condicion = new Condiciones(campos[0],campos[1]);
                if(condicion!=null){
                    condiciones.add(condicion);
                }
                text.append("\n"+linea);
            }else{
                text.append("\n"+"error: "+linea);
            }
        }
        fr.close(); 
        return condiciones;
        
    }

    private String[] separarCampos(String linea) {
        String partes[] = linea.split("( ");
        String parte[] = partes[1].split(") ");
        String campos[] = {partes[0],parte[0]};
        return campos;
    }
    private boolean verificar(String campo){
        if(campo.equals("tablero")){return true;}
        if(campo.equals("pierdeturno")){return true;}
        if(campo.equals("tiradados")){return true;}
        if(campo.equals("avanzar")){return true;}
        if(campo.equals("retroceder")){return true;}
        if(campo.equals("subida")){return true;}
        if(campo.equals("bajada")){return true;}
        return false;
    }
}
