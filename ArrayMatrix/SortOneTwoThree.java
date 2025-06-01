import java.util.Arrays;

public class SortOneTwoThree {
    public static void main(String[] args) {
        int[] nums={1,0,0,1,2,0,2,1,0};
        sortOneTwoThree(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void sortOneTwoThree(int[] nums){
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,mid,low);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
    static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
