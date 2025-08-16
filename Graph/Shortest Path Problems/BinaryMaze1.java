
import java.util.LinkedList;
import java.util.Queue;

class Tuple{
    int first,second,third;
    public Tuple(int f,int s,int t){
        first=f;
        second=s;
        third=t;
    }
}

public class BinaryMaze1 {
    public int shortestPath(int[][] maze,int[] source,int[] destination){
        if(source[0]==destination[0] && source[1]==destination[1])  return 0;

        Queue<Tuple> q=new LinkedList<>();
        int n=maze.length;
        int m=maze[0].length;

        int[][] dist=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[source[0]][source[1]]=0;

        q.add(new Tuple(0,source[0],source[1]));
        
        int[] nr={-1,0,1,0};
        int[] nc={0,1,0,-1};

        while(!q.isEmpty()){
            Tuple temp=q.poll();
            q.remove();

            int dis=temp.first;
            int r=temp.second;
            int c=temp.third;

            for(int i=0;i<4;i++){
                int nearR=r+nr[i];
                int nearC=c+nc[i];

                if(nearR>=0 && nearR<n && nearC>=0 && nearC<m && maze[nearR][nearC]==1 && dis+1<dist[nearR][nearC]){
                    dist[nearR][nearC]=dis+1;

                    if(nearR==destination[0] && nearC==destination[1])  return dis+1;

                    q.add(new Tuple(dis+1,nearR,nearC));
                }
            }
        }
        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1; 
        if (n == 1 && m == 1 && grid[0][0] == 0) return 1;

        Queue<Tuple> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        dist[0][0] = 1;  
        q.add(new Tuple(1, 0, 0));

        int[] nr = {-1,-1,0,1,1,1,0,-1};
        int[] nc = {0,1,1,1,0,-1,-1,-1};

        while (!q.isEmpty()) {
            Tuple temp = q.poll();
            int dis = temp.first;
            int r = temp.second;
            int c = temp.third;

            for (int i = 0; i < 8; i++) {
                int nearR = r + nr[i];
                int nearC = c + nc[i];

                if (nearR >= 0 && nearR < n && nearC >= 0 && nearC < m 
                    && grid[nearR][nearC] == 0 && dis + 1 < dist[nearR][nearC]) {

                    dist[nearR][nearC] = dis + 1;

                    if (nearR == n - 1 && nearC == m - 1) return dis + 1;

                    q.add(new Tuple(dis + 1, nearR, nearC));
                }
            }
        }

        return -1;
    }
}
