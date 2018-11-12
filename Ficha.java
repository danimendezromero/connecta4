/**
 *
 * @author Oriol Mainou
 */
public class Ficha {
    private char caracter;
    private int x;
    private int y;

    public Ficha() {
    }

    public Ficha(char caracter, int x, int y) {
        this.caracter = caracter;
        this.x = x;
        this.y = y;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
