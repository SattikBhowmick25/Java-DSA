//Find the minimum number of days to make m bouquets with k consecutive bloomed flowers
public class Bouquets {
    public static void main(String[] args) {
        int[] arr={7,7,7,7,13,11,12,7};
        int days=findMinimumDays(arr, 2, 3);
        System.out.println(isPossible(arr, 12,2,3));
        System.out.println(days);
    }
    static int findMax(int[] arr){
        int max=-9999;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i])      max=arr[i];
        }
        return max;
    }
    static int findMin(int[] arr){
        int min=9999;
        for(int i=0;i<arr.length;i++){
            if(min>arr[i])      min=arr[i];
        }
        return min;
    }

    static boolean isPossible(int[] arr,int days,int m,int k){
        int count=0;
        int bouquets=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=days){
                count++;
            }
            else{
                bouquets+=count/k;
                count=0;
            }
        }
        bouquets+=count/k;

        if(bouquets>=m)     return true;
        else                return false;
    }

    static int findMinimumDays(int[] arr,int m,int k){
        int low=findMin(arr);
        int high=findMax(arr);
        if((arr.length/k)<m)
            return -1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(arr, mid, m, k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
