package piezas;

import main.Tablero;

/**
 * Clase para la pieza Torre.
 */
public class Torre extends Pieza {

    public Torre(String color, int filaActual, int columnaActual) {
        super(color, filaActual, columnaActual);
    }

    @Override
    public boolean mover(int filaDestino, int columnaDestino, Tablero tablero) {
        int difFila = Math.abs(filaDestino - getFila());
        int difColumna = Math.abs(columnaDestino - getColumna());

        // Movimiento rectilíneo: o cambia la fila o cambia la columna
        boolean esRecto = (getFila() == filaDestino || getColumna() == columnaDestino);

        if (esRecto && (difFila + difColumna > 0)) {
            setFila(filaDestino);
            setColumna(columnaDestino);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return getColor().equalsIgnoreCase("Blanco") ? "TB" : "TN";
    }
}