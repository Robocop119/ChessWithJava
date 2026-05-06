package main;

import java.util.Scanner;
import piezas.Pieza;

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

            // Intentar mover 
            if (p.mover(fDest, cDest, tablero)) {
                // Actualizar la matriz del tablero -> gestiona la captura automáticamente
                tablero.getTablero()[fDest][cDest] = p;
                tablero.getTablero()[fOrig][cOrig] = null;

                // Alternar turno
                turnoActual = turnoActual.equalsIgnoreCase("Blanco") ? "Negro" : "Blanco";
                System.out.println("¡Movimiento realizado con éxito!");
            } else {
                System.out.println("Error: Movimiento no válido para esta pieza.");
            }
        }
    }
}