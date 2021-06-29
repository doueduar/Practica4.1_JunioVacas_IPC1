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
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;
import practica4.pkg1.Objetos.Condiciones;

/**
 *
 * @author douglas2021
 */

public class LectorDeCondicionesEnTexto {
       
    public ArrayList<Condiciones> leerFichero(File archivo,JTextArea text, JList<String> error) throws FileNotFoundException, IOException {
        // crea el arreglo para ingresar el vehiculo
        System.out.println("estoy aqui antes de la condicion");
        ArrayList<Condiciones> condiciones = new ArrayList<>();
        System.out.println("ingreso aqui leer");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        DefaultListModel modelo = new DefaultListModel();
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos = separarCampos(linea);
            //pasamos el texto a objeto
            if(verificar(campos)){
                Condiciones condicion = new Condiciones(campos[0],campos[1]);
                if(condicion!=null){
                    condiciones.add(condicion);
                }
                text.append("\n"+linea);
            }else{
                modelo.addElement(linea);
                text.append("\n"+"error: "+linea);
            }
        }
        error.setModel(modelo);
        fr.close(); 
        return condiciones;
        
    }

    private String[] separarCampos(String linea) {
        System.out.println(linea);
        String campos[] = new String[2];
        String partes[] = linea.split("\\(");
        if((1<partes.length) && (partes[1] != null)){
            String parte[] = partes[1].split("\\)");
            System.out.println(partes[0]+" "+parte[0]);
            campos[0] = partes[0];
            campos[1] = parte[0];
        }else{
            campos = null;
        }
        return campos;
    }
    private boolean verificar(String[] campo){
        if(campo == null){return false;}
        if(campo[0].equals("tablero")){return true;}
        if(campo[0].equals("pierdeturno")){return true;}
        if(campo[0].equals("tiradados")){return true;}
        if(campo[0].equals("avanza")){return true;}
        if(campo[0].equals("retrocede")){return true;}
        if(campo[0].equals("subida")){return true;}
        if(campo[0].equals("bajada")){return true;}
        return false;
    }
}
