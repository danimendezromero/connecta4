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
    private int partidasGanadas;
    private int tiradas;

    public Jugador(String nombre, int partidasGanadas, int tiradas) {
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
        this.partidasGanadas = this.partidasGanadas+1;  
    }

    public int getTiradas() {
        return tiradas;
    }

    public void setTiradas() {
        this.tiradas = this.tiradas + 1;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", partidasGanadas=" + partidasGanadas + ", tiradas=" + tiradas + '}';
    }
   

    
    
}
