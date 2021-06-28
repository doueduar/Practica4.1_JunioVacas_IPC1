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
    public void ejecucion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    
}
