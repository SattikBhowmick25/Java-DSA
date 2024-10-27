public class SmallestDivisor{
    public static void main(String[] args) {
        int arr[]={1,1,5,9};
        
        int ans=smallestDivisor(arr, 6);
        
        System.out.println(ans);
    }
    static int smallestDivisor(int[] arr,int threshold){
        int ans=-1;
        int low=1,high=maxElement(arr);
        while(low<=high){
            int mid=low+(high-low)/2;
            int val=sumAll(arr, mid);
            System.out.println(val);
            if(val<=threshold){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    static int ceilDivision(int dividend,int divisor){
        int ceil= (int)(Math.ceil((double)dividend/(double)divisor));
        return ceil;
    }
    static int sumAll(int[] arr,int divisor){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=ceilDivision(arr[i], divisor);
        }
        return sum;
    }
    static int maxElement(int[] arr){
        int max=-9999;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i])  max=arr[i];
        }
        return max;
    }
}