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
        int l=0,r=0,jumpCount=0;
        int n=nums.length;
        while(r<n-1){
            int farthest=0;
            for(int ind=l;ind<=r;ind++){
                farthest=Math.max(farthest, ind+nums[ind]);
            }
            l=r+1;
            r=farthest;
            jumpCount++;
        }
        return jumpCount;
    }
}
