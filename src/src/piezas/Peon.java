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

        Pieza piezaDestino = tablero.getTablero()[filaDestino][columnaDestino];

        // Avance de 1 casilla (comprobando que no haya nadie bloqueando)
        if (difColumna == 0 && difFila == direccion) {
            if (piezaDestino == null) {
                setFila(filaDestino);
                setColumna(columnaDestino);
                return true;
            }
        }

        // Avance inicial de 2 casillas (comprobando destino e intermedio vacíos)
        if (difColumna == 0 && getFila() == filaInicio && difFila == 2 * direccion) {
            Pieza piezaIntermedia = tablero.getTablero()[getFila() + direccion][getColumna()];
            if (piezaDestino == null && piezaIntermedia == null) {
                setFila(filaDestino);
                setColumna(columnaDestino);
                return true;
            }
        }

        // Captura en diagonal (solo si hay una pieza enemiga)
        if (difColumna == 1 && difFila == direccion) {
            if (piezaDestino != null && !piezaDestino.getColor().equalsIgnoreCase(this.getColor())) {
                setFila(filaDestino);
                setColumna(columnaDestino);
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return getColor().equalsIgnoreCase("Blanco") ? "PB" : "PN";
    }
}