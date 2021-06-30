/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.Objetos.Juego;

import java.io.Serializable;

/**
 *
 * @author douglas2021
 */
public abstract class Cuadro implements Serializable{
    private int fila;
    private int columna;
    private int cantidadPosicion;
    private int filaFinal;
    private int columnaFinal;
    

    public Cuadro(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    public Cuadro(int fila, int columna, int filaFinal, int columnaFinal) {
        this.fila = fila;
        this.columna = columna;
        this.filaFinal = filaFinal;
        this.columnaFinal = columnaFinal;
    }

    public Cuadro(int fila, int columna, int cantidadPosicion) {
        this.fila = fila;
        this.columna = columna;
        this.cantidadPosicion = cantidadPosicion;
    }
    public abstract void ejecucion(int fx,int fy);
    public abstract String getNombre();
    public abstract void setInstancia();

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getCantidadPosicion() {
        return cantidadPosicion;
    }

    public void setCantidadPosicion(int cantidadPosicion) {
        this.cantidadPosicion = cantidadPosicion;
    }

    public int getFilaFinal() {
        return filaFinal;
    }

    public void setFilaFinal(int filaFinal) {
        this.filaFinal = filaFinal;
    }

    public int getColumnaFinal() {
        return columnaFinal;
    }

    public void setColumnaFinal(int columnaFinal) {
        this.columnaFinal = columnaFinal;
    }
    
}
