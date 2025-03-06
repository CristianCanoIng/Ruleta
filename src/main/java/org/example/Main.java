package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadJugadores;
        do {
            System.out.print("\n¿Cuántas personas van a jugar? (min 2, max 6): ");
            cantidadJugadores = scanner.nextInt();
            scanner.nextLine();
        } while (cantidadJugadores < 2 || cantidadJugadores > 6);

        RuletaRusa ruleta = new RuletaRusa(new ArrayList<>());

        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
            ruleta.getJugador().add(scanner.nextLine());
        }

        System.out.println("\nJugadores en el juego:");
        for (String jugador : ruleta.getJugador()) {
            System.out.println("|| " + jugador + " ||");
        }

        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            System.out.println("\nTurno de " + ruleta.getJugador().get(0));
            System.out.print("Presiona Enter para disparar ");
            scanner.nextLine();

            if (ruleta.disparar()) {
                ruleta.getJugador().remove(0);
                juegoTerminado = true;
            } else {
                ruleta.getJugador().add(ruleta.getJugador().remove(0));
            }
        }

        System.out.println("\nSe acabo el juego y el ganador es: " + ruleta.getJugador().get(0));
        scanner.close();
    }
}
