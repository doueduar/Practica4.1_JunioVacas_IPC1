/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.controladorVisual.partes.jugar;

import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import practica4.pkg1.Objetos.Juego.Cuadro;
import practica4.pkg1.OperadorArchivos.LectorDeCondionesBinarios;
import practica4.pkg1.visual.partesJugar.Cuadrito;
import practica4.pkg1.visual.partesJugar.JuegoTablero;

/**
 *
 * @author douglas2021
 */
public class ControladorJuegoTablero {
    JuegoTablero juego;
    JPanel tablero;
    LectorDeCondionesBinarios lector;
    Cuadro dimenciones;
    Cuadrito cuadro[][];

    public ControladorJuegoTablero(JuegoTablero juego,JPanel tablero) {
        this.juego = juego;
        this.tablero = tablero;
        lector = new LectorDeCondionesBinarios();
    }
    public void limpiar(){
        tablero.removeAll();
    }
    public void crearTablero(){
        try {
            dimenciones = lector.leerCondicionesDimenciones();
            System.out.println("fila: "+dimenciones.getFila()+" columna: "+dimenciones.getColumna());
            //GridLayout()(int fila, int columna, int hgap, int vgap)
            cuadro = new Cuadrito[dimenciones.getColumna()][dimenciones.getFila()];
            tablero.setLayout(new GridLayout(dimenciones.getFila(),dimenciones.getColumna(), 1,2));
            for(int i =0 ; i< dimenciones.getFila() ;i++){
                int par = i % 2;
                if(par == 0){
                    for (int j = 0; j < dimenciones.getColumna() ; j++) {
                        cuadro[j][i] = new Cuadrito();
                        cuadro[j][i].getEnumeracion().setText(i+" "+j);
                        tablero.add(cuadro[j][i]);
                    }
                }else{
                    for (int j = 0; j < dimenciones.getColumna() ; j++) {
                       int p = dimenciones.getColumna()-j-1;
                        cuadro[p][i] = new Cuadrito();
                        cuadro[p][i].getEnumeracion().setText(i+" "+p);
                        tablero.add(cuadro[p][i]);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorJuegoTablero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorJuegoTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        colocarCondicionales();
    }
    public void colocarCondicionales() {
        ArrayList<Cuadro> condicionales;
        try {
            condicionales = lector.leerCondiciones();
            for (Cuadro condicion : condicionales) {
                if ((condicion.getFila()<dimenciones.getFila())&&(condicion.getColumna()<dimenciones.getColumna()))
                    cuadro[condicion.getFila()][condicion.getColumna()].setCuadro(condicion);
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorJuegoTablero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorJuegoTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void colocarFichaInicial(){
        
    }
}
