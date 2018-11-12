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
    private Casilla [][] casillas;

    public Tablero() {
        casillas = new Casilla[4][4];
    }
    
    public Tablero(Casilla[][] casillas) {
        this.casillas = casillas;
    }
    
    public boolean comprobarTableroLleno(){
        boolean estaLleno = true;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
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
        for(int y=0; y <4;y++){
            if(!casillas[x][y].estaOcupada()){
                f.setY(y);
                columnaLlena = false;
                insertarFicha(f);
                break;
            }  
        }
        return columnaLlena;
    }
    public void insertarFicha(Ficha f){
        casillas[f.getX()][f.getY()].setFicha(f);
    }
    public Casilla getCasilla(int x,int y) {
        return casillas[x][y];
    }
    public String toString() {
        String txt = "|---|---|---|---|\n";
        for(int y=3;y>=0;y--){
            txt += "|";
            for(int x=0;x<4;x++){
                txt += " "+casillas[x][y].getFicha().getCaracter()+" |";
            }
            txt +="\n";
            txt +="|---|---|---|---|\n";
        }
        return txt;
    }
    
}