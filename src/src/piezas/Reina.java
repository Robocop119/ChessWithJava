package piezas;

import main.Tablero;

/**
 * Clase para la pieza Reina.
 */
public class Reina extends Pieza {

    public Reina(String color, int filaActual, int columnaActual) {
        super(color, filaActual, columnaActual);
    }

    @Override
    public boolean mover(int filaDestino, int columnaDestino, Tablero tablero) {
        int difFila = Math.abs(filaDestino - getFila());
        int difColumna = Math.abs(columnaDestino - getColumna());

        // Lógica de Torre (recta) O lógica de Alfil (diagonal)
        boolean movimientoRecto = (getFila() == filaDestino || getColumna() == columnaDestino);
        boolean movimientoDiagonal = (difFila == difColumna);

        if ((movimientoRecto || movimientoDiagonal) && difFila + difColumna > 0) {
            setFila(filaDestino);
            setColumna(columnaDestino);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getColor().equalsIgnoreCase("Blanco") ? "QB" : "QN";
    }
}