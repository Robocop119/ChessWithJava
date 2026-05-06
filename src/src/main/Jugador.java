package main;

/**
 * Clase que representa a un jugador de la partida.
 */
public class Jugador {
    private String nombre;
    private String color;

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }
}