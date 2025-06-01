public class Peak {
    public static void main(String[] args) {
        int[] arr1={0,2,3,5,8,6,1};
        int[] arr2={1,3,2,3,4,8,7};

        int peak1=singlePeak(arr1);
        int peak2=multiplePeak(arr2);

        System.out.println(peak1);
        System.out.println(peak2);
    }
    static int singlePeak(int arr[]){
        int low,high;

        if(arr.length==1)                          return 0;
        if(arr[0]>arr[1])                          return 0;
        if(arr[arr.length-1]>arr[arr.length-2])    return arr.length-1;

        low=1;
        high=arr.length-2;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])  
                return mid;
            else if(arr[mid]>arr[mid-1])
                low=mid+1;
            else if(arr[mid]>arr[mid+1])
                high=mid-1;
        }
        return -1;
    }

    static int multiplePeak(int[] arr){
        int low,high;

        if(arr.length==1)                           return 0;
        if(arr[0]>arr[1])                           return 0;
        if(arr[arr.length-1]>arr[arr.length-2])     return arr.length-1;

        low=1;  high=arr.length-2;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            else if(arr[mid]>arr[mid-1])
                low=mid+1;
            else if(arr[mid]>arr[mid+1])    
                high=mid-1;
            else
                high=mid-1;
        }
        return -1;
    }
}
