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
public class Tablero {
    private Casilla [][] casillas;

    public Tablero() {
        casillas = new Casilla[7][6];
    }
    
    public Tablero(Casilla[][] casillas) {
        this.casillas = casillas;
    }
    
    public boolean comprobarTableroLleno(){
        boolean estaLleno = true;
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 6; y++) {
                Ficha f = new Ficha(x, y);
                if (!this.getCasilla(x,y).estaOcupada()) {
                    estaLleno = false;
                } 
            }
        }
        return estaLleno;
    }
    public boolean comprobar4(){
        return false;
    }
    public boolean comprobarColumna(int x, Ficha f){
        boolean columnaLlena = true;
        for(int y=0; y <=6;y++){
            if(!casillas[x][y].estaOcupada()){
                columnaLlena = false;
                insertarFicha(f);
            }  
        }
        return columnaLlena;
    }
    public void insertarFicha(Ficha f){
        casillas[f.getX()][f.getY()].setFicha(f.getCaracter());
    }
    public Casilla getCasilla(int x,int y) {
        return casillas[x][y];
    }
    public String toString() {
        String txt = "|---|---|---|---|---|---|---|\n";
        for(int y=5;y>=0;y--){
            txt += "|";
            for(int x=0;x<7;x++){
                txt += " "+casillas[x][y].getFicha()+" |";
            }
            txt +="\n";
            txt +="|---|---|---|---|---|---|---|\n";
        }
        return txt;
    }
    
}