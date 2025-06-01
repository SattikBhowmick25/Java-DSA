import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorittyElement {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3,3,3};
        int n=nums.length;
        int[] ls=majorityElementBrute(nums);
        System.out.println(Arrays.toString(ls));
        
        Map<Integer,Integer> mpp=majorityElementBetter(nums);
        for(Integer key:mpp.keySet()){
            if(mpp.get(key)>n/3)
            System.out.println(key+" : "+mpp.get(key));
        }

        ls=majorityElementOptimal(nums);
        System.out.println(Arrays.toString(ls));
    }
    static int[] majorityElementBrute(int[] nums){
        int n=nums.length;
        int maj=n/3;
        int[] ls=new int[n/(maj+1)];
        int k=0;
        
        for(int i=0;i<ls.length;i++){
            ls[i]=-9999;
        }

        for(int i=0;i<n;i++){
            if(k==0 || !search(ls, nums[i])){
                int cnt=0;
                for(int j=0;j<n;j++){
                    if(nums[i]==nums[j]){
                        cnt++;
                    }
                }
                if(cnt>maj){
                    ls[k]=nums[i];
                    k++;
                }
            }
            if(k>=ls.length){
                break;
            }
        }

        return ls;
    }
    static boolean search(int[] nums,int key){
        int mid=nums.length/2;
        int left=0,right=nums.length-1;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==key)
                return true;    
            else if(nums[mid]>key){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return false;
    }

    static Map majorityElementBetter(int[] nums){
        Map<Integer,Integer> mpp=new HashMap<Integer,Integer>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0)+1);
        }
        return mpp;
    }

    static int[] majorityElementOptimal(int[] nums){
        int n=nums.length;
        int[] ls=new int[2];
        int el1=-9999,el2=-9999;
        int cnt1=0,cnt2=0;

        ls[0]=-9999;ls[1]=-9999;

        for(int i=0;i<n;i++){
            if(cnt1==0 && el2!=nums[i]){
                cnt1=1;
                el1=nums[i];
            }
            else if(cnt2==0 && el1!=nums[i]){
                cnt2=1;
                el2=nums[i];
            }
            else if(el1==nums[i])   cnt1++;
            else if(el2==nums[i])   cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]==el1)    cnt1++;
            if(nums[i]==el2)    cnt2++;
        }

        if(cnt1>n/3)    ls[0]=el1;
        if(cnt2>n/3)    ls[1]=el2;
        
        return ls;
    }
}
