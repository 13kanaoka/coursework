//This project was completed alone by Matthew Rohde

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // run patrol (mst)
        System.out.println("=== Secure Patrol Routes ===");
        Patrol patrolMission = new Patrol();
        patrolMission.patrolEdges();

        // get user input for start and destination
        System.out.println("\n=== Emergency Travel Planning ===");
        System.out.print("Enter start planet: ");
        String start = sc.nextLine();
        System.out.print("Enter destination planet: ");
        String end = sc.nextLine();

        Travel quickTravel = new Travel();
        quickTravel.quickTravel(start, end);

        // run heuristic
        System.out.println("\n=== Planetary Tour Mapping ===");
        System.out.print("Enter start planet: ");
        start = sc.nextLine();
        Tour galacticTour = new Tour();
        galacticTour.quickTour(start);

        sc.close();
    }
}
