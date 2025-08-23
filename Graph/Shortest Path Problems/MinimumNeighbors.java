public class MinimumNeighbors {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Step 1: Initialize distance matrix
        int[][] dist = new int[n][n];
        final int INF = 1000000; // Large number representing infinity

        // Fill matrix: 0 for same city, infinity for no direct connection
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // Step 2: Add direct edges to the matrix
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight; // Bidirectional roads
        }

        // Step 3: Floyd-Warshall - try each city as intermediate point
        for (int k = 0; k < n; k++) { // Intermediate city
            for (int i = 0; i < n; i++) { // Source city
                for (int j = 0; j < n; j++) { // Destination city
                    // If path through k is shorter, update distance
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 4: Find city with minimum reachable cities within threshold
        int resultCity = 0;
        int minReachableCities = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            // Update result (>= handles tie-breaking with larger index)
            if (reachableCount <= minReachableCities) {
                minReachableCities = reachableCount;
                resultCity = i;
            }
        }

        return resultCity;
    }
}
