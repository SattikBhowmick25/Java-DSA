public class BinarySubarraySum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int k) {
        if (k < 0) return 0;
        int left = 0, sum = 0, res = 0;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            // shrink until valid
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            
            // all subarrays ending at right and starting from [left..right]
            res += (right - left + 1);
        }
        
        return res;
    }
}