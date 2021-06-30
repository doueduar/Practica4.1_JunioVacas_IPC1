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
        this.nombre = "retroceder"+getInstancia();
        Retrocede.contadorInstancia++;
    }
    public static int getInstancia( ){
        return Retrocede.contadorInstancia;
    }
    @Override
    public void ejecucion(int fx,int fy) {
        int x = this.getColumna();
        int y = this.getFila();
        for (int i = 0; i < this.getCantidadPosicion(); i++) {
            if (x == 0) {
                y--;
                x = fx-1;
            }
            x--;
        }
        this.setColumnaFinal(x);
        this.setFilaFinal(y);
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
    
}
