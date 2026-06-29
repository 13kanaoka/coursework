import java.io.*;
import java.util.*;

public class Patrol {
    private List<String[]> edges = new ArrayList<>();  // list of all edges from the input
    private Map<String, Integer> planetIndex = new HashMap<>();  // planet name -> index
    private int[] parent;  // union-find parent array

    // constructor: loads edge data from patrol.txt and prepares graph
    public Patrol() {
        try (Scanner scanner = new Scanner(new File("patrol.txt"))) {
            int index = 0;
            while (scanner.hasNext()) {
                String from = scanner.next();
                String to = scanner.next();
                String cost = scanner.next();
                edges.add(new String[]{from, to, cost});

                // assign a unique index to each planet (if we haven’t already)
                if (!planetIndex.containsKey(from)) planetIndex.put(from, index++);
                if (!planetIndex.containsKey(to)) planetIndex.put(to, index++);
            }
        } catch (IOException e) {
            System.err.println("couldn’t load patrol.txt: " + e.getMessage());
        }
    }

    // find the root of a node in the union-find structure (with path compression)
    private int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    // connect two sets in the union-find structure
    private void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        parent[rootU] = rootV;
    }

    // constructs the minimum spanning tree and prints total cost + edges
    public void patrolEdges() {
        // sort edges by increasing cost
        edges.sort(Comparator.comparingInt(e -> Integer.parseInt(e[2])));

        parent = new int[planetIndex.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;  // initially, each planet is its own set
        }

        int totalCost = 0;
        List<String> patrolRoutes = new ArrayList<>();

        // loop through sorted edges and add to MST if they don’t create a cycle
        for (String[] edge : edges) {
            int u = planetIndex.get(edge[0]);
            int v = planetIndex.get(edge[1]);
            int cost = Integer.parseInt(edge[2]);

            if (find(u) != find(v)) {
                union(u, v);
                totalCost += cost;
                patrolRoutes.add("(" + edge[0] + ", " + edge[1] + ", " + edge[2] + ")");
            }
        }

        // print results in expected format
        System.out.println("Total Cost: " + totalCost);
        System.out.println(String.join(" ", patrolRoutes));
    }
}
