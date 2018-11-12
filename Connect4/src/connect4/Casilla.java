/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

/**
 *
 * @author Mofitex
 */
public class Casilla {
    private boolean ocupada;
    private Ficha ficha;

    public Casilla() {
        ocupada = false;
    }

    public Casilla(Ficha ficha) {
        this.ficha = ficha;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        ocupada = true;
        this.ficha = ficha;
    }
}