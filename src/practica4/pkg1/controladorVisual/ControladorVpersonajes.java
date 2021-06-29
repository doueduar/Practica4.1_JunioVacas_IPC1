/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.controladorVisual;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import practica4.pkg1.Objetos.Personajes;
import practica4.pkg1.OperadorArchivos.EscritorDeCondicionesBinarios;
import practica4.pkg1.OperadorArchivos.LectorDeCondionesBinarios;
import practica4.pkg1.visual.Vpersonajes;

/**
 *
 * @author douglas2021
 */
public class ControladorVpersonajes {
    
    Vpersonajes vPersonaje;
    private DefaultTableModel modelo;
    EscritorDeCondicionesBinarios escribir;
    LectorDeCondionesBinarios leer;
    JTable tablaPersonajes;
    ArrayList<Personajes> personas;
    
    public ControladorVpersonajes(Vpersonajes vPersonaje, JTable tablaPersonajes){
        this.vPersonaje = vPersonaje;
        escribir = new EscritorDeCondicionesBinarios();
        leer = new LectorDeCondionesBinarios();
        this.tablaPersonajes = tablaPersonajes;
        crearTabla();
        
    }
    public void crearTabla(){
        modelo = new DefaultTableModel();
        tablaPersonajes.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Partidas Jugadas");
        modelo.addColumn("Partidas Ganadas");
        modelo.addColumn("Partidas Perdidas");
    }
    public void llenarTabla(){
        try {
            crearTabla();
            personas = leer.leerPersonajes();
            for (Personajes persona : personas) {
                modelo.addRow(new Object[]{persona.getID(),persona.getNombre(),persona.getApellidos(),persona.getPartidasJugadas(),persona.getPartidasGanadas(),persona.getPartidasPerdidas()});
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorVpersonajes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVpersonajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    public boolean verificar(int valor){
        try {
            personas = leer.leerPersonajes();
            for(Personajes persona: personas){
                if (persona.getID() == valor) {
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorVpersonajes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVpersonajes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void ingresarJugador(){
        int id = 0;
        boolean condicion =  true;
        if (isNumeric(this.vPersonaje.getIdText().getText())) {
            id = Integer.parseInt(this.vPersonaje.getIdText().getText());
            if (verificar(id)) {
                condicion = false;
            }
        } else {
            condicion = false;
        }
        if (this.vPersonaje.getApellidoText().getText().equals("")) {
            condicion = false;
        }
        if(this.vPersonaje.getNombreText().getText().equals("")){
            condicion = false;
        }
        if (condicion) {
            Personajes personaje = new Personajes(id,this.vPersonaje.getNombreText().getText(),this.vPersonaje.getApellidoText().getText());
            try {
                escribir.guardarPersonajes(personaje);
            } catch (IOException ex) {
                System.out.println("no se ingreso el personaje");
                Logger.getLogger(ControladorVpersonajes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        limpiar();
 
    }
    public void limpiar(){
        this.vPersonaje.getApellidoText().setText("");
        this.vPersonaje.getNombreText().setText("");
        this.vPersonaje.getIdText().setText("");
    }
}
