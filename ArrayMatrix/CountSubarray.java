import java.util.HashMap;
import java.util.Map;

public class CountSubarray {
    public static void main(String[] args) {
        int[] nums={1,2,3,-3,1,1,1,4,2,-3};
        int cnt=countSubArray(nums, 3);
        System.out.println(cnt);
    }
    static int countSubArray(int[] nums,int k){
        Map<Integer,Integer> mpp=new HashMap<Integer,Integer>();
        mpp.put(0,1);
        int preSum=0,cnt=0;
        int remove;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            remove=preSum-k;
            cnt += mpp.getOrDefault(remove, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}
