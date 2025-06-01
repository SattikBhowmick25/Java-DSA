import java.util.HashMap;
import java.util.Map;


public class Fruitbasket{
    static int maxTrees(int[] arr,int k){
        int maxLen=0;
        int l=0,r=0;
        Map<Integer,Integer> map=new HashMap<>();

        while(r<arr.length){
            map.put(arr[r],map.getOrDefault(arr[r], 0)+1);
            if(map.size()>k){
                if( (map.get(arr[l])-1) == 0){
                    map.remove(arr[l]);
                }
                else{
                    map.put(arr[l], map.get(arr[l])-1);
                }
                l++;
            }
            if(map.size()<=k){
                maxLen=Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr={3, 1, 2, 2, 2, 2};
        int maxLen=maxTrees(arr, 2);
        System.out.println(maxLen);
    }
}