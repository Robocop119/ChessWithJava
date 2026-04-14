package interfaces;

import main.Tablero;

public interface Movible {

    public boolean mover(fila, columna, Tablero);

    /**
     * En esta interfaz el método mover servirá para saber a qué fila
     * y qué columna se mueve la pieza seleccionada.
     */
}
