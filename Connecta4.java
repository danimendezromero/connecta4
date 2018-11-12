/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connecta4;

import java.util.ArrayList;
import static connecta4.LecturaYEscrituraFicheros.cargaRanking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

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
        
        System.out.println("Introduce numero de partidas ganadas:");
        int ganadas = Integer.parseInt(datosUsuario.readLine());
        System.out.println("Introduce numero de tiradas:");
        int tiradas = Integer.parseInt(datosUsuario.readLine());
        String nuevoJugador = nombre + ";" + ganadas + ";" + tiradas;

        //Al llegar a este punto introducimos los datos en el fichero clientes.txt
        //Abrimos el FileWriter y pasamos los datos.
        fichero = new FileWriter("ranking.txt", true);
        bw = new BufferedWriter(fichero);
        bw.write(nuevoJugador);
        bw.newLine();
        bw.close();
        auxJugador = new Jugador(nombre,ganadas, tiradas);
        ranking.add(auxJugador);
        

    }
    public static void muestraMenu() throws IOException {
        //MENU PARA EL USUARIO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("MENU");
            System.out.println("1 - Mostrar Ranking");
            System.out.println("2 - Añadir Jugador al Ranking.");
            System.out.println("3 - Salir.");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    imprimeArrayListRanking();
                    break;
                case 2:
                    ActualizarRanking();
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
    public static void imprimeArrayListRanking() {
        //imprime todos los jugadores del ArrayList ranking.
        Jugador c1 = null;
        for (int i = 0; i < ranking.size(); i++) {
            c1 = ranking.get(i);
            System.out.println(c1.toString());
        }
    }

}
