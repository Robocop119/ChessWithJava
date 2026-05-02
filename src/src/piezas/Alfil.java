package piezas;

import main.Tablero;

/**
 * Clase que representa la pieza del Alfil
 */
public class Alfil extends Pieza {

    public Alfil(String color, int filaActual, int columnaActual){
        super(color, filaActual, columnaActual);
    }

    @Override
    public boolean mover(int filaDestino, int columnaDestino, Tablero tablero){
        int difFila = Math.abs(filaDestino - getFila());
        int difColumna = Math.abs(columnaDestino - getColumna());

        // El alfil se mueve en diagonal: la diferencia de filas debe ser igual a la de columnas
        // También nos aseguramos de que realmente se haya movido (difFila > 0)
        if(difFila == difColumna && difFila > 0){
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