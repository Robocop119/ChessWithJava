package piezas;

import main.Tablero;
import interfaces.Movible;

/**
 * Representa una pieza genérica de ajedrez.
 * Esta clase sirve como base para todas las piezas específicas.
 */
public abstract class Pieza implements Movible {
    private String color;
    private int filaActual;
    private int columnaActual;

    public Pieza(String color, int filaActual, int columnaActual){
        this.color = color;
        this.filaActual = filaActual;
        this.columnaActual = columnaActual;
    }

    public String getColor(){
        return this.color;
    }

    public int getFilaActual(){
        return this.filaActual;
    }

    public int getColumnaActual(){
        return this.columnaActual;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setFilaActual(int filaActual){
        this.filaActual = filaActual;
    }

    public void setColumnaActual(int columnaActual){
        this.columnaActual = columnaActual;
    }

    @Override
    public String toString(){
        return this.getColor() + this.getColumnaActual() + this.getFilaActual();
    }

    @Override
    public abstract boolean mover(int filaDestino, int columnaDestino, Tablero tablero);
}