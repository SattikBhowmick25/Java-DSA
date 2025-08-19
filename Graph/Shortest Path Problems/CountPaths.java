
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
        int node;
        long dist;
        public Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

class CountPaths {

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.dist, y.dist));
        long[] dist = new long[n];
        int[] ways = new int[n];
        int mod = (int)(1e9 + 7);

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair min = pq.poll();
            long dis = min.dist;
            int node = min.node;

            if (dis > dist[node]) continue; // skip outdated entries

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                long edW = it.dist;

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, dist[adjNode]));
                } 
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }

}
