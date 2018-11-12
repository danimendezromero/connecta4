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
    private char ficha=' ';

    public Casilla() {
        ocupada = false;
    }

    public Casilla(char ficha) {
        this.ficha = ficha;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public char getFicha() {
        return ficha;
    }

    public void setFicha(char ficha) {
        ocupada = true;
        this.ficha = ficha;
    }
}