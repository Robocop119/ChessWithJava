package main;

import java.util.Scanner;
import piezas.Pieza;
import piezas.Rey;

/**
 * Clase que controla el flujo principal de la partida.
 */
public class Juego {
    private Tablero tablero;
    private String turnoActual;

    public Juego() {
        this.tablero = new Tablero();
        this.turnoActual = "Blanco";
    }

    /**
     * Inicia el bucle principal del juego por consola.
     */
    public void iniciar() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            tablero.mostrarTablero();
            System.out.println("\nTurno de: " + turnoActual);

            // Pedir coordenadas de origen
            System.out.print("Introduce fila origen (0-7): ");
            int fOrig = sc.nextInt();
            System.out.print("Introduce columna origen (0-7): ");
            int cOrig = sc.nextInt();

            // Refinamiento: Validar que las coordenadas estén dentro del tablero
            if (fOrig < 0 || fOrig > 7 || cOrig < 0 || cOrig > 7) {
                System.out.println("Error: Coordenadas de origen fuera del tablero.");
                continue;
            }

            // Validar si hay una pieza del color correcto
            Pieza p = tablero.getTablero()[fOrig][cOrig];
            if (p == null || !p.getColor().equalsIgnoreCase(turnoActual)) {
                System.out.println("Error: No hay una pieza de tu color en esa casilla.");
                continue;
            }

            // Pedir coordenadas de destino
            System.out.print("Introduce fila destino (0-7): ");
            int fDest = sc.nextInt();
            System.out.print("Introduce columna destino (0-7): ");
            int cDest = sc.nextInt();

            // Refinamiento: Validar que las coordenadas estén dentro del tablero
            if (fDest < 0 || fDest > 7 || cDest < 0 || cDest > 7) {
                System.out.println("Error: Coordenadas de destino fuera del tablero.");
                continue;
            }

            // Intentar mover
            if (p.mover(fDest, cDest, tablero)) {

                // Refinamiento: Comprobar si en el destino hay un Rey para terminar la partida
                Pieza piezaDestino = tablero.getTablero()[fDest][cDest];
                boolean finDePartida = (piezaDestino instanceof Rey);

                // Actualizar la matriz del tablero -> gestiona la captura automáticamente
                tablero.getTablero()[fDest][cDest] = p;
                tablero.getTablero()[fOrig][cOrig] = null;

                if (finDePartida) {
                    tablero.mostrarTablero();
                    System.out.println("¡Jaque Mate / Rey Capturado! Han ganado las piezas: " + turnoActual);
                    break; // Terminamos el bucle while
                }

                // Alternar turno
                turnoActual = turnoActual.equalsIgnoreCase("Blanco") ? "Negro" : "Blanco";
                System.out.println("¡Movimiento realizado con éxito!");
            } else {
                System.out.println("Error: Movimiento no válido para esta pieza.");
            }
        }

        // Refinamiento: Cerrar el escáner al terminar el juego
        sc.close();
    }

    /**
     * Punto de entrada principal del programa.
     */
    public static void main(String[] args) {
        Juego partida = new Juego();
        partida.iniciar();
    }
}