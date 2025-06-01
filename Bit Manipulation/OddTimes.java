import java.util.Arrays;

public class OddTimes {
    public static int[] singleNumber(int[] nums) {        
        long xor=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }

        int rightMost=(int)((xor&(xor-1))^xor);

        int b1=0,b2=0;

        for(int i=0;i<nums.length;i++){
            if((rightMost&nums[i])>0)
                b1=b1^nums[i];
            else    
                b2=b2^nums[i];

        }
        return new int[]{b1,b2};
    }
    public static void main(String[] args) {
        int[] nums={2,4,2,3,14,7,3,7};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }
}
