public class MaxMin {
    public static void main(String[] args) {
        int[] arr={8,9,0,1,2,3,4,5,6};
        int min=minBinSearch(arr);
        int max=maxbinSearch(arr);

        System.out.println(min);
        System.out.println(max);
    }
    static int minBinSearch(int[] arr){
        int min=9999;
        int low=0,high=arr.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid]){
                min=Math.min(min,arr[low]);
                low=mid+1;
            }
            else{
                min=Math.min(min,arr[mid]);
                high=mid-1;
            }
        }
        return min;
    }
    static int maxbinSearch(int[] arr){
        int max=-9999;
        int low=0,high=arr.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid]){
                max=Math.max(max,arr[mid]);
                low=mid+1;
            }
            else{
                max=Math.max(max,arr[high]);
                high=mid-1;
            }
        }
        return max;
    }
}
