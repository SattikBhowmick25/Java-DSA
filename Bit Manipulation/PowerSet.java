import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int subsets=1<<n;
        List<List<Integer>> powerSet=new ArrayList<>();
        for(int num=0;num<subsets;num++){
            List<Integer> sub=new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num&(1<<i))>0){
                    sub.add(nums[i]);
                }
            }
            powerSet.add(sub);
        }
        return powerSet;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> powerSet=subsets(nums);
        for(List<Integer> subs:powerSet){
            System.out.print("{ ");
            for(int item:subs){
                System.out.print(item+" ");
            }
            System.out.println("}");
        }
    }
}
