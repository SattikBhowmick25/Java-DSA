public class MajorityElement {
    public static void main(String[] args) {
        int[] nums={10,8,10,10,2,1,8,1,10};
        int maj=majorityElement(nums);
        System.out.println(maj);
    }

    static int majorityElement(int[] nums){
        int el=-1;
        int count=0,count1=0;

        //Applying Moore's Voting Algorithm
        for(int i=0;i<nums.length;i++){
            if(count==0){
                el=nums[i];
            }
            else if(el==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }

        //Checking if the element is majority element
        for(int i=0;i<nums.length;i++){
            if(nums[i]==el)
                count1++;
        }
        if(count1>(nums.length/2))
            return el;
        else 
            return -1;
    }
    
}
