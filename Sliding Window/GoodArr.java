import java.util.HashMap;
import java.util.Map;

public class GoodArr {
    static int goodSubarrLE(int[] arr,int k){
        int left=0,right=0;
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();

        if(k < 0)   return 0;

        while(right < arr.length){
            map.put(arr[right],map.getOrDefault(arr[right], 0)+1);

            while(map.size() > k){
                map.put(arr[left], map.getOrDefault(arr[left], 0)-1);
                if(map.getOrDefault(arr[left], 0) == 0)
                    map.remove(arr[left]);
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;
    }
    //Time-O(N)     Space-O(N)
    static int goodSubarr(int[] arr,int k){
        return (goodSubarrLE(arr, k)-goodSubarrLE(arr, k-1));
    }
}
