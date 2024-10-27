import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int nums[]={-2,-2,-2,-1,-1,-1,0,0,0,2,2,2,2};
        Set<List<Integer>> ans=threeSumOptimal(nums, 0);

        System.out.println();
        for(List<Integer> list:ans){
            for(Integer item:list){
                System.out.print(item+"\t");
            }
            System.out.println();
        }
    }
    static Set threeSumOptimal(int[] nums,int s){
        Arrays.sort(nums);
        
        Set<List<Integer>> ans=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])   continue;
            
            int j=i+1,k=nums.length-1;
            
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                
                if(sum<s)   j++;
                else if(sum>s)  k--;
                else{
                    List<Integer> ls=new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);

                    List<Integer> immutable=Collections.unmodifiableList(ls);
                    ans.add(immutable);

                    j++;
                    k--;

                    while(j<k && nums[j]==nums[j-1])    j++;
                    while(j<k && nums[k]==nums[k+1])    k--;
                }   
            }
        }
    return ans;
    }
}
