import java.util.*;

public class UndirectedCycle {
    private boolean detectCycle(int src, int[] visited, List<Integer>[] adj) {
        Queue<int[]> q = new LinkedList<>();
        visited[src] = 1;
        q.add(new int[] { src, -1 });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int parent = cur[1];

            for (int adjNode : adj[node]) {
                if (visited[adjNode] == 0) {
                    q.add(new int[] { adjNode, node });
                    visited[adjNode] = 1;
                } else if (parent != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, List<Integer>[] adj) {
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (detectCycle(i, visited, adj) == true)
                    return true;
            }
        }
        return false;
    }

    private boolean detectCycleDFS(int node, int parent, int[] visited, List<Integer>[] adj) {
        visited[node] = 1;
        for (int adjNode : adj[node]) {
            if (visited[adjNode] == 0) {
                if (detectCycleDFS(adjNode, node, visited, adj) == true)
                    return true;
            } else if (adjNode != parent)
                return true;
        }
        return false;
    }

    public boolean isCycleDFS(int V, List<Integer>[] adj) {
        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (detectCycleDFS(i, -1, visited, adj) == true)
                    return true;
            }
        }
        return true;
    }
}
