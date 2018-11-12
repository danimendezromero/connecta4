/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connecta4;

/**
 *
 * @author Dani Méndez Romero
 */
public class Jugador {
    
    private String nombre;
    private int partidasGanadas;
    private int tiradas;
    private Ficha ficha;

    public Jugador() {
    }

    public Jugador(String nombre, int partidasGanadas, int tiradas) {
        this.nombre = nombre;
        this.partidasGanadas = partidasGanadas;
        this.tiradas = tiradas;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
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

    public void setPartidasGanadas(boolean partidaganada) {
        if (partidaganada==true) {
           this.partidasGanadas = this.partidasGanadas+1; 
        }
    }

    public int getTiradas() {
        return tiradas;
    }

    public void setTiradas(int tiradas) {
        this.tiradas=this.tiradas+1;
    }
    
    
    
    
    
}
