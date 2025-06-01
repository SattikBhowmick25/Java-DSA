public class TrappingRainwater {
    public int trapBrute(int[] height) {
        int trappedWater=0;
        int n=height.length;
        for(int i=0;i<n;i++){
            int j=i;
            int leftMax=0,rightMax=0;
            while(j>=0){
                leftMax=Math.max(leftMax,height[j]);
                j--;
            }
            j=i;
            while(j<n){
                rightMax=Math.max(rightMax,height[j]);
                j++;
            }
            trappedWater += Math.min(leftMax,rightMax)-height[i];
        }
        return trappedWater;
    }

    public int trapBetter(int[] height){
        int n=height.length;
        //Stores the leftMax for each index
        int[] prefix=new int[n];
        //Stores the rightMax for each index
        int[] suffix=new int[n];
        int trappedWater=0;

        prefix[0]=height[0];
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],height[i]);
        }

        suffix[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],height[i]);
        }

        for(int i=0;i<n;i++){
            trappedWater += Math.min(prefix[i],suffix[i])-height[i];
        }
        return trappedWater;
    }
    public int trapOptimal(int[] height){
        int n=height.length;
        int left=0,right=n-1;
        int leftMax=0,rightMax=0;
        int trappedWater=0;

        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }
                else{
                    trappedWater += leftMax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }
                else{
                    trappedWater += rightMax-height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
}
