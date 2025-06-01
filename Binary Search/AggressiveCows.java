import java.util.Arrays;

public class AggressiveCows{
    public static void main(String[] args) {
        int[] stalls={4,2,1,3,6};
        int cows=2;
        int dist=maxMinDistance(stalls, cows);
        System.out.println(dist);
    }
    static boolean isPossible(int[] stalls,int cows,int dist){
        int cowCount=1;
        int last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=dist){
                cowCount++;
                last=stalls[i];
            }
            if(cowCount>=cows)  return true;
        }
         return false;
    }
    static int maxMinDistance(int[] stalls,int cows){
        Arrays.sort(stalls);
        int low=1,high=stalls[stalls.length-1]-stalls[0];
        int ans=-1;
        while(low<=high){
            int mid=(high+low)/2;
            if(isPossible(stalls, cows, mid)==true){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}