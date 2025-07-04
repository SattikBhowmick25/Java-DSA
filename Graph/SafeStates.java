import java.util.*;

public class SafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> revGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            revGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // Reverse the graph
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                revGraph.get(v).add(u); // reverse the edge
                indegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        boolean[] safe = new boolean[n];

        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;
            for (int neighbor : revGraph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.add(neighbor);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) result.add(i);
        }

        return result;
    }
}
