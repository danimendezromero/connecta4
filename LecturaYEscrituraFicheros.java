/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connecta4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static connecta4.Connecta4.ranking;


/**
 *
 * @author eduardo torres
 */
public interface LecturaYEscrituraFicheros {

    public static void cargaRanking() throws FileNotFoundException, IOException {
        //cargamos el dichero ranking.txt
        FileReader lector = new FileReader("ranking.txt");
        BufferedReader br = new BufferedReader(lector);
        //lo leemos linea por linea
        String linea = br.readLine();
        String[] datos = null;
        //se crea un bucle para cada linea donde si la linea no esta vacia entrara dentro del while
        while (linea != null) {
            datos = linea.split(";");
            Jugador jugadores = new Jugador(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
            // en cada linea se cojeran los valores de nombre, numero de partidas ganadas y numero de tiradas, coje cada valor separandolo por ";"
            ranking.add(jugadores);
            //añadimos cada jugador al arraylist ranking del menu principal
            linea = br.readLine();
            //salto de linea
        }
    }
}
