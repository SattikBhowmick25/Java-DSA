public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] nums={1,0,1,4,3,3,5,5,3};
        int len;
        //len=longestSubarrayWithSumK(nums, 16);
        len=getLongestSubarray(nums,16);
        System.out.println(len);
    }

    static int longestSubarrayWithSumK(int[] nums,int k){
        int[] preSumMap=new int[nums.length];
        int sum=0;
        int maxLen=0;

        //Initializing preSumMap
        for(int i=0;i<preSumMap.length;i++){
            preSumMap[i]=-9999;
        }

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=sum-k;
            if(sum==k){
                maxLen=Math.max(maxLen,i+1);
            }
            if(getKey(preSumMap,rem)!=-1){
                int len=i-getKey(preSumMap,rem);
                maxLen=Math.max(maxLen,len);
            }
            if(i==0 || preSumMap[i-1]!=sum){
                preSumMap[i]=sum;
            }
        }
        return maxLen;
    }
    static int getKey(int[] map,int key){
        int loc=-1;
        for(int i=0;i<map.length;i++){
            if(map[i]==key){
                loc=i;
                return loc;
            }
        }
        return loc;
    }

    static int getLongestSubarray(int[] nums,int k){
        int left=0,right=0;
        int n=nums.length;
        int sum=0;
        int maxLen=0;

        while(right<n){
            while(left<=right && sum>k){
                sum-=nums[left];
                left++;
            }
            if(sum==k){
                maxLen=Math.max(maxLen,right-left+1);
            }
            if(right<n && sum<k){
                sum+=nums[right];
            }
            right++;
        }

        return maxLen;
    }
}
