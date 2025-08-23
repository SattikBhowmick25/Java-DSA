import java.util.*;

class Pair {
    int node, time;

    public Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

public class networkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // construct adjacency list for 1-indexed graph
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // directed edges
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        // min-heap (based on time)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        dist[k] = 0;

        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int node = temp.node;
            int time = temp.time;

            for (Pair it : adj.get(node)) {
                int t = it.time;
                int adjNode = it.node;

                if (time + t < dist[adjNode]) {
                    dist[adjNode] = time + t;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        int maxMinTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9)
                return -1;
            maxMinTime = Math.max(maxMinTime, dist[i]);
        }
        return maxMinTime;
    }
}
