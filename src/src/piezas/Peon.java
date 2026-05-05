package piezas;

import main.Tablero;

/**
 * Clase para la pieza Peon.
 */
public class Peon extends Pieza {

    public Peon(String color, int filaActual, int columnaActual) {
        super(color, filaActual, columnaActual);
    }

    @Override
    public boolean mover(int filaDestino, int columnaDestino, Tablero tablero) {
        int difFila = filaDestino - getFila();
        int difColumna = Math.abs(columnaDestino - getColumna());

        // Determinamos la dirección según el color
        int direccion = getColor().equalsIgnoreCase("Blanco") ? -1 : 1;
        int filaInicio = getColor().equalsIgnoreCase("Blanco") ? 6 : 1;

        // Avance de 1 casilla
        if (difColumna == 0 && difFila == direccion) {
            setFila(filaDestino);
            setColumna(columnaDestino);
            return true;
        }

        // Avance inicial de 2 casillas
        if (difColumna == 0 && getFila() == filaInicio && difFila == 2 * direccion) {
            setFila(filaDestino);
            setColumna(columnaDestino);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return getColor().equalsIgnoreCase("Blanco") ? "PB" : "PN";
    }
}