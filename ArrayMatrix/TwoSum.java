import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = { 1, 10, 5, 20, 25, 12 };
        int k = 15;
        int[] ans = twoSum(nums, k);

        System.out.println(Arrays.toString(ans));
    }

    static int[] twoSum(int[] nums, int k) {
        int sum;
        int[] ans = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (sum == k) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return new int[] { -1, -1 };
    }

    static int[] twoSum2ptr(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum < target) left++;
            else if (sum > target) right--;
            else return new int[] { left, right };
        }
        return new int[] { -1, -1 };
    }
}
