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
public class Bajada extends Cuadro{
    private static int contadorInstancia;
    private String nombre;
    public Bajada(int fila, int columna, int filaFinal, int columnaFinal) {
        super(fila, columna, filaFinal, columnaFinal);
        nombre =  "Bajada/bajada"+getInstancia();
        Bajada.contadorInstancia++;
    }
    private static int getInstancia(){
        return Bajada.contadorInstancia;
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
