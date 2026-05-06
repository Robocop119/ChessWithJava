package piezas;

import main.Tablero;

/**
 * Clase para la pieza Caballo.
 */
public class Caballo extends Pieza {

    public Caballo(String color, int filaActual, int columnaActual) {
        super(color, filaActual, columnaActual);
    }

    @Override
    public boolean mover(int filaDestino, int columnaDestino, Tablero tablero) {
        int difFila = Math.abs(filaDestino - getFila());
        int difColumna = Math.abs(columnaDestino - getColumna());

        // Movimiento en L: (2 en uno y 1 en otro) o viceversa
        boolean movimientoL = (difFila == 2 && difColumna == 1) || (difFila == 1 && difColumna == 2);

        if (movimientoL) {

            // El caballo puede saltar piezas, por lo que no comprobamos el camino.
            // Solo debemos comprobar que en el destino no haya una pieza de nuestro propio color.
            Pieza piezaDestino = tablero.getTablero()[filaDestino][columnaDestino];
            if (piezaDestino != null && piezaDestino.getColor().equalsIgnoreCase(this.getColor())) {
                return false; // Fuego amigo
            }

            setFila(filaDestino);
            setColumna(columnaDestino);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return getColor().equalsIgnoreCase("Blanco") ? "CB" : "CN";
    }
}