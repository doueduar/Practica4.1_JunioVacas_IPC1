/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.controladorVisual.partes.jugar;

import javax.swing.DefaultListModel;
import practica4.pkg1.OperadorArchivos.LectorDeCondionesBinarios;
import practica4.pkg1.visual.partesJugar.SeleccionarJugadores;

/**
 *
 * @author douglas2021
 */
public class ControladorSeleccionarJugadores {
    SeleccionarJugadores control;
    LectorDeCondionesBinarios condiciones;
    DefaultListModel modelo;

    public ControladorSeleccionarJugadores(SeleccionarJugadores control) {
        this.control = control;
        modelo = new DefaultListModel();
    }
    public void colocarItem(){
        modelo.removeAllElements();
        control.getSelector().removeAllItems();
        String [] listado = condiciones.FILE_PERSONAJES.list();
        for(String lista: listado){
            control.getSelector().addItem(lista);
        }
    }    
    public void selecionar(){
        String selec = (String) control.getSelector().getSelectedItem();
        boolean condicional = true;
        for (int i = 0; i < modelo.size(); i++) {
            if (modelo.get(i).equals(selec)) {
                condicional = false;
            }
        }
        if (condicional) {
            modelo.addElement(selec);
            this.control.getListado().setModel(modelo);
        }
    }
    
    
}
