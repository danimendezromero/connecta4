/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

/**
 *
 * @author Sergi / comprobacion dani
 */
public class Tablero {

    private Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[4][4];
    }

    public Tablero(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public boolean comprobarTableroLleno() {

        boolean estaLleno = true;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                Ficha f = new Ficha(x, y);
                if (!this.getCasilla(x, y).estaOcupada()) {
                    estaLleno = false;
                }
            }
        }
        return estaLleno;
    }

    public boolean comprobar4() {
        //comprobando que la linea de fila gana alguien
        if(fila()){
            return true;
        }else if(columna()){
            return true;
        }else if(diagonal()){
            return true;
        }else{
            return false;
        }
    }
    //------------------------------------------------------------------------- DANI COMPROBACION

    private boolean fila() { //dani

        boolean fila;
        char aux;
        for (int y = 0; y < 4; y++) {
            fila = true;
            aux = casillas[0][y].getFicha().getCaracter();
            if (aux == ' ') {
                fila = false;
            }
            for (int x = 0; x < 4; x++) {
                if (casillas[x][y].getFicha().getCaracter() != aux) {
                    fila = false;
                }
            }
            if (fila) {
                return fila;
            }
        }

        return false;

    }

    private boolean columna() {
        boolean columna;
        char aux;
        for (int x = 0; x < 4; x++) {
            columna = true;
            aux = casillas[x][0].getFicha().getCaracter();
            if (aux == ' ') {
                columna = false;
            }
            for (int y = 0; y < 4; y++) {
                if (casillas[x][y].getFicha().getCaracter() != aux) {
                    columna = false;
                }
            }
            if (columna) {
                return columna;
            }
        }
        return false;
    }

    private boolean diagonal() {
        if (diagonalLeft()) {
            return true;
        }
        if (diagonalRight()) {
            return true;
        }
        return false;
    }

    private boolean diagonalLeft() {
        if (casillas[0][0].getFicha().getCaracter() == 'X' && casillas[1][1].getFicha().getCaracter() == 'X' && casillas[2][2].getFicha().getCaracter() == 'X' && casillas[3][3].getFicha().getCaracter() == 'X') {
            return true;
        }
        if (casillas[0][0].getFicha().getCaracter() == 'O' && casillas[1][1].getFicha().getCaracter() == 'O' && casillas[2][2].getFicha().getCaracter() == 'O' && casillas[3][3].getFicha().getCaracter() == 'O') {
            return true;
        }
        return false;
    }

    private boolean diagonalRight() {

        if (casillas[3][0].getFicha().getCaracter() == 'X' && casillas[2][1].getFicha().getCaracter() == 'X' && casillas[1][2].getFicha().getCaracter() == 'X' && casillas[0][3].getFicha().getCaracter() == 'X') {

            return true;

        }

        if (casillas[3][0].getFicha().getCaracter() == 'O' && casillas[2][1].getFicha().getCaracter() == 'O' && casillas[1][2].getFicha().getCaracter() == 'O' && casillas[0][3].getFicha().getCaracter() == 'O') {

            return true;

        }

        return false;

    }

//--------------------------------------------------
    public boolean comprobarColumna(int x, Ficha f) {
        boolean columnaLlena = true;
        for (int y = 0; y < 4; y++) {
            if (!casillas[x][y].estaOcupada()) {
                f.setY(y);
                columnaLlena = false;
                insertarFicha(f);
                break;
            }
        }
        return columnaLlena;
    }

    public void insertarFicha(Ficha f) {
        casillas[f.getX()][f.getY()].setFicha(f);
    }

    public Casilla getCasilla(int x, int y) {
        return casillas[x][y];
    }

    public String toString() {
        String txt = "|---|---|---|---|\n";
        for (int y = 3; y >= 0; y--) {
            txt += "|";
            for (int x = 0; x < 4; x++) {
                txt += " " + casillas[x][y].getFicha().getCaracter() + " |";
            }
            txt += "\n";
            txt += "|---|---|---|---|\n";
        }
        return txt;
    }

}
