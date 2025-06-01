import java.util.HashMap;
import java.util.Map;

public class CharReplace{
    static int longestSequence(String str,int k){
        int maxj=0;
        int change=0;
        int len=0;

        for(int i=0;i<str.length();i++){
            Map<Character,Integer> map = new HashMap<>();
            for(int j=i;j<str.length();j++){
                map.put( str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1 );
                maxj=Math.max(maxj, map.getOrDefault(str.charAt(j), 0));
                change=(j-i+1)-maxj;
                if(change<=k){
                    len=Math.max(len, j-i+1);
                }
                else    
                    break;
            }
        }
        return len;
    }
    //Time-O(N)     Space-O(1)
    static int longestSequenceOptimised(String str,int k){
        int left=0,right=0;
        int maxF=0,len=0,change=0;
        Map<Character,Integer> map=new HashMap<>();
        
        while(right<str.length()){
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0)+1);
            maxF=Math.max(maxF,map.getOrDefault(str.charAt(right), 0));
            change=(right-left+1)-maxF;
            if(change>k){
                map.put(str.charAt(left), map.getOrDefault(str.charAt(left), 0)-1);
                if(map.getOrDefault(str.charAt(left), 0)==0){
                    map.remove(str.charAt(left));
                }
                left++;
            }
            if(change<=k){
                len=Math.max(len,right-left+1);
            }
            right++;
        }
        return len;
    }
    public static void main(String[] args) {
        String str="AABABBA";
        int len=longestSequenceOptimised(str, 1);
        System.out.println(len);
    }
}