/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.Objetos.Juego;

/**
 *
 * @author douglas2021
 */
public class Dimenciones extends Cuadro{
    private String nombre;
    
    public Dimenciones(int fila, int columna) {
        super(fila, columna);
        nombre = "Dimenciones/dimenciones1";
    }
    @Override
    public void setInstancia(){
    }

    @Override
    public void ejecucion(int fx, int fy) {
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    
}
