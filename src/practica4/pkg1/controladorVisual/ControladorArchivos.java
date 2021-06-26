/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.controladorVisual;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import practica4.pkg1.Objetos.Condiciones;
import practica4.pkg1.OperadorArchivos.EscritorDeCondicionesBinarios;
import practica4.pkg1.OperadorArchivos.LectorDeCondicionesEnTexto;
import practica4.pkg1.visual.Archivos;

/**
 *
 * @author douglas2021
 */
public class ControladorArchivos {
    private Archivos archivo;
    private EscritorDeCondicionesBinarios escritorDeCondicionesBinarios;
    private LectorDeCondicionesEnTexto lectorDeCondicionesEnTexto;
    private JTextArea impresion;
    //private JFileChooser fileChosser;
    
    public ControladorArchivos(Archivos archivo, JTextArea impresion){
        this.archivo =  archivo;
        this.impresion = impresion;
    }
    public void ingresarArchivos(){
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(this.archivo);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //aqui selecciono y guardo el FILE que va a utilizar el FileReader
            File fichero = fileChosser.getSelectedFile();
            
            try {
                ArrayList<Condiciones> condiciones = this.lectorDeCondicionesEnTexto.leerFichero(fichero, this.impresion);
                //this.escritorDeCondicionesBinarios.guardarVehiculo(vehiculos);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this.archivo, "Error al leer el archivo");
                ex.printStackTrace();
            }
        }
    }
}
