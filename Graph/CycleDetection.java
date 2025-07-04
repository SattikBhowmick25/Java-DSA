import java.util.*;

public class CycleDetection {

    boolean cycleDetection(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int v : adj.get(node)) {
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        if (topo.size() != V) return true;
        return false;
    }

    ArrayList<ArrayList<Integer>> constructAdj(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            int u = edges[0][i];
            int v = edges[1][i];
            adj.get(u).add(v);
        }
        return adj;
    }
}
