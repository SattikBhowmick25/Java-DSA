import java.util.*;
public class SumSubRanges{
    public static long subArrayRanges(int[] nums) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            int maxVal=nums[i];
            int minVal=nums[i];
            for(int j=0;i<nums.length;i++){
                maxVal=Math.max(maxVal,nums[j]);
                minVal=Math.min(minVal,nums[j]);
                totalSum += (maxVal-minVal);
            }
        }
        return totalSum;
    }
    public long subArrayRanges1(int[] nums) {
        // Calculate the sum of max elements in all subarrays
        long sumOfMax = calculateSubarrayValues(nums);

        // Invert all numbers in nums to find the sum of min elements using the same function
        for (int i = 0; i < nums.length; ++i) {
            nums[i] *= -1;
        }
        long sumOfMin = calculateSubarrayValues(nums);

        // The total sum of subarray ranges is the sum of max elements plus the (inverted) sum of min elements
        return sumOfMax + sumOfMin;
    }

    private long calculateSubarrayValues(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);  // Initialize left bounds for all elements
        Arrays.fill(right, n);  // Initialize right bounds for all elements

        // Calculate the left bounds for each element
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear(); // Clear the stack for the next phase of calculations

        // Calculate the right bounds for each element
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        long sum = 0; // Initialize the sum to aggregate the subarray values
        // Calculate the sum of values using the left and right bounds
        for (int i = 0; i < n; ++i) {
            sum += (long) (i - left[i]) * (right[i] - i) * nums[i];
        }
      
        // Return the total sum of subarray values for either max or min based on the nums state
        return sum;
    }
}

