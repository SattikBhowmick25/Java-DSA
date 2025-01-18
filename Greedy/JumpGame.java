public class JumpGame {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int maxJump=0;
        for(int i=0;i<n;i++){
            if(i>maxJump){
                return false;
            }
            maxJump=Math.max(maxJump,i+nums[i]);
        }
        return true;
    }
    public int jump(int[] nums) {
        int n=nums.length;
        int maxJump=0;
        int jumpCount=0;
        for(int i=0;i<n;i++){
            if(i>maxJump){
                return -1;
            }
            if(maxJump<i+nums[i]){
                jumpCount++;
            }
        }
        return jumpCount;
    }
}
