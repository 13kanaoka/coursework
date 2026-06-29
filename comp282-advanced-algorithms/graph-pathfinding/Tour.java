import java.io.*;
import java.util.*;

public class Tour {
    private Map<String, Map<String, Integer>> graph = new HashMap<>();  // adjacency map of planet connections
    private List<String> planets = new ArrayList<>();  // list of all planet names

    // constructor: reads travel.txt and builds a directed graph
    public Tour() {
        try (Scanner scanner = new Scanner(new File("travel.txt"))) {
            while (scanner.hasNext()) {
                String from = scanner.next();
                String to = scanner.next();
                int weight = scanner.nextInt();

                // store travel time in directed adjacency map
                graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, weight);

                // keep track of unique planet names
                if (!planets.contains(from)) planets.add(from);
                if (!planets.contains(to)) planets.add(to);
            }
        } catch (IOException e) {
            System.err.println("couldn't load travel.txt: " + e.getMessage());
        }
    }

    // estimates the shortest tour path using nearest neighbor strategy
    public void quickTour(String start) {
        if (!graph.containsKey(start)) {
            System.out.println("start planet not found: " + start);
            return;
        }

        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        String current = start;
        int totalCost = 0;

        visited.add(current);
        path.add(current);

        // continue choosing the closest unvisited planet
        while (visited.size() < planets.size()) {
            String next = null;
            int minDist = Integer.MAX_VALUE;

            Map<String, Integer> neighbors = graph.getOrDefault(current, new HashMap<>());
            for (Map.Entry<String, Integer> entry : neighbors.entrySet()) {
                String candidate = entry.getKey();
                int cost = entry.getValue();

                if (!visited.contains(candidate) && cost < minDist) {
                    minDist = cost;
                    next = candidate;
                }
            }

            if (next == null) {
                System.out.println("couldn't complete tour from current path: " + path);
                return;
            }

            totalCost += minDist;
            current = next;
            visited.add(current);
            path.add(current);
        }

        // return to starting planet if a route exists
        if (graph.getOrDefault(current, new HashMap<>()).containsKey(start)) {
            totalCost += graph.get(current).get(start);
            path.add(start);
        } else {
            System.out.println("no path to return to starting planet: " + start);
            return;
        }

        // display results
        System.out.println("Path: " + String.join(", ", path));
        System.out.println("Total Tour Time: " + totalCost);
    }
}
