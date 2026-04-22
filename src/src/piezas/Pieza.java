package piezas;

import interfaces.Movible;

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
}