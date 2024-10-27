import java.util.Arrays;

public class MergeSortedArr {
    public static void main(String[] args) {
        int[] arr1={1,3,5,7},arr2={0,2,6,8};
        System.out.println(Arrays.toString(arr1)+Arrays.toString(arr2));
        mergeSorted(arr1, arr2);    
        System.out.println(Arrays.toString(arr1)+Arrays.toString(arr2));
    }

    static void mergeSorted(int[] arr1,int[]arr2){
        int n=arr1.length,m=arr2.length;
        int len=m+n;
        int gap=(len/2)+(len%2);
        
        while(gap>0){
            int left=0;
            int right=left+gap;
            while(right<len){
                //arr1 & arr2
                if(left<n && right>=n){
                    swapIfGreater(arr1, arr2, left, right-n);
                }
                //arr2 only
                else if(left>=n){
                    swapIfGreater(arr2, arr2, left-n, right-n);
                }
                //arr1 only
                else{
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            if(gap==1)  break;
            gap=(gap/2)+(gap%2);
        }
    }
    static void swapIfGreater(int[] arr1,int[] arr2,int left,int right){
        if(arr1[left]>arr2[right]){
            int temp=arr1[left];
            arr1[left]=arr2[right];
            arr2[right]=temp;
        }
    }
}
