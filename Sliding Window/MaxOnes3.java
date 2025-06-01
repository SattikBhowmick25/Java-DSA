import java.util.Arrays;

public class MaxOnes3 {
    //Time-O(2n) Space-O(1)
    static int maxOnes(int[] arr,int k){
        int maxLen=0;
        int l=0,r=0;
        int zeros=0;

        while(r<arr.length){
            if(arr[r]==0)   zeros++;

            while(zeros>k){
                if(arr[l]==0)    zeros--;
                l++;
            }

            if(zeros<=k){
                maxLen=Math.max(maxLen,r-l+1);
                r++;
            }
        }
        return maxLen;
    }
    //Time-O(n) Space-O(1)
    static int maxOnesBetter(int[] arr,int k){
        int len=0,maxLen=0;
        int l=0,r=0;
        int zeros=0;

        while(r<arr.length){
            if(arr[r]==0)   zeros++;

            if(zeros>k){
                if(arr[l]==0)   zeros--;
                l++;
            }

            if(zeros<=k){
                len=r-l+1;
                maxLen=Math.max(maxLen,len);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr={1,1,1,0,0,0,1,1,1,1,0};
        int maxOnes1=maxOnes(arr, 2);
        int maxOnes2=maxOnesBetter(arr, 2);
        System.out.println(Arrays.toString(arr));
        System.out.println(maxOnes1+" "+maxOnes2);
    }
}
