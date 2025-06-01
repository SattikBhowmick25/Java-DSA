public class MaxSubarraySum {
    public static void main(String[] args){
        int[] nums={-2,-3,-4,-1,-2,-1,-5,-3};
        int[] maxSumArr=maxSubarraySum(nums);
        for(int i=maxSumArr[1];i<=maxSumArr[2];i++){
            System.out.print("\t"+nums[i]);
        }
        System.out.println();
        System.out.println(maxSumArr[0]);
    }

    static int[] maxSubarraySum(int[] nums){
        int maxSum=-9999;
        int sum=0;
        int start=0,maxStart=0,maxEnd=0;

        for(int i=0;i<nums.length;i++){
            if(sum==0){
                start=i;
            }

            sum+=nums[i];

            if(sum>maxSum){
                maxSum=sum;
                maxStart=start;
                maxEnd=i;
            }

            if(sum<0){
                sum=0;
            }
        }
        if(maxSum<0){
            maxSum=0;
            maxEnd=0;
        }
        return new int[]{maxSum,maxStart,maxEnd};
    }
}
