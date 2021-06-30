/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.pkg1.controladorVisual.partes.jugar;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import practica4.pkg1.Objetos.Juego.*;
import practica4.pkg1.Objetos.Juego.Cuadro;
import practica4.pkg1.Objetos.Personajes;
import practica4.pkg1.Objetos.jugador;
import practica4.pkg1.OperadorArchivos.EscritorDeCondicionesBinarios;
import practica4.pkg1.OperadorArchivos.LectorDeCondionesBinarios;
import practica4.pkg1.visual.partesJugar.Cuadrito;
import practica4.pkg1.visual.partesJugar.JuegoTablero;

/**
 *
 * @author douglas2021
 */
public class ControladorJuegoTablero {
    JuegoTablero juego;
    JPanel tablero;
    LectorDeCondionesBinarios lector;
    EscritorDeCondicionesBinarios escritor;
    Cuadro dimenciones;
    Cuadrito cuadro[][];
    ArrayList<String> listado;
    ArrayList<jugador> jugadores;

    public ControladorJuegoTablero(JuegoTablero juego,JPanel tablero,ArrayList<String> listado) {
        this.juego = juego;
        this.tablero = tablero;
        this.listado = listado;
        lector = new LectorDeCondionesBinarios();
        escritor =  new EscritorDeCondicionesBinarios();
    }
    public void limpiar(){
        tablero.removeAll();
        juego.getDado().setText("");
        juego.getInstrucciones().setText("");
        juego.getInstrucciones2().setText("");
        juego.getVisualJugador().setText("");
        //jugadores.get(0).instanciaReset();
    }
    public void crearTablero(ArrayList<String> listado){
        try {
            this.listado =listado;
            dimenciones = lector.leerCondicionesDimenciones();
            System.out.println("fila: "+dimenciones.getFila()+" columna: "+dimenciones.getColumna());
            //GridLayout()(int fila, int columna, int hgap, int vgap)
            cuadro = new Cuadrito[dimenciones.getColumna()][dimenciones.getFila()];
            tablero.setLayout(new GridLayout(dimenciones.getFila(),dimenciones.getColumna(), 1,2));
            for(int i =0 ; i< dimenciones.getFila() ;i++){
                int par = i % 2;
                if(par == 0){
                    for (int j = 0; j < dimenciones.getColumna() ; j++) {
                        cuadro[j][i] = new Cuadrito();
                        cuadro[j][i].getEnumeracion().setText(i+" "+j);
                        tablero.add(cuadro[j][i]);
                    }
                }else{
                    for (int j = 0; j < dimenciones.getColumna() ; j++) {
                       int p = dimenciones.getColumna()-j-1;
                        cuadro[p][i] = new Cuadrito();
                        cuadro[p][i].getEnumeracion().setText(i+" "+p);
                        tablero.add(cuadro[p][i]);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorJuegoTablero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorJuegoTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("cantidad participantes "+listado.size());
        fichasIniciales();
        colocarCondicionales();
    }
    public void colocarCondicionales() {
        ArrayList<Cuadro> condicionales;
        try {
            condicionales = lector.leerCondiciones();
            for (Cuadro condicion : condicionales) {
                if ((condicion.getFila()<dimenciones.getFila())&&(condicion.getColumna()<dimenciones.getColumna())){
                    if ((condicion.getFila()!=dimenciones.getFila()-1) &&(condicion.getColumna()!=dimenciones.getColumna()-1) ) {
                        condicion.ejecucion(dimenciones.getColumna(),dimenciones.getFila());
                    
                        if ((condicion.getColumnaFinal()< dimenciones.getColumna()) || (condicion.getFilaFinal()<dimenciones.getFila()) ) {
                            if ( (0 <= condicion.getColumnaFinal())&&(0<=condicion.getFilaFinal()) ) {
                                if (condicion.getColumnaFinal()< dimenciones.getColumna() && condicion.getFilaFinal()<dimenciones.getFila()) {
                                    cuadro[condicion.getColumna()][condicion.getFila()].setCuadro(condicion);
    
                                    if (condicion instanceof Avanza)
                                        cuadro[condicion.getColumna()][condicion.getFila()].getLugar().setText("Av");
                                    if (condicion instanceof Bajada) 
                                        cuadro[condicion.getColumna()][condicion.getFila()].getLugar().setText("Ba");
                                    if (condicion instanceof Retrocede) 
                                        cuadro[condicion.getColumna()][condicion.getFila()].getLugar().setText("Rt");
                                    if (condicion instanceof Subida) 
                                        cuadro[condicion.getColumna()][condicion.getFila()].getLugar().setText("S");
                                }
                            }
                        }
                        if (condicion instanceof PierdeTurno){ 
                            cuadro[condicion.getColumna()][condicion.getFila()].setCuadro(condicion);
                            cuadro[condicion.getColumna()][condicion.getFila()].getLugar().setText("PrT");
                        }if (condicion instanceof TiraDados){ 
                            cuadro[condicion.getColumna()][condicion.getFila()].setCuadro(condicion);
                            cuadro[condicion.getColumna()][condicion.getFila()].getLugar().setText("TD");
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorJuegoTablero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorJuegoTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Color insertarColor(int i){
        Color color = null;
        if (i == 0) {
            color =  Color.ORANGE;
        }
        if (i == 1) {
            color =  Color.RED;
        }
        if (i == 2) {
            color =  Color.PINK;
        }
        if (i == 3) {
            color =  Color.YELLOW;
        }
        return color;
    }
    public void fichasIniciales(){
        jugadores = new ArrayList<>();
        contador = true;
        for (int i = 0; i < listado.size(); i++) {
            jugador jugadors =  new jugador(listado.get(i),dimenciones.getColumna()-1,dimenciones.getFila()-1,i, insertarColor(i));
            jugadores.add(jugadors);
            ingresar(i,0,0,listado.get(i),jugadors.getColor());
        }
    }
    public void insertarM(String mensaje){
        juego.getInstrucciones2().setText(juego.getInstrucciones().getText());
        juego.getInstrucciones().setText(mensaje);
    }
    boolean contador = true;
    
    public boolean juego(int dado,int quien){
        if (validarGanador()) {
            if ((jugadores.get(quien).getX() != dimenciones.getColumna()-1) || (jugadores.get(quien).getY() != dimenciones.getFila()-1) ) {
                juego.getVisualJugador().setText(jugadores.get(quien).getNombre());
                int x = x(dado,jugadores.get(quien).getX());
                int y = y(dado,jugadores.get(quien).getX(),jugadores.get(quien).getY());
                if ((x< dimenciones.getColumna())&&(y < dimenciones.getFila())) {
                    mover(jugadores.get(quien),x,y);
                    jugadores.get(quien).setX(x);
                    jugadores.get(quien).setY(y);
                    return condicionales(jugadores.get(quien),x,y);
                }
            }   
        }else{
            System.out.println("ya todos finalizaron la carrera");
            if (contador) {
                escribirJugadores();
                jugadores.get(quien).instanciaReset();
                JOptionPane.showMessageDialog(this.juego, "Ya todos ingresaron a la meta puedes consultarlo en la tabla");
                System.out.println("escribir jugadores");
            }
            contador = false;
        }
        return false;
    }
    public void escribirJugadores(){
        try {
            for(jugador persona: jugadores){
                Personajes p =  lector.leerPersonaje(persona.getNombre());
                if (persona.getPosicion() == 1) {
                    p.setPartidasGanadas(p.getPartidasGanadas()+1);
                    p.setPartidasJugadas(p.getPartidasJugadas()+1);
                }else{
                    p.setPartidasPerdidas(p.getPartidasPerdidas()+1);
                    p.setPartidasJugadas(p.getPartidasJugadas()+1);
                }
                this.escritor.guardarPersonajes(p);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorJuegoTablero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorJuegoTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean condicionales(jugador jugar,int x,int y){
        Cuadro p = cuadro[x][y].getCuadro();
        
        if (p == null) {
            insertarM("Se movio a: "+y+" "+x);
            return false;
        }
        if (p instanceof Avanza) {
            mover(jugar,p.getColumnaFinal(),p.getFilaFinal());
            insertarM("Avanzo: "+p.getFilaFinal()+" "+p.getColumnaFinal());
            jugar.setX(p.getColumnaFinal());
            jugar.setY(p.getFilaFinal());
            return false;
        }
        if (p instanceof Bajada) {
            mover(jugar,p.getColumnaFinal(),p.getFilaFinal());
            insertarM("Bajada: "+p.getFilaFinal()+" "+p.getColumnaFinal());
            jugar.setX(p.getColumnaFinal());
            jugar.setY(p.getFilaFinal());
            return false;
        }
        if (p instanceof Retrocede) {
            mover(jugar,p.getColumnaFinal(),p.getFilaFinal());
            insertarM("Retrocede: "+p.getFilaFinal()+" "+p.getColumnaFinal());
            jugar.setX(p.getColumnaFinal());
            jugar.setY(p.getFilaFinal());
            
            return false;
        }
        if (p instanceof Subida) {
            mover(jugar,p.getColumnaFinal(),p.getFilaFinal());
            insertarM("Subida: "+p.getFilaFinal()+" "+p.getColumnaFinal());
            jugar.setX(p.getColumnaFinal());
            jugar.setY(p.getFilaFinal());
            
            return false;
        }
        if (p instanceof TiraDados) {
            return true;
        }
        insertarM("Se movio a: "+y+" "+x);
        return false;
    }
    public int x(int dado,int x){
        int X = x;
        for (int i = 0; i < dado; i++) {
            if (X == dimenciones.getColumna()-1) {
                X = 0;
            }else{
                X++;
            }
        }
        return X;
    }
    public int y(int dado, int x, int y){
        int Y = y;
        int X = x;
        for (int i = 0; i < dado; i++) {
            if (X == dimenciones.getColumna()-1) {
                Y++;
                X =0;
            }else{
                X++;
            }
        }
        return Y;
    }
    public void mover(jugador jugar,int fx,int fy){
        Cuadrito validar = cuadro[fx][fy];
        boolean estado = true;
        if (validar.getFicha1().getText().equals("") && estado) {
            ingresar(0,fx,fy,jugar.getNombre(),jugar.getColor());
            ingresar(jugar.getParte()+4,jugar.getX(),jugar.getY(),"",jugar.getColor());
            jugar.setParte(0);
            estado = false;
        }
        if (validar.getFicha2().getText().equals("") && estado) {
            ingresar(1,fx,fy,jugar.getNombre(),jugar.getColor());
            ingresar(jugar.getParte()+4,jugar.getX(),jugar.getY(),"",jugar.getColor());
            jugar.setParte(1);
            estado =  false;
        }
        if (validar.getFicha3().getText().equals("") && estado) {
            ingresar(2,fx,fy,jugar.getNombre(),jugar.getColor());
            ingresar(jugar.getParte()+4,jugar.getX(),jugar.getY(),"",jugar.getColor());
            jugar.setParte(2);
            estado = false;
        }
        if (validar.getFicha4().getText().equals("") && estado) {
            ingresar(3,fx,fy,jugar.getNombre(),jugar.getColor());
            ingresar(jugar.getParte()+4,jugar.getX(),jugar.getY(),"",jugar.getColor());
            jugar.setParte(3);
            estado = false;
        }
    }
    public boolean validarGanador(){
        Cuadrito validar = cuadro[dimenciones.getColumna()-1][dimenciones.getFila()-1];
        boolean estado = false;
        if (validar.getFicha1().getText().equals("") && (1 <= jugadores.size())) 
            estado = true;
        if (validar.getFicha2().getText().equals("")&&(2 <= jugadores.size())) 
            estado = true;
        if (validar.getFicha3().getText().equals("") && (3 <= jugadores.size())) 
            estado = true;
        if (validar.getFicha4().getText().equals("") && (4 <= jugadores.size())) 
            estado = true;
        return estado;
    }
    public void ordenar(int i){
        for (int j = 0; j < i; j++) {
            
        }
        
    }
    public void ingresar(int i,int x, int y,String nombre, Color color){
            
            if (i == 0) {
                cuadro[x][y].getFicha1().setText(nombre);
                cuadro[x][y].getFicha1().setOpaque(true);
                cuadro[x][y].getFicha1().setBackground(color);
            }
            if (i == 4) {
                cuadro[x][y].getFicha1().setText("");
                cuadro[x][y].getFicha1().setOpaque(false);
            }
            if (i == 1) {
                cuadro[x][y].getFicha2().setText(nombre);
                cuadro[x][y].getFicha2().setOpaque(true);
                cuadro[x][y].getFicha2().setBackground(color);
            }
            if (i == 5) {
                cuadro[x][y].getFicha2().setText("");
                cuadro[x][y].getFicha2().setOpaque(false);
            }
            if (i == 2) {
                cuadro[x][y].getFicha3().setText(nombre);
                cuadro[x][y].getFicha3().setOpaque(true);
                cuadro[x][y].getFicha3().setBackground(color);
            }
            if (i == 6) {
                cuadro[x][y].getFicha3().setText("");
                cuadro[x][y].getFicha3().setOpaque(false);
            }
            if (i == 3) {
                cuadro[x][y].getFicha4().setText(nombre);
                cuadro[x][y].getFicha4().setOpaque(true);
                cuadro[x][y].getFicha4().setBackground(color);
            }
            if (i == 7) {
                cuadro[x][y].getFicha4().setText("");
                cuadro[x][y].getFicha4().setOpaque(false);
            }
        
    }
}
