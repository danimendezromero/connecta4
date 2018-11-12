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
        
        cargaRanking();
        muestraMenu();
    }

    public static void ActualizarRanking() throws IOException {
        //Abro el lector de consola
        BufferedReader datosUsuario = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fichero = null;
        BufferedWriter bw = null;
        System.out.println("Introduce su nombre:");
        String nombre = datosUsuario.readLine();
        auxJugador = new Jugador(nombre);
        String nuevoJugador = nombre + ";" + auxJugador.getPartidasGanadas() + ";" + auxJugador.getTiradas();

        //Al llegar a este punto introducimos los datos en el fichero clientes.txt
        //Abrimos el FileWriter y pasamos los datos.
        fichero = new FileWriter("ranking.txt", true);
        bw = new BufferedWriter(fichero);
        bw.write(nuevoJugador);
        bw.newLine();
        bw.close();
        
        ranking.add(auxJugador);
    }
    public static void muestraMenu() throws IOException {
        //MENU PARA EL USUARIO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int opcion = 0;

        while (opcion != 4) {
            System.out.println("MENU");
            System.out.println("1 - Jugar.");
            System.out.println("2 - Añadir Jugador al Ranking.");//no deberia existir
            System.out.println("3 - Mostrar Ranking.");
            System.out.println("4 - Salir.");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    Tablero t = crearTablero();
                    jugar(t);
                    break;
                case 2:
                    ActualizarRanking();
                    break;

                case 3:
                    imprimeArrayListRanking();
                    break;
                case 4:
                    System.out.println("Se ha salido del programa con éxito.");
                    break;
                       
                default:
                    System.out.println("Valor incorrecto.");
                    break;
            }

        }
    }
    public static void imprimeArrayListRanking() {
        //imprime todos los jugadores del ArrayList ranking.
        Jugador c1 = null;
        for (int i = 0; i < ranking.size(); i++) {
            c1 = ranking.get(i);
            System.out.println(c1.toString());
        }
    }
    public static Tablero crearTablero(){
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
    public static void jugar(Tablero t){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del jugador 1");
        String nombre1 = sc.nextLine();
        //leer fichero buscando el nombre
        /*
        if(value==nombre1){
            System.out.println("Welcome back player 1");
            Jugador j1 = new Jugador(nombre,partidasGanadas,tiradas);
        }
        */
        Jugador j1 = new Jugador(nombre1);
        System.out.println("Introduce el nombre del jugador 2");
        String nombre2 = sc.nextLine();
        //leer fichero buscando el nombre
        /*
        if(value==nombre2){
            System.out.println("Welcome back player 2");
            Jugador j2 = new Jugador(nombre,partidasGanadas,tiradas);
        }
        */
        Jugador j2 = new Jugador(nombre2);
        
        boolean bien=false;
        char ficha1=' ';
        char ficha2=' ';
        while(!bien){
            System.out.println("Jugador1 escoje ficha (X/O)");
            ficha1 = sc.next().charAt(0);
            if(ficha1=='X' || ficha1=='O'){
                bien=true;
                if(ficha1=='X'){
                    ficha2 = 'O';
                }else{
                    ficha2 = 'X';
                }
               
            }else{
                System.out.println("Aprende a escribir.");
            }
        }
        
        boolean win=false;
        while(!win){
            System.out.println(t.toString());
            System.out.println("Jugador 1: Introduce la columna para insertar ficha (1-4)");
            int x1 = sc.nextInt();
            x1--;
            sc.nextLine();
            Ficha f = new Ficha(ficha1,x1,0);
            t.comprobarColumna(x1, f);
            j1.setTiradas();
            win = t.comprobar4();
            if(win){
                System.out.println("Ha ganado el jugador 1!");
                j1.setPartidasGanadas();
                //Guardar en fichero
                /*
                    j1.getNombre();
                    j1.getPartidasGanadas();
                    j1.getTiradas();
                */
            }else{
              System.out.println(t.toString());
                System.out.println("Jugador 2: Introduce la columna para insertar ficha (1-4)");
                int x2 = sc.nextInt();
                x2--;
                sc.nextLine();
                Ficha f2 = new Ficha(ficha2,x2,0);
                t.comprobarColumna(x2, f2);
                j2.setTiradas();
                win = t.comprobar4();
                if(win){
                    System.out.println("Ha ganado el jugador 2!");
                    j2.setPartidasGanadas();
                    //Guardar en fichero
                    /*
                        j1.getNombre();
                        j1.getPartidasGanadas();
                        j1.getTiradas();
                    */
                }  
            }
            
        }
        
    }
}
