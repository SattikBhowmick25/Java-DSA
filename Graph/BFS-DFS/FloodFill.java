
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int originalColor = image[sr][sc];
        if (originalColor == color)
            return image;

        Queue<int[]> q = new LinkedList<>();

        image[sr][sc] = color;
        q.add(new int[] { sr, sc });

        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] curPx = q.poll();
            int row = curPx[0];
            int col = curPx[1];

            for (int[] d : directions) {
                int nr = row + d[0];
                int nc = col + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == originalColor) {
                    image[nr][nc] = color;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return image;
    }

}
