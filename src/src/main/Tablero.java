package main;

import piezas.Pieza;
import piezas.Rey;
import piezas.Peon;
import piezas.Reina;
import piezas.Torre;
import piezas.Caballo;
import piezas.Alfil;

/**
 * Clase que representa el tablero de ajedrez.
 * Se encarga de gestionar la disposición de las piezas y la visualización del estado del juego.
 */

public class Tablero{
    /** Matriz de 8x8 que contiene las piezas del juego. */
    private Pieza[][] tablero;

    /**
     * Constructor de la clase Tablero.
     * Inicializa una matriz de 8x8 y coloca las piezas iniciales en sus posiciones.
     */
    public Tablero(){
        this.tablero = new Pieza[8][8];

        // Piezas Negras (Fila 0 y 1)
        tablero[0][0] = new Torre("Negro", 0, 0);
        tablero[0][1] = new Caballo("Negro", 0, 1);
        tablero[0][2] = new Alfil("Negro", 0, 2);
        tablero[0][3] = new Reina("Negro", 0, 3);
        tablero[0][4] = new Rey("Negro", 0, 4);
        tablero[0][5] = new Alfil("Negro", 0, 5);
        tablero[0][6] = new Caballo("Negro", 0, 6);
        tablero[0][7] = new Torre("Negro", 0, 7);
        for(int i = 0; i < 8; i++) tablero[1][i] = new Peon("Negro", 1, i);

        // Piezas Blancas (Fila 6 y 7)
        for(int i = 0; i < 8; i++) tablero[6][i] = new Peon("Blanco", 6, i);
        tablero[7][0] = new Torre("Blanco", 7, 0);
        tablero[7][1] = new Caballo("Blanco", 7, 1);
        tablero[7][2] = new Alfil("Blanco", 7, 2);
        tablero[7][3] = new Reina("Blanco", 7, 3);
        tablero[7][4] = new Rey("Blanco", 7, 4);
        tablero[7][5] = new Alfil("Blanco", 7, 5);
        tablero[7][6] = new Caballo("Blanco", 7, 6);
        tablero[7][7] = new Torre("Blanco", 7, 7);
    }

    public Pieza[][] getTablero() {
        return tablero;
    }

    public void setTablero(Pieza[][] tablero) {
        this.tablero = tablero;
    }

    /**
     * Muestra por consola una representación visual del tablero.
     * Recorre la matriz e imprime la inicial de la pieza o un hueco vacío si no hay nada.
     */
    public void mostrarTablero(){
        for(int i=0; i<tablero.length; i++){
            for(int j=0; j< tablero.length; j++){
                if(tablero[i][j] != null){
                    System.out.print("[" + tablero[i][j].toString() + "]");
                }
                else{
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}
