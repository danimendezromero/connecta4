/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import java.util.ArrayList;
import static connect4.LecturaYEscrituraFicheros.cargaRanking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author eduardo torres
 */
public class Connecta4 implements LecturaYEscrituraFicheros {

    static ArrayList<Jugador> ranking = new ArrayList();
    static Jugador auxJugador;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // llamamos a los metodos

        muestraMenu();
    }

    public static void muestraMenu() throws IOException {
        //MENU PARA EL USUARIO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("MENU");
            System.out.println("1 - Jugar.");
            System.out.println("2 - Mostrar Ranking.");
            System.out.println("3 - Salir.");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    Tablero t = crearTablero();

                    jugar(t);
                    break;
                case 2:

                    imprimeArrayListRanking();
                    break;
                case 3:
                    System.out.println("Se ha salido del programa con éxito.");
                    break;

                default:
                    System.out.println("Valor incorrecto.");
                    break;
            }

        }
    }

    public static void imprimeArrayListRanking() throws IOException {
        cargaRanking();
        //imprime todos los jugadores del ArrayList ranking.
        Jugador c1 = null;
        for (int i = 0; i < ranking.size(); i++) {
            c1 = ranking.get(i);
            System.out.println(c1.toString());
        }
        ranking.clear();
    }

    public static Tablero crearTablero() {
        Casilla[][] board = new Casilla[4][4];

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                Casilla occupiedSquare = new Casilla();
                board[x][y] = occupiedSquare;
            }
        }
        Tablero t = new Tablero(board);
        return t;
    }

    public static void jugar(Tablero t) throws FileNotFoundException, IOException {
        boolean encontrado = false;
        boolean encontrado2 = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del jugador 1");
        String nombre1 = sc.nextLine();
        int numGanadas1 = 0, numGanadas2 = 0;
        int tiradas1 = 0, tiradas2 = 0;

        FileReader lector = new FileReader("ranking.txt");
        BufferedReader br = new BufferedReader(lector);
        //lo leemos linea por linea
        String linea = br.readLine();
        String[] datos = null;
        //se crea un bucle para cada linea donde si la linea no esta vacia entrara dentro del while
        while (linea != null) {
            datos = linea.split(";");
            Jugador jugadores = new Jugador(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
            if (nombre1.equals(datos[0])) {
                encontrado = true;
                nombre1 = datos[0];
                numGanadas1 = Integer.parseInt(datos[1]);
                tiradas1 = Integer.parseInt(datos[2]);
                break;
            } else {

                linea = br.readLine();
                //salto de linea
            }
        }
        if (encontrado == false) {

            Jugador j1 = new Jugador(nombre1, numGanadas1, tiradas1);
        } else {
            System.out.println("Welcome back " + nombre1);

        }
        Jugador j1 = new Jugador(nombre1, numGanadas1, tiradas1);
        System.out.println("Introduce el nombre del jugador 2");
        String nombre2 = sc.nextLine();

        FileReader lector2 = new FileReader("ranking.txt");
        BufferedReader br2 = new BufferedReader(lector2);
        //lo leemos linea por linea
        String linea2 = br2.readLine();
        String[] datos2 = null;
        //se crea un bucle para cada linea donde si la linea no esta vacia entrara dentro del while
        while (linea2 != null) {
            datos2 = linea2.split(";");
            Jugador jugadores2 = new Jugador(datos2[0], Integer.parseInt(datos2[1]), Integer.parseInt(datos2[2]));
            if (nombre2.equals(datos2[0])) {
                encontrado2 = true;
                nombre2 = datos2[0];
                numGanadas2 = Integer.parseInt(datos2[1]);
                tiradas2 = Integer.parseInt(datos2[2]);
                break;
            } else {

                linea2 = br.readLine();
                //salto de linea
            }
        }
        if (encontrado2 == false) {

            Jugador j2 = new Jugador(nombre2, numGanadas2, tiradas2);
        } else {
            System.out.println("Welcome back player 2");

        }
        Jugador j2 = new Jugador(nombre2, numGanadas2, tiradas2);
        boolean bien = false;
        char ficha1 = ' ';
        char ficha2 = ' ';
        while (!bien) {
            System.out.println("Jugador1 escoje ficha (X/O)");
            ficha1 = sc.next().charAt(0);
            if (ficha1 == 'X' || ficha1 == 'O') {
                bien = true;
                if (ficha1 == 'X') {
                    ficha2 = 'O';
                } else {
                    ficha2 = 'X';
                }

            } else {
                System.out.println("Aprende a escribir.");
            }
        }

        boolean win = false;
        while (!win) {

            System.out.println(t.toString());
            System.out.println("Jugador 1: Introduce la columna para insertar ficha (1-4)");
            int x1 = sc.nextInt();
            while (x1 > 4 || x1 < 1) {
                System.out.println("Jugador 1: Introduce la columna para insertar ficha CORRECTAMENTE (1-4)");
                x1 = sc.nextInt();
            }
            x1--;
            sc.nextLine();
            Ficha f = new Ficha(ficha1, x1, 0);
            t.comprobarColumna(x1, f);
            j1.setTiradas();
            win = t.comprobar4();

            if (win) {
                System.out.println("Ha ganado el jugador 1!");
                j1.setPartidasGanadas();
                ArrayList<Jugador> sobreescribir = new ArrayList();
                boolean encontrado3 = false;
                FileReader lector3 = new FileReader("ranking.txt");
                BufferedReader br3 = new BufferedReader(lector3);
                //lo leemos linea por linea
                String linea3 = br3.readLine();
                String[] datos3 = null;
                //se crea un bucle para cada linea donde si la linea no esta vacia entrara dentro del while
                while (linea3 != null) {
                    datos3 = linea3.split(";");
                    Jugador jugadores3 = new Jugador(datos3[0], Integer.parseInt(datos3[1]), Integer.parseInt(datos3[2]));
                    if (j1.getNombre().equals(datos3[0])) {
                        int numGanadas = j1.getPartidasGanadas();
                        int tiradas = j1.getTiradas();
                        jugadores3 = new Jugador(datos3[0], numGanadas, tiradas);
                        encontrado3 = true;
                        sobreescribir.add(jugadores3);
                    } else {

                        sobreescribir.add(jugadores3);
                    }

                    linea3 = br3.readLine();
                    //salto de linea
                }
                if (encontrado3 != true) {
                    Jugador j3 = new Jugador(j1.getNombre(), j1.getPartidasGanadas(), j1.getTiradas());
                    Jugador j4 = new Jugador(j2.getNombre(), j2.getPartidasGanadas(), j2.getTiradas());
                    sobreescribir.add(j3);
                    sobreescribir.add(j4);
                } else {
                }
                System.out.println(j1.toString());
                Jugador c1 = null;
                FileWriter fichero2 = null;
                BufferedWriter bw2 = null;
                fichero2 = new FileWriter("ranking.txt");
                bw2 = new BufferedWriter(fichero2);

                for (int i = 0; i < sobreescribir.size(); i++) {
                    c1 = sobreescribir.get(i);
                    String nombre = c1.getNombre();
                    int numGanadas = c1.getPartidasGanadas();
                    int tiradas = c1.getTiradas();
                    String JugadorCompleto = nombre + ";" + numGanadas + ";" + tiradas;
                    FileWriter fichero = null;
                    BufferedWriter bw = null;
                    fichero = new FileWriter("ranking.txt", true);
                    bw = new BufferedWriter(fichero);
                    bw.write(JugadorCompleto);
                    bw.newLine();
                    bw.close();
                }

            } else {

                System.out.println(t.toString());
                System.out.println("Jugador 2: Introduce la columna para insertar ficha (1-4)");
                int x2 = sc.nextInt();
                while (x2 > 4 || x2 < 1) {
                    System.out.println("Jugador 2: Introduce la columna para insertar ficha CORRECTAMENTE (1-4)");
                    x2 = sc.nextInt();
                }
                x2--;
                sc.nextLine();
                Ficha f2 = new Ficha(ficha2, x2, 0);
                t.comprobarColumna(x2, f2);
                j2.setTiradas();
                win = t.comprobar4();

                if (win) {
                    System.out.println("Ha ganado el jugador 2!");
                    j2.setPartidasGanadas();

                    ArrayList<Jugador> sobreescribir = new ArrayList();
                    boolean encontrado3 = false;
                    FileReader lector3 = new FileReader("ranking.txt");
                    BufferedReader br3 = new BufferedReader(lector3);
                    //lo leemos linea por linea
                    String linea3 = br3.readLine();
                    String[] datos3 = null;
                    //se crea un bucle para cada linea donde si la linea no esta vacia entrara dentro del while
                    while (linea3 != null) {
                        datos3 = linea3.split(";");
                        Jugador jugadores3 = new Jugador(datos3[0], Integer.parseInt(datos3[1]), Integer.parseInt(datos3[2]));
                        if (j2.getNombre().equals(datos3[0])) {
                            int numGanadas = j2.getPartidasGanadas();
                            int tiradas = j2.getTiradas();
                            jugadores3 = new Jugador(datos3[0], numGanadas, tiradas);
                            encontrado3 = true;
                            sobreescribir.add(jugadores3);
                        } else {
                            sobreescribir.add(jugadores3);
                        }

                        linea3 = br3.readLine();
                        //salto de linea
                    }
                    
                    if (encontrado3 != true) {
                        Jugador j3 = new Jugador(j2.getNombre(), j2.getPartidasGanadas(), j2.getTiradas());
                        sobreescribir.add(j3);
                        Jugador j4 = new Jugador(j1.getNombre(), j1.getPartidasGanadas(), j1.getTiradas());
                        sobreescribir.add(j4);
                    }
                    System.out.println(j2.toString());
                    Jugador c1 = null;
                    FileWriter fichero2 = null;
                    BufferedWriter bw2 = null;
                    fichero2 = new FileWriter("ranking.txt");
                    bw2 = new BufferedWriter(fichero2);
                    for (int i = 0; i < sobreescribir.size(); i++) {
                        c1 = sobreescribir.get(i);
                        String nombre = c1.getNombre();
                        int numGanadas = c1.getPartidasGanadas();
                        int tiradas = c1.getTiradas();
                        String JugadorCompleto = nombre + ";" + numGanadas + ";" + tiradas;
                        FileWriter fichero = null;
                        BufferedWriter bw = null;
                        fichero = new FileWriter("ranking.txt", true);
                        bw = new BufferedWriter(fichero);
                        bw.write(JugadorCompleto);
                        bw.newLine();
                        bw.close();
                    }
                } else {
                    if (t.comprobarTableroLleno()) {
                        break;
                    }
                }

            }

        }

    }
}
