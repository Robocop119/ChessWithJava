package main;

import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    private String turnoActual; // "Blanco" o "Negro"

    public Juego() {
        this.tablero = new Tablero();
        this.turnoActual = "Blanco";
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        while (true) { // Bucle principal del juego
            tablero.mostrarTablero();
            System.out.println("Turno de: " + turnoActual);

            // 1. Pedir coordenadas (Ej: 6 4 a 4 4)
            // 2. Buscar la pieza en el origen
            // 3. Intentar mover
            // 4. Si el movimiento es válido, cambiar el turno
        }
    }
}