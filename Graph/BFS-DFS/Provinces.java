
import java.util.LinkedList;
import java.util.Queue;

public class Provinces {
    public int findCircleNum(int[][] isConnected) {
        Queue<Integer> q = new LinkedList<>();
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int countProvinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                q.add(i);

                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[node][j] == 1 && !visited[j]) {
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
                countProvinces++;
            }
        }
        return countProvinces;
    }
}
