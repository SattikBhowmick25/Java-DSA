class CountNiceSubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
       return maxNiceK(nums,k)-maxNiceK(nums,k-1);
    }
    private int maxNiceK(int[] nums,int k){
        int left=0,right=0;
        int count=0;
        int nice=0;
        int n=nums.length;
        while(right<n){
            if(nums[right]%2==1)    count++;
            while(count>k){
                if(nums[left]%2==1) count--;
                left++;
            }
            nice+=(right-left+1);
            right++;
        }
        return nice;
    }
}