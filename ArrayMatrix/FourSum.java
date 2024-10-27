import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public static void main(String[] args) {
        int nums[]={1,0,-1,0,-2,2};
        Set<List<Integer>> ans=fourSum(nums, 0);
        for(List<Integer> ls:ans){
            System.out.println();
            for(Integer item:ls){
                System.out.print(item+"\t");
            }
        }
        System.out.println("\n");

        List<int[]> ans2=fourSumOptimal(nums, 0);
        for(int[] quad:ans2){
            System.out.println(Arrays.toString(quad));
        }
    }
    static Set<List<Integer>> fourSum(int[] nums,int target){
        Set<List<Integer>> ans=new HashSet<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer> st=new HashSet<>();
                for(int k=j+1;k<n;k++){ 
                    int sum=nums[i]+nums[j]+nums[k];
                    int fourth=target-sum;
                    if(st.contains(fourth)){
                        List<Integer> ls=new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[k]);
                        ls.add(fourth);
                        Collections.sort(ls);
                        ans.add(ls);
                    }
                    st.add(nums[k]);
                }
            }
        }
        return ans;
    }

    static List<int[]> fourSumOptimal(int[] nums,int target){
        List<int[]> ans=new ArrayList<int[]>();
        int n=nums.length;

        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])   continue;

            for(int j=i+1;j<n;j++){
                if(j!=i+1 && nums[j]==nums[j-1])    continue;
                
                int k=j+1;
                int l=n-1;
                while(k<l){
                    int sum=nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        int[] quad={nums[i],nums[j],nums[k],nums[l]};
                        ans.add(quad);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1])    k++;
                        while(k<l && nums[l]==nums[l+1])    l--;
                    }
                    else if(sum<target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}
