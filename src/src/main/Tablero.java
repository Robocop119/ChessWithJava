package main;

import piezas.Pieza;
import piezas.Rey;

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
        tablero[0][4] = new Rey("Negro", 0, 4);
        tablero[7][4] = new Rey("Blanco", 7, 4);
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
