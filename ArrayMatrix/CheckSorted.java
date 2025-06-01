public class CheckSorted {
    public static void main(String[] args) {
        int[] nums={1,1,1,1};
        boolean check=checkSorted(nums);
        System.out.println(check);
    }

    static boolean checkSorted(int[] nums){
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                count++;
            }
        }
        return count==0;
    }
}
