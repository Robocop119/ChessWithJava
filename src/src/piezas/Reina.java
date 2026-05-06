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

            // 1. Determinar la dirección del paso en filas y columnas (-1, 0 o 1)
            int pasoFila = 0;
            if (filaDestino > getFila()) pasoFila = 1;
            else if (filaDestino < getFila()) pasoFila = -1;

            int pasoColumna = 0;
            if (columnaDestino > getColumna()) pasoColumna = 1;
            else if (columnaDestino < getColumna()) pasoColumna = -1;

            int filaAux = getFila() + pasoFila;
            int colAux = getColumna() + pasoColumna;

            // 2. Comprobar que el camino esté despejado hasta antes del destino
            while (filaAux != filaDestino || colAux != columnaDestino) {
                if (tablero.getTablero()[filaAux][colAux] != null) {
                    return false; // El camino está bloqueado
                }
                filaAux += pasoFila;
                colAux += pasoColumna;
            }

            // 3. Comprobar que en el destino no haya una pieza del mismo color
            Pieza piezaDestino = tablero.getTablero()[filaDestino][columnaDestino];
            if (piezaDestino != null && piezaDestino.getColor().equalsIgnoreCase(this.getColor())) {
                return false; // Fuego amigo
            }

            // Si pasa todas las validaciones, ejecutamos el movimiento
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