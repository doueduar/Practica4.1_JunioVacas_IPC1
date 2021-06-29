/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.controladorVisual;

import java.awt.CardLayout;
import javax.swing.JPanel;
import practica4.pkg1.visual.Jugar;
import practica4.pkg1.visual.partesJugar.JuegoTablero;
import practica4.pkg1.visual.partesJugar.SeleccionarJugadores;

/**
 *
 * @author douglas2021
 */
public class ControladorJuego {
    private JPanel ventana;
    private Jugar juego;
    private JuegoTablero tablero;
    private SeleccionarJugadores selecJugadores;
    private CardLayout cardLayout;
    
    
    public ControladorJuego(Jugar juego, JPanel ventana){
        this.ventana = ventana;
        this.juego = juego;
        this.cambios();
    }
    public void cambios(){
        tablero = new JuegoTablero();
        selecJugadores = new SeleccionarJugadores(this);
        cardLayout = new CardLayout();
        this.ventana.setLayout(cardLayout);
        this.ventana.add(this.selecJugadores ,"Seleccionar");
        this.ventana.add(this.tablero ,"Jugemos");
    }
    public void SeleccionarJugador(){
        cardLayout.show(ventana,"Seleccionar");
    }
    public void MostrarTablero(){
        cardLayout.show(this.ventana,"Jugemos");
    }
    public void CrearTablero(){
        tablero.iniciarTablero();
    }
    
}
