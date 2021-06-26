/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.controladorVisual;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import practica4.pkg1.visual.Vpersonajes;

/**
 *
 * @author douglas2021
 */
public class ControladorVpersonajes {
    
    Vpersonajes vPersonaje;
    private DefaultTableModel modelo;
    
    public ControladorVpersonajes(Vpersonajes vPersonaje, JTable tablaPersonajes){
        this.vPersonaje = vPersonaje;
        
        modelo = new DefaultTableModel();
        tablaPersonajes.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Partidas Jugadas");
        modelo.addColumn("Partidas Ganadas");
        modelo.addColumn("Partidas Perdidas");
        
    }
    public static void llenarTabla(){
        
    }
}
