import java.util.Arrays;
import java.util.Vector;

public class OverlappingIntervals {
    public static void main(String[] args) {
        int[][] sub={{1,3},
                    {2,6},
                    {8,9},
                    {2,4},
                    {9,11},    
                    {16,17},
                    {15,18}};
        sortIntervals(sub);
        for(int i=0;i<sub.length;i++){
            System.out.println(sub[i][0]+"\t"+sub[i][1]);
        }

        Vector<int[]> ans=mergeOverlappingIntervals1(sub);
        System.out.println();
        for(int[] subs:ans){
            System.out.println(Arrays.toString(subs));
        }
    }

    static Vector<int[]> mergeOverlappingIntervals1(int[][] sub){
        int n=sub.length;
        Vector<int[]> ans=new Vector<>();

        sortIntervals(sub);

        for(int i=0;i<n;i++){
            if(ans.isEmpty() || sub[i][0]>ans.lastElement()[1]){
                ans.add(sub[i]);
            }
            else{
                ans.lastElement()[1]=max(ans.lastElement()[1],sub[i][1]);
            }
        }

        return ans;
    }

    static Vector<int[]> mergeOverlappingIntervals(int[][] sub){
        Vector<int[]> ans=new Vector<>();
        int n=sub.length;

        sortIntervals(sub);

        for(int i=0;i<n;i++){
            int start=sub[i][0];
            int end=sub[i][1];

            if(!ans.isEmpty() && end <= ans.lastElement()[1]){
                continue;
            }

            for(int j=i+1;j<n;j++){
                if(sub[j][0] <= end){
                    end=end>sub[j][1]?end:sub[j][1];
                }
                else{
                    break;
                }
            }
            ans.add(new int[]{start,end});
        }
        return ans;
    }
    static void sortIntervals(int[][] sub){
        int n=sub.length;
        int temp;

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(sub[j][0]>sub[j+1][0]){
                    temp=sub[j][0];
                    sub[j][0]=sub[j+1][0];
                    sub[j+1][0]=temp;

                    temp=sub[j][1];
                    sub[j][1]=sub[j+1][1];
                    sub[j+1][1]=temp;
                }
                else if(sub[j][0]==sub[j+1][0]){
                    if(sub[j][1]>sub[j+1][1]){
                        temp=sub[j][0];
                        sub[j][0]=sub[j+1][0];
                        sub[j+1][0]=temp;

                        temp=sub[j][1];
                        sub[j][1]=sub[j+1][1];
                        sub[j+1][1]=temp;
                    }
                }
            }
        }
    }
    static int max(int a,int b){
        if(a>b)     return a;
        else        return b;
    }
}
