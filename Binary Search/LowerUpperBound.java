//import java.util.Arrays;
import java.util.Scanner;

public class LowerUpperBound{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            /*System.out.print("Enter size:");
            int size=sc.nextInt();
            int[] nums=new int[size];
            System.out.println("Enter array elements:");
            for(int i=0;i<size;i++){
                nums[i]=sc.nextInt();
            }   
            System.out.println(Arrays.toString(nums));

            System.out.print("Enter n:");
            int n=sc.nextInt();*/ 

            int n=15;
            int[] nums={1,3,4,5,10,12};
            int ans=searchCeil(nums, n);
            System.out.println(ans);
        }
    }

    static int lowerBound(int[] nums,int n){
        int ans=nums.length;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=n){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
    static int upperBound(int[] nums,int n){
        int ans=nums.length;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>n){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
    /*You are given a sorted array 'arr" of distinct values and a target value 'm' You need to search for the index of the target value in the array.
    If the value is present in the array, then return its index
    If the value is not present, determine the index where it would be inserted in the array while maintaining the sorted order. */
    static int searchInsertPosition(int nums[],int n){
        int ans=nums.length;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=n){
                ans=mid;
                high=mid-1;
            }
            else    low=mid+1;
        }
        return ans;
    }
    static int searchFloor(int nums[],int n){
        int floor=-1;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<n){
                floor=mid;
                low=mid+1;
            }
            else    high=mid-1;
        }
        return floor;
    }
    static int searchCeil(int[] nums,int n){
        int ceil=nums.length;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>n){
                ceil=mid;
                high=mid-1;
            }
            else    low=mid+1;
        }
        return ceil;
    }
}