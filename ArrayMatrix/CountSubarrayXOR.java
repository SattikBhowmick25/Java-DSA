import java.util.HashMap;
import java.util.Map;

public class CountSubarrayXOR {
    public static void main(String[] args) {
        int[] nums={4,2,2,6,4};
        int k=6;
        int count=countSubarrayXOR(nums, k);
        System.out.println(count);
    }
    static int countSubarrayXOR(int[] nums,int k){
        int xor=0;
        Map<Integer,Integer> mpp=new HashMap<Integer,Integer>();
        int count=0;
        
        mpp.put(0, 1);

        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
            int x=xor^k;
            count+=mpp.getOrDefault(x, 0);
            mpp.put(xor,mpp.getOrDefault(xor,0)+1);
        }
        return count;
    }
}
