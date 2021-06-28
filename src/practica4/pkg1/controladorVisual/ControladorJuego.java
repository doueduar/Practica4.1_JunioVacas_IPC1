/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.controladorVisual;

import javax.swing.JPanel;
import practica4.pkg1.visual.Jugar;

/**
 *
 * @author douglas2021
 */
public class ControladorJuego {
    private JPanel ventana;
    private Jugar juego;
    
    public ControladorJuego(Jugar juego, JPanel ventana){
        
        this.ventana = ventana;
        this.juego = juego;
    }
    
}
