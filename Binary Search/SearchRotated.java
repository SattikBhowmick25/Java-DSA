public class SearchRotated{
    public static void main(String[] args) {
        int[] nums={7,8,9,1,2,3,4,5,6};
        int[] arr={3,1,2,3,3,3};

        int index=searchRotated1(nums, 7);
        System.out.println(index);
        
        boolean srch=searchRotatedDuplicates(arr, 4);
        System.out.println(srch);
    }

    //Only for unique elemnts
    static int searchRotated1(int[] arr,int key){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==key)   return mid;

            if(arr[low]<arr[mid]){
                if(arr[low]<=key && key<=arr[mid])
                    high=mid-1;
                else    low=mid+1;
            }
            else{
                if(arr[mid]<=key && key<=arr[high])
                    low=mid+1;
                else    high=mid-1;
            }
        }
        return -1;
    }

    //For duplicate element
    static boolean searchRotatedDuplicates(int[] arr,int key){
        int low=0,high=arr.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==key)   return true;

            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=key && key<=arr[mid]){
                    high=mid-1;
                }
                else    low=mid+1;
            }
            else{
                if(arr[mid]<=key && key<=arr[high]){
                    low=mid+1;
                }
                else    high=mid-1;
            }
        }
        return false;
    }
}