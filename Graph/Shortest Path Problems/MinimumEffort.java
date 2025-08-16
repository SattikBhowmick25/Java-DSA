
import java.util.PriorityQueue;

class Tuple{
    int distance,row,col;
    public Tuple(int d,int r,int c){
        distance=d;
        row=r;
        col=c;
    }
}
public class MinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;
        pq.add(new Tuple(0,0,0));
        
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};

        while(!pq.isEmpty()){
            Tuple t=pq.peek();
            pq.remove();

            int diff=t.distance;
            int row=t.row;
            int col=t.col;

            if(row == n-1 && col == m-1) return diff; 

            for(int i=0;i<4;i++){
                int nearR=row+dr[i];
                int nearC=col+dc[i];
                
                if(nearR>=0 && nearR<n && nearC>=0 && nearC<m ){
                    int newEffort=Math.max(Math.abs(heights[row][col]-heights[nearR][nearC]),diff);

                    if(newEffort<dist[nearR][nearC]){
                        dist[nearR][nearC]=newEffort;
                        pq.add(new Tuple(newEffort,nearR,nearC));
                    }
                }
            }
        }
        return 0;
    }
}
