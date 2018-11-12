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
    
    private String jugador1;
    private String jugador2;
    private int partidasGanadas;
    private int tiradas;
    private String fichaJug1;
    private String fichaJug2;

    public Jugador() {
    }

    public Jugador(String jugador1, String jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fichaJug2 = "X";
        this.fichaJug1 = "0";
        this.partidasGanadas = 0;
        this.tiradas = 0;
    }

    public String getFichaJug1() {
        return fichaJug1;
    }

    public String getFichaJug2() {
        return fichaJug2;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
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
