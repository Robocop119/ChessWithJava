package main;

import piezas.Pieza;
import piezas.Rey;

public class Tablero{
    private Pieza[][] tablero;

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
