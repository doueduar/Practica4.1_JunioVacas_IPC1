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
public class Subida extends Cuadro{
    private static int contadorInstancia;
    private String nombre;
    
    public Subida(int fila, int columna, int filaFinal, int columnaFinal) {
        super(fila, columna, filaFinal, columnaFinal);
        this.nombre = "subida"+getInstancia();
        Subida.contadorInstancia++;
    }
    public static int getInstancia(){
        return Subida.contadorInstancia;
    }
    @Override
    public void setInstancia(){
        Subida.contadorInstancia = 0;
    }
    @Override
    public void ejecucion(int fx, int fy) {
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
    
}
