public class PerfectSum {
    public int perfectSum(int[] nums, int target) {
        int n=nums.length;
        int count=countSubsequences(nums,n,target,0);
        return count;
    }
    public static int countSubsequences(int[] nums,int n,int target,int sum){
        if(n==0){
            return sum==target?1:0;
        }
        int countExclude=countSubsequences(nums,n-1,target,sum);
        int countInclude=countSubsequences(nums,n-1,target,sum+nums[n-1]);
        return countExclude+countInclude;
    }
}
