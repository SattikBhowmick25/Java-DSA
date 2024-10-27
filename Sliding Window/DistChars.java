import java.util.HashMap;
import java.util.Map;

public class DistChars{
    static int distinctCharSequence(String s,int k){
        int left=0,right=0;
        int len=0;
        Map<Character,Integer> map=new HashMap<>();

        while(right < s.length()){
            char rCh=s.charAt(right);
            map.put(rCh,map.getOrDefault(rCh, 0)+1);

            if(map.size() > k){
                char lCh=s.charAt(left);
                map.put(lCh, map.getOrDefault(lCh, 0)-1);
                
                if(map.getOrDefault(lCh, 0) == 0)
                    map.remove(lCh);
                
                left++;
            }
            if(map.size() <= k){
                len=Math.max(len,right-left+1);
            }
            right++;
        }

        return len;
    }
    public static void main(String[] args) {
        String s="aaabbccd";
        int maxLen=distinctCharSequence(s, 2);
        System.out.println(maxLen);
    }
}