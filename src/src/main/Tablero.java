package main;

import piezas.Pieza;

public class Tablero {
    private Pieza[][] tablero;

    public Tablero(Pieza[][] tablero){
        this.tablero = new Pieza[8][8];
    }

    public Pieza[][] getTablero() {
        return tablero;
    }

    public void setTablero(Pieza[][] tablero) {
        this.tablero = tablero;
    }
}
