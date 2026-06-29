import java.io.*;
import java.util.*;

public class Travel {
    private Map<String, List<Edge>> graph = new HashMap<>();  // adjacency list representation of the graph

    // constructor: reads travel.txt and builds a directed weighted graph
    public Travel() {
        try (Scanner scanner = new Scanner(new File("travel.txt"))) {
            while (scanner.hasNext()) {
                String from = scanner.next();
                String to = scanner.next();
                int weight = scanner.nextInt();

                // store each directed edge
                graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, weight));
            }
        } catch (IOException e) {
            System.err.println("couldn't load travel.txt: " + e.getMessage());
        }
    }

    // finds the shortest path from start to end using dijkstra’s algorithm
    public void quickTravel(String start, String end) {
        Map<String, Integer> dist = new HashMap<>();  // tracks shortest known distances
        Map<String, String> prev = new HashMap<>();   // tracks previous node in shortest path

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));
        dist.put(start, 0);

        // explore the graph
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.node.equals(end)) break;
            if (!graph.containsKey(current.node)) continue;

            for (Edge neighbor : graph.get(current.node)) {
                int newDist = dist.get(current.node) + neighbor.weight;

                // update path if this route is better
                if (!dist.containsKey(neighbor.node) || newDist < dist.get(neighbor.node)) {
                    dist.put(neighbor.node, newDist);
                    prev.put(neighbor.node, current.node);
                    pq.add(new Edge(neighbor.node, newDist));
                }
            }
        }

        // if destination unreachable, print message
        if (!dist.containsKey(end)) {
            System.out.println("No available route from " + start + " to " + end + ".");
            return;
        }

        // reconstruct the path from end → start using prev map
        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        // print final results in the required format
        System.out.println("Path: " + String.join(", ", path));
        System.out.println("Total Travel Time: " + dist.get(end));
    }

    // class to represent an edge to a neighbor planet and its travel time
    static class Edge {
        String node;
        int weight;

        Edge(String node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
