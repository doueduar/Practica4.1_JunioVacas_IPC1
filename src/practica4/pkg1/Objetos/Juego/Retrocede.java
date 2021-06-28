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
public class Retrocede extends Cuadro{
    private static int contadorInstancia;
    private String nombre;
    
    public Retrocede(int fila, int columna, int cantidadPosicion) {
        super(fila, columna, cantidadPosicion);
        this.nombre = "Retroceder/retroceder"+getInstancia();
        Retrocede.contadorInstancia++;
    }
    public static int getInstancia( ){
        return Retrocede.contadorInstancia;
    }
    @Override
    public void ejecucion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
    
}
