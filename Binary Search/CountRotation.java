public class CountRotation{
    public static void main(String[] args) {
        int[] arr={6,8,9,1,2,3,4,5};
        int count=countRotation(arr);
        System.out.println(count);
    }
    static int countRotation(int[] arr){
        int low=0,high=arr.length-1;
        int min=9999;
        int count=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid]){
                if(arr[low]<=min){
                    min=arr[low];
                    count=low;
                }
                low=mid+1;
            }
            else{
                if(arr[mid]<=min){
                    min=arr[mid];
                    count=mid;
                }
                high=mid-1;
            }
        }
        return count;
    }
}