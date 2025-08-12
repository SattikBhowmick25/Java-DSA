
import java.util.ArrayList;
import java.util.Stack;

class Pair{
    public int _first;
    public int _second;
    public Pair(int _first,int _second){
        this._first=_first;
        this._second=_second;
    }    
}
public class ShortestPatthDAG {
    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] visited, Stack<Integer> st){
        visited[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            if(visited[i]==0){
                topoSort(i,adj,visited,st);
            }
        }
        st.push(node);
    }
    // n->nodes, m->edges
    public int[] shortestPath(int n,int m,int[][] edges){
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Pair> temp=new ArrayList<>();
            adj.add(temp);
        }

        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        int[] visited=new int[n];

        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                topoSort(i, adj, visited, st);
            }
        }

        int[] dist=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int)(1e9);
        }
        dist[0]=0;
        while(!st.isEmpty()){
            int node=st.peek();
            st.pop();

            for(int i=0;i<adj.get(node).size();i++){
                int v=adj.get(node).get(i)._first;
                int wt=adj.get(node).get(i)._second;

                if(dist[node]+wt<dist[v]){
                    dist[v]=dist[node]+wt;
                }

            }
        }

        for(int i=0;i<n;i++){
            if(visited[i]==(int)(1e9)){
                dist[i]=-1;
            }
        }
        return dist;
    }
}
