import java.util.*;

public class TravelingSalesman {
    public static void main(String[] args) {
        int[][] distanceMatrix = {
            {0, 2, 9, 10},
            {1, 0, 6, 4},
            {15, 7, 0, 8},
            {6, 3, 12, 0}
        };

        Result result = nearestNeighbor(distanceMatrix);
        System.out.println("Tour: " + result.tour);
        System.out.println("Total Cost: " + result.cost);
    }

    public static Result nearestNeighbor(int[][] distanceMatrix) {
        int n = distanceMatrix.length;
        boolean[] visited = new boolean[n];
        List<Integer> tour = new ArrayList<>();
        int totalCost = 0;
        int currentCity = 0;

        tour.add(currentCity);
        visited[currentCity] = true;

        for (int i = 0; i < n - 1; i++) {
            int nextCity = -1;
            int minDist = Integer.MAX_VALUE;

            for (int city = 0; city < n; city++) {
                if (!visited[city] && distanceMatrix[currentCity][city] < minDist) {
                    minDist = distanceMatrix[currentCity][city];
                    nextCity = city;
                }
            }

            visited[nextCity] = true;
            tour.add(nextCity);
            totalCost += minDist;
            currentCity = nextCity;
        }

        // Return to starting city
        totalCost += distanceMatrix[currentCity][tour.get(0)];
        tour.add(tour.get(0)); // Close the tour

        return new Result(tour, totalCost);
    }

    public static class Result {
        List<Integer> tour;
        int cost;

        public Result(List<Integer> tour, int cost) {
            this.tour = tour;
            this.cost = cost;
        }
    }
}
