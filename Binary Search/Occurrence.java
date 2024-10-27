import java.util.Arrays;

public class Occurrence{
    public static void main(String[] args) {
        int[] nums={1,3,8,8,8,20,25};
        int[] ans=firstLastPosition (nums, 8);
        System.out.println(Arrays.toString(nums));    
        System.out.println(Arrays.toString(ans));    
    }

    static int lowerBound(int[] arr,int x){
        int ans=arr.length;
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else    low=mid+1;
        }
        return ans;
    }
    static int upperBound(int[] arr,int x){
        int ans=arr.length;
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else    low=mid+1;
        }
        return ans;
    }
    static int[] firstLastOccurrence(int[] arr,int x){
        int lb=lowerBound(arr,x);
        int ub=upperBound(arr,x);
        int n=arr.length;
        if(lb==n || arr[lb]!=x)
            return new int[]{-1,-1};
        else
            return new int[]{lb,ub-1};
    }

    static int firstOccurrence(int[] arr,int x){
        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x){
                ans=mid;
                high=mid-1;
            }
            else if(arr[mid]>x) high=mid-1;
            else    low=mid+1;
        }
        return ans;
    }
    static int lastOccurrence(int[] arr,int x){
        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x){
                ans=mid;
                low=mid+1;
            }
            else if(arr[mid]>x) high=mid-1;
            else    low=mid+1;
        }
        return ans;
    }
    static int[] firstLastPosition(int[] arr,int x){
        int first=firstOccurrence(arr, x);
        int last=lastOccurrence(arr, x);
        int count=last-first+1;
        if(first==-1) 
            count=0;
        return new int[]{first,last,count};
    }
}