import java.util.Arrays;

public class RearrangeArray {
    public static void main(String[] args) {
        int[] nums={3,2,-1,2,-3,-5,10,-11};
        int[] reArr=rearrangeArray(nums);
        System.out.println(Arrays.toString(reArr));
    }

    //Method to rearrange the positive elements at odd positions and negative elements at even position
    static int[] rearrangeArray(int[] nums){
        int[] ans=new int[nums.length];
        int pos=0,neg=1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                ans[pos]=nums[i];
                pos+=2;
            }
            else{
                ans[neg]=nums[i];
                neg+=2;
            }
        }

        return ans;
    }
}
