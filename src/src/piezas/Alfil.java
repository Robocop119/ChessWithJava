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

            // 1. Determinar la dirección del paso en filas y columnas (+1 o -1)
            int pasoFila = (filaDestino > getFila()) ? 1 : -1;
            int pasoColumna = (columnaDestino > getColumna()) ? 1 : -1;

            int filaAux = getFila() + pasoFila;
            int colAux = getColumna() + pasoColumna;

            // 2. Comprobar que el camino esté despejado hasta antes del destino
            while(filaAux != filaDestino && colAux != columnaDestino){
                if(tablero.getTablero()[filaAux][colAux] != null){
                    return false; // El camino está bloqueado
                }
                filaAux += pasoFila;
                colAux += pasoColumna;
            }

            // 3. Comprobar que en el destino no haya una pieza del mismo color
            Pieza piezaDestino = tablero.getTablero()[filaDestino][columnaDestino];
            if(piezaDestino != null && piezaDestino.getColor().equalsIgnoreCase(this.getColor())){
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
        return getColor().equalsIgnoreCase("Blanco") ? "AB" : "AN";
    }
}