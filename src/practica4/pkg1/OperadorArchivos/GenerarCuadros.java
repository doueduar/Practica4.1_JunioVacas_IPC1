/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.OperadorArchivos;

import java.util.ArrayList;
import practica4.pkg1.Objetos.Condiciones;
import practica4.pkg1.Objetos.Juego.Cuadro;
import practica4.pkg1.Objetos.Juego.*;

/**
 *
 * @author douglas2021
 */
public class GenerarCuadros {
    private ArrayList<Condiciones> condiciones;

    public GenerarCuadros(ArrayList<Condiciones> condiciones) {
        this.condiciones = condiciones;
    }
    
    
    public ArrayList<Cuadro> GenerarLosCuadros(){
        ArrayList<Cuadro> tablero = new ArrayList<>();
        Cuadro cuadro;
        for(Condiciones condicion : condiciones){
            cuadro = null;
            if((condicion.getNombre().equals("tablero")) && (Longitud(condicion.getComplemento()) == 2))
                cuadro = generarTablero(condicion);
            if((condicion.getNombre().equals("pierdeturno"))&& (Longitud(condicion.getComplemento()) == 2))
                cuadro = pierdeTurno(condicion);
            if((condicion.getNombre().equals("tiradados"))&& (Longitud(condicion.getComplemento()) == 2))
                cuadro = tiradados(condicion);
            if((condicion.getNombre().equals("avanza"))&& (Longitud(condicion.getComplemento()) == 3))
                cuadro = avanza(condicion);
            if((condicion.getNombre().equals("retrocede"))&& (Longitud(condicion.getComplemento()) == 3))
                cuadro = retrocede(condicion);
            if((condicion.getNombre().equals("subida"))&& (Longitud(condicion.getComplemento()) == 4))
                cuadro = subida(condicion);
            if((condicion.getNombre().equals("bajada"))&& (Longitud(condicion.getComplemento()) == 4))
                cuadro = bajada(condicion);
            if(cuadro != null)
                tablero.add(cuadro);
        }
        
        return tablero;
    }
    public String[] separar(String parte){
        String partes[] = parte.split(",");
        return partes;
    }
    public int Longitud(String parte){
        String [] L = parte.split(",");
        int longitud = L.length;
        return longitud;
    }
    private static int[] numeros(String[] cadena){
	try {
            int[] arreglo = new int[cadena.length];
            for(int i=0 ; 0 < cadena.length; i++){
                arreglo[i] = Integer.parseInt(cadena[i]);   
            }
		return arreglo;
	} catch (NumberFormatException nfe){
            System.out.println("no se pudo ingresar los numeros error: "+nfe);
            return null;
	}
    }
    public Cuadro generarTablero(Condiciones condiciones){
        String[] partes = separar(condiciones.getComplemento());
        if(numeros(partes) != null){
            Cuadro tablero = new Dimenciones(numeros(partes)[0],numeros(partes)[1]);
            return tablero;
        }
        return null;
    }
    public Cuadro pierdeTurno(Condiciones condiciones){
       String[] partes = separar(condiciones.getComplemento());
        if(numeros(partes) != null){
            Cuadro tablero = new PierdeTurno(numeros(partes)[0],numeros(partes)[1]);
            return tablero;
        }
        return null; 
    }
    public Cuadro tiradados(Condiciones condiciones){
        String[] partes = separar(condiciones.getComplemento());
        if(numeros(partes) != null){
            Cuadro tablero = new TiraDados(numeros(partes)[0],numeros(partes)[1]);
            return tablero;
        }
        return null;
    }
    public Cuadro avanza(Condiciones condiciones){
        String[] partes = separar(condiciones.getComplemento());
        if(numeros(partes) != null){
            Cuadro tablero = new Avanza(numeros(partes)[0],numeros(partes)[1],numeros(partes)[2]);
            return tablero;
        }
        return null;
    }
    public Cuadro retrocede(Condiciones condiciones){
        String[] partes = separar(condiciones.getComplemento());
        if(numeros(partes) != null){
            Cuadro tablero = new Retrocede(numeros(partes)[0],numeros(partes)[1],numeros(partes)[2]);
            return tablero;
        }
        return null;
    }
    public Cuadro subida(Condiciones condiciones){
        String[] partes = separar(condiciones.getComplemento());
        if(numeros(partes) != null){
            Cuadro tablero = new Subida(numeros(partes)[0],numeros(partes)[1],numeros(partes)[2],numeros(partes)[3]);
            return tablero;
        }
        return null;
    }
    public Cuadro bajada(Condiciones condiciones){
         String[] partes = separar(condiciones.getComplemento());
        if(numeros(partes) != null){
            Cuadro tablero = new Bajada(numeros(partes)[0],numeros(partes)[1],numeros(partes)[2],numeros(partes)[3]);
            return tablero;
        }
        return null;
    }
    
}
