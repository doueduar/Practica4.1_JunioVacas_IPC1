/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.Objetos;

import java.io.Serializable;

/**
 *
 * @author douglas2021
 */
public class Condiciones implements Serializable{
private String nombre;
private String complemento;

    public Condiciones(String nombre, String complemento) {
        this.nombre = nombre;
        this.complemento = complemento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
