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