/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

/**
 *
 * @author dani mendez
 */
public class Jugador {
    private String nombre;
    private int partidasGanadas=0;
    private int tiradas=0;
    private char Ficha;
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(String nombre,int partidasGanadas,int tiradas){
        this.nombre = nombre;
        this.partidasGanadas = partidasGanadas;
        this.tiradas = tiradas;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas() {
        this.partidasGanadas++;  
    }

    public int getTiradas() {
        return tiradas;
    }

    public void setTiradas() {
        this.tiradas++;
    }
    
    public char getFicha() {
        return Ficha;
    }

    public void setFicha(char Ficha) {
        this.Ficha = Ficha;
    }
    @Override
    public String toString() {
        return "Nick: "+nombre+ ", Partidas Ganadas: "+partidasGanadas+", Tiradas: "+tiradas;
    }
   

    
    
}
