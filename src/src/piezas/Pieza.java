package piezas;

import main.Tablero;
import interfaces.Movible;

/**
 * Representa una pieza genérica de ajedrez.
 * Esta clase sirve como base para todas las piezas específicas.
 */
public abstract class Pieza implements Movible {
    private String color;
    private int fila;
    private int columna;

    public Pieza(String color, int fila, int columna){
        this.color = color;
        this.fila = fila;
        this.columna = columna;
    }

    public String getColor(){
        return this.color;
    }

    public int getFila(){
        return this.fila;
    }

    public int getColumna(){
        return this.columna;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setFila(int fila){
        this.fila = fila;
    }

    public void setColumna(int columna){
        this.columna = columna;
    }

    @Override
    public String toString(){
        return this.getColor() + this.getColumna() + this.getFila();
    }

    @Override
    public abstract boolean mover(int filaDestino, int columnaDestino, Tablero tablero);
}