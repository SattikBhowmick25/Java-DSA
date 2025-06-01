import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayOperations {
    public static void main(String[] args) {
        int[] arr1={1,3,4,5};
        //int[] arr2={3,5,10,15};
        //int[] nums={0,1,0,3,12};
        //int[] dist={2,2,0,1,1,0,0,1,2,0};
        //int[] merged=mergeSorted(arr1,arr2);
        int[] ones={1,1,0,0,1,1,1,0,1,1,1,1};
        int[] oneTwo={1,1,10,3,3,4,4};
        /*System.out.println(Arrays.toString(merged));
        shiftZeros(nums);
        System.out.println(Arrays.toString(nums));
        int d=smallestDistancePair(dist,3);
        System.out.println(d);*/
        //rotate(arr1,2);
        //rotateArrayLeft(arr1,2);
        int count=consOnes(ones);
        System.out.println(count);
        int onceNum=onceTwice(oneTwo);
        System.out.println(onceNum);
        int missing=missingNum(arr1);
        System.out.println(missing);
    }
    static int[] mergeSorted(int[] arr1,int[] arr2){
        int i,j,k;
        int[] merged=new int[arr1.length+arr2.length];
        
        i=j=k=0;
        
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
              merged[k++]=arr1[i++];
            }
            else{
                merged[k++]=arr2[j++];
            }
        }

        while(i<arr1.length && j==arr2.length){
            merged[k++]=arr1[i++];
        }
        while(i==arr1.length && j<arr2.length){
            merged[k++]=arr2[j++];
        }
        return merged;
    }
    static void shiftZeros(int[] nums){
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
        }

        while(i<nums.length){
            nums[i++]=0;
        }
    }

    static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[j]=nums[i];
        nums[j]=temp;
    }

    public static int smallestDistancePair(int[] nums, int k) {
        List<Integer> dist=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int dif=abs(nums[i]-nums[j]);
                //if(!dist.contains(dif))
                    dist.add(dif);
            }
        }

        Collections.sort(dist);
        if(k>=dist.size()){
            k=dist.size();
        }
        int min=dist.get(k-1);
        return min;
    }
    public static int abs(int a){
        if(a>0)
            return a;
        else
            return -a;
    }
    
    static void rotateArray(int[] nums,int k){
        int[] temp=Arrays.copyOf(nums, nums.length);

        for(int i=0;i<nums.length;i++){
            nums[(i+k)%nums.length]=temp[i];
        }
    }
    static void rotate(int[] nums, int k){
        int n=nums.length;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    static void rotateArrayLeft(int[] nums,int k){
        int[] temp=Arrays.copyOf(nums, nums.length);
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            nums[(i-k+n)%n]=temp[i];
        }
    }
    static int consecutiveOnes(int[] nums){
        int count=0,iCount=0,j=1,i;
        if(nums.length==1){
            if(nums[0]==1)
                return 1;
        }
        while(j<nums.length){
            for(i=j;i<nums.length;i++){
                j++;
                if(nums[i-1]==nums[i] && nums[i]==1)
                    iCount++;
                else    
                    break;
            }

            if(count<iCount)
                count=iCount;
        }
        return count;
    }

    static int consOnes(int[] nums){
        int count=0,iCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                iCount++;
                count=count>iCount?count:iCount;
            }
            else{
                iCount=0;
            }
        }
        return count;
    }
    static int onceTwice(int[] nums){
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans=ans^nums[i];
        }
        return ans;
    }
    static int missingNum(int[] nums){
        int ans;
        int xor1=0,xor2=0;
        for(int i=0;i<nums.length;i++){
            xor2=xor2^nums[i];
            xor1=xor1^(i+1);
        }
        xor1=xor1^(nums.length+1);
        ans=xor1^xor2;
        return ans;
    }
}
