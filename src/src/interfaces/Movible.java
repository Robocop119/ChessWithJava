package interfaces;

import main.Tablero;

public interface Movible {
    /**
     * En esta interfaz el método mover servirá para saber a qué fila
     * y qué columna se mueve la pieza seleccionada.
     */
    public boolean mover(int filaDestino, int columnaDestino, Tablero tablero);
}
