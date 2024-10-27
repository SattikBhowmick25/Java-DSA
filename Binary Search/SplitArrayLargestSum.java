public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr={7,2,5,10,8};
        int k=2;
        int ans=splitArray(arr, k);
        System.out.println(ans);
    }
    static int splitArray(int[] nums, int k) {
        int low=max(nums),high=sum(nums);
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int partitions=countSubarrays(nums, mid);
            if(partitions>k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    static int sum(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
    static int max(int[] arr){
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i])      max=arr[i];
        }
        return max;
    }
    static int countSubarrays(int[] arr,int sum){
        int subSum=0,subCount=1;
        for(int i=0;i<arr.length;i++){
            if(subSum+arr[i]<=sum){
                subSum += arr[i];
            }
            else{
                subCount++;
                subSum = arr[i];
            }
        }
        return subCount;
    }
}
