/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.Objetos;

import java.awt.Color;

/**
 *
 * @author douglas2021
 */
public class jugador {
    private String nombre;
    private int x;
    private  int y;
    private int fx;
    private  int fy;
    private boolean estadoX = false;
    private boolean estadoY = false;
    private static int instaciaJugador;
    private int posicion;
    private int parte;
    private Color color;
    public jugador(String nombre,int fx,int fy, int parte,Color color) {
        this.nombre = nombre;
        this.fx = fx;
        this.fy = fy;
        this.parte = parte;
        this.x = 0;
        this.y =  0;
        this.color =  color;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public int getParte() {
        return parte;
    }

    public void setParte(int parte) {
        this.parte = parte;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }
    public void instanciaReset(){
        this.instaciaJugador = 0;
    }
    public void instacia(){
        if (estadoX && estadoY) {
            posicion = ++instaciaJugador;
            System.out.println("posicion: "+posicion);
        }
    }
    public void setX(int x) {
        if (x == fx) {
            estadoX = true;
        }else{
            estadoX = false;
        }
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y) {
        if (y == fy) {
            estadoY = true;
        }else{
            estadoY = false;
        }
        instacia();
        this.y = y;
    }
    
}
