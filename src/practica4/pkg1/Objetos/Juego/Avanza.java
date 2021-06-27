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
public class Avanza extends Cuadro{
    private static int contadorInstancia;
    private String nombre;
    
    public Avanza(int fila, int columna, int cantidadPosicion) {
        super(fila, columna, cantidadPosicion);
        this.nombre = "Avanza/avanza"+getInstancia(); 
        Avanza.contadorInstancia++;
    }
    public int getInstancia(){
        return contadorInstancia;
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
