import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlternateNumbers {
    public static void main(String[] args) {
        int[] nums={-1,10,-5,-20,-15,25};
        alternateNumbers(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void alternateNumbers(int[] nums){
        List<Integer> pos=new ArrayList<>();
        List<Integer> neg=new ArrayList<>();
        int index;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }

        if(pos.size()>neg.size()){
            for(int i=0;i<neg.size();i++){
                nums[2*i]=pos.get(i);
                nums[2*i+1]=neg.get(i);
            }
            
            index=neg.size()*2;
            for(int i=neg.size();i<pos.size();i++){
                nums[index++]=pos.get(i);
            }
        }
        else{
            for(int i=0;i<pos.size();i++){
                nums[2*i]=pos.get(i);
                nums[2*i+1]=neg.get(i);
            }
            
            index=pos.size()*2;
            for(int i=pos.size();i<neg.size();i++){
                nums[index++]=neg.get(i);
            }
        }
    }
}
