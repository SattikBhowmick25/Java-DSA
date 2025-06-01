import java.util.Arrays;

public class Consecutive {
    public static void main(String[] args) {
        int nums[]={1,100,1,1,2,101,103,4,3,102,5};
        int longest=consecutiveBetter(nums);
        System.out.println(longest);
    }

    static int consecutiveBrute(int[] nums){
        int longest=1;
        int x,cnt;

        for(int i=0;i<nums.length;i++){
            x=nums[i];
            cnt=1;
            while(linearSearch(nums, x+1)==true){
                x++;
                cnt++;
            }
            if(longest<cnt){
                longest=cnt;
            }
        }
        return longest;
    }
    static boolean linearSearch(int[] nums,int key){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key)
                return true;
        }
        return false;
    }

    static int consecutiveBetter(int[] nums){
        Arrays.sort(nums);
        int longest=0;
        int cnt=0;
        int lastSmallest=-9999;

        for(int i=0;i<nums.length;i++){
            if(nums[i]-lastSmallest==1){
                cnt++;
                lastSmallest=nums[i];
            }
            else if(nums[i]-lastSmallest==0){
                
            }
            else{
                lastSmallest=nums[i];
                cnt=1;
            }
            longest=longest>cnt?longest:cnt;
        }
        System.out.println(Arrays.toString(nums));
        return longest;
    }
}
