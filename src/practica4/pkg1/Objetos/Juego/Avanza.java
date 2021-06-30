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
        this.nombre = "avanza"+getInstancia(); 
        Avanza.contadorInstancia++;
    }
    public int getInstancia(){
        return Avanza.contadorInstancia;
    }
    @Override
    public void setInstancia(){
        Avanza.contadorInstancia = 0;
    }
    @Override
    public void ejecucion(int fx,int fy) {
        int x = this.getColumna();
        int y = this.getFila();
        for (int i = 0; i < this.getCantidadPosicion(); i++) {
            if (x == fx-1) {
                y++;
                x = 0;
            }else{
                x++;
            }
        }
        System.out.println("posicion"+this.getColumna()+" "+this.getFila()+" avanzar "+this.getCantidadPosicion()+" se movio a la posicion "+x+" "+y);
        this.setColumnaFinal(x);
        this.setFilaFinal(y);
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    
}
