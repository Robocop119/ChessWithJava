package piezas;

import main.Tablero;
import interfaces.Movible;
import piezas.Pieza;

/**
 * Clase que representa la pieza del Rey en el ajedrez.
 */

public class Rey extends Pieza {
    public Rey(String color, int filaActual, int columnaActual){
        super(color, filaActual, columnaActual);
    }

    @Override
    public boolean mover(int filaDestino, int columnaDestino, Tablero tablero){
        int difFila = Math.abs(filaDestino - getFila());
        int difColumna = Math.abs(columnaDestino - getColumna());

        if(difFila <= 1 && difColumna <= 1 && !(difFila == 0 && difColumna == 0)){
            setFila(filaDestino);
            setColumna(columnaDestino);
            return true;
        }

        return false;
    }
}
