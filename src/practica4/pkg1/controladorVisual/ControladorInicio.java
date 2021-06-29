/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.controladorVisual;

import practica4.pkg1.visual.*;

/**
 *
 * @author douglas2021
 */
public class ControladorInicio {
    private Inicio inicio;
    private Vpersonajes visualP;
    private Archivos archivo;
    private Jugar juego;
    
    public ControladorInicio(Inicio inicio){
        visualP = new Vpersonajes(this);
        archivo = new Archivos(this);
        juego = new Jugar(this);
        this.inicio = inicio;
    }
    public void ingresarJugar(){
        this.cerrarInicio();
        juego.setVisible(true);
    }
    public void ingresarVisualPersonaje(){
      visualP.setVisible(true);
    }
    public void visualizarInicio(){
        inicio.setVisible(true);
    }
    public void cerrarInicio(){
        inicio.setVisible(false); 
    }
    public void iniciarPersonajes(){
        this.cerrarInicio();
        visualP.setVisible(true);
    }
    public void iniciarArchivos(){
        this.cerrarInicio();
        archivo.setVisible(true);
    }
}
