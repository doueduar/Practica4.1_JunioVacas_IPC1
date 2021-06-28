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
public class TiraDados extends Cuadro {
    private String nombre;
    private static int contadorInstancia;
    
    public TiraDados(int fila, int columna) {
        super(fila, columna);
        this.nombre = "TiraDados/tiraDados"+getInstancia();
        TiraDados.contadorInstancia++;
    }
    public static int getInstancia(){
        return TiraDados.contadorInstancia;
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
