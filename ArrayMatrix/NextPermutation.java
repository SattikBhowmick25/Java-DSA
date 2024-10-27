import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums={2,1,5,4,3,0,0};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void nextPermutation(int[] nums){
        int ind=-1;
        int n=nums.length;

        for(int i=n-2;i>=0;i--){
            if (nums[i]<nums[i+1]) {
                ind=i;
                break;
            }
        }

        if(ind==-1){
            reverseArray(nums,0,n-1);
        }

        for(int i=n-1;i>ind;i--){
            if(nums[ind]<nums[i]){
                swap(nums,ind,i);
                break;
            }
        }
        reverseArray(nums,ind+1,n-1);
    }

    static void reverseArray(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
