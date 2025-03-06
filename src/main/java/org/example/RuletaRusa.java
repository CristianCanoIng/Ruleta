package org.example;

import java.util.ArrayList;
import java.util.Random;

public class RuletaRusa {
    private ArrayList<String> jugador;
    private int posicionBala;
    private int posicionActual;
    private Random random;


    public RuletaRusa() {
    }

    public RuletaRusa(ArrayList<String> jugador) {
        this.jugador = jugador;
        this.random = new Random();
        nuevoAleatorio();
    }

    public ArrayList<String> getJugador() {
        return jugador;
    }

    public void setJugador(ArrayList<String> jugador) {
        this.jugador = jugador;
    }

    public int getPosicionBala() {
        return posicionBala;
    }

    public void setPosicionBala(int posicionBala) {
        this.posicionBala = posicionBala;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "RuletaRusa{" +
                "jugadores=" + String.join(", ", jugador) +
                ", posicionBala=" + posicionBala +
                ", posicionActual=" + posicionActual +
                '}';
    }

    public boolean disparar() {
        if (posicionBala == posicionActual) {
            System.out.println("El revolver disparo y el jugador " + jugador.get(0) + " ha muerto.");
            return true;
        } else {
            System.out.println("El revolver no disparo, " + jugador.get(0) + " sigue con vida.");
            posicionActual = (posicionActual + 1) % 6;
            return false;
        }
    }

    public void nuevoAleatorio() {
        posicionBala = random.nextInt(6);
        posicionActual = random.nextInt(6);
        System.out.println("\n ¡Comienza la partida!");
    }

}
