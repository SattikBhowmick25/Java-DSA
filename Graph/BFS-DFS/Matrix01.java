
import java.util.*;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new int[] { i, j });
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int row = cur[0];
            int col = cur[1];

            for (int[] d : dir) {
                int nr = row + d[0];
                int nc = col + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (dist[nr][nc] > dist[row][col] + 1) {
                        dist[nr][nc] = dist[row][col] + 1;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
        }
        return dist;
    }
}
