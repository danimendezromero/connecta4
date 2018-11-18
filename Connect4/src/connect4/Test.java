/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

/**
 *
 * @author sergi
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Casilla[][] board = new Casilla[7][6];

        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 6; y++) {
                Casilla occupiedSquare = new Casilla();
                board[x][y] = occupiedSquare;
            }
        }
        Tablero t = new Tablero(board);
        System.out.println(t.toString());
    }
}
