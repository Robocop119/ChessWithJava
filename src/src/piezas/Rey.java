package piezas;

import main.Tablero;

/**
 * Clase para la pieza Rey.
 */
public class Rey extends Pieza {

    public Rey(String color, int filaActual, int columnaActual) {
        super(color, filaActual, columnaActual);
    }

    @Override
    public boolean mover(int filaDestino, int columnaDestino, Tablero tablero) {
        int difFila = Math.abs(filaDestino - getFila());
        int difColumna = Math.abs(columnaDestino - getColumna());

        if (difFila <= 1 && difColumna <= 1 && !(difFila == 0 && difColumna == 0)) {

            // Comprobar que en el destino no haya una pieza del mismo color
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
        return getColor().equalsIgnoreCase("Blanco") ? "RB" : "RN";
    }
}