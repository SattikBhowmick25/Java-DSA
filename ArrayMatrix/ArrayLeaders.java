import java.util.ArrayList;
import java.util.List;

public class ArrayLeaders{
    public static void main(String[] args) {
        int[] nums={10,22,12,3,0,6};
        List<Integer> leaders=arrayLeaders(nums);
        for(Integer item:leaders){
            System.out.println(item);
        }
    }

    static List<Integer> arrayLeaders(int[] nums){
        List<Integer> leaders=new ArrayList<>();
        int max=-9999;
        for(int i=nums.length-1;i>=0;i--){
            if(max<nums[i]){
                max=nums[i];
                leaders.add(nums[i]);
            }
        }
        return leaders;
    }
}