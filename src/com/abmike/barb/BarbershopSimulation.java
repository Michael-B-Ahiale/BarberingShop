package com.abmike.barb;
import java.util.Random;
import java.util.Scanner;

public class BarbershopSimulation {
    private static final int MAX_WAITING_CHAIRS = 5;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop(MAX_WAITING_CHAIRS);
        int simulationCount = 0;

        System.out.println("Press space to start a new simulation, or any other key to exit.");

        while (scanner.nextLine().equals(" ")) {
            simulationCount++;
            int x = random.nextInt(4);
            String event;
            boolean clientAdded = false;

            if (x == 0) {
                Client leavingClient = barbershop.removeClient();
                event = leavingClient != null ? "-- " + leavingClient : "-- null";
            } else if (x == 1) {
                clientAdded = barbershop.addClient("VIP");
                event = clientAdded ? "++ VIP" + simulationCount : "+- VIP" + simulationCount;
            } else {
                clientAdded = barbershop.addClient("ORD");
                event = clientAdded ? "++ ORD" + simulationCount : "+- ORD" + simulationCount;
            }

            System.out.printf("%d ---> (%s) %s%n", x, event, barbershop);

            if (simulationCount == 20) {
                break;
            }
        }

        System.out.println("Simulation ended.");
        scanner.close();
    }
}
