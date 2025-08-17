
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int node,cost;
    public Pair(int node,int cost){
        this.node=node;
        this.cost=cost;
    }
}
class Tuple{
    int stops,node,cost;
    public Tuple(int stops,int node,int cost){
        this.stops=stops;
        this.node=node;
        this.cost=cost;
    }
}
public class CheapestFlight {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int m=flights.length;

        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> q=new LinkedList<>();

        q.add(new Tuple(0, src, 0));

        int[] cost=new int[n];
        for(int i=0;i<n;i++){
            cost[i]=(int)(1e9);
        }

        while(!q.isEmpty()){
            Tuple t=q.peek();
            q.remove();

            int stops=t.stops;
            int node=t.node;
            int cst=t.cost;

            if(stops>k) continue;

            for(Pair it : adj.get(node)){
                int adjNode=it.node;
                int edW=it.cost;

                if(stops<=k && edW+cst<cost[adjNode]){
                    cost[adjNode]=edW+cst;
                    q.add(new Tuple(stops+1,adjNode,cost[adjNode]));
                }
            }
        }

        if(cost[dst]==(int)(1e9))   return -1;
        return cost[dst];
    }
}
