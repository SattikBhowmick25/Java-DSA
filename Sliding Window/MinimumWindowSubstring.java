import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    static String minWindow(String s,String t){
        int n=s.length(),m=t.length();
        Map<Character,Integer> map=new HashMap<>();
        int sIndex=-1;
        int minLen=Integer.MAX_VALUE;
        int left=0,right=0;
        int count=0;

        for(int i=0;i<m;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i), 0)+1);
        }

        while(right < n){
            if(map.getOrDefault(s.charAt(right), 0)>0){
                count++;
            }
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right), 0)-1);
            while(count==m){
                if(right-left+1 < minLen){
                    sIndex=left;
                    minLen=right-left+1;
                }
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left), 0)+1);
                if(map.getOrDefault(s.charAt(left), 0)>0)   
                    count--;
                left++;
            }
            right++;
        }
        if(sIndex==-1)
        return "";
        return s.substring(sIndex, sIndex+minLen);
    }   
    public static void main(String[] args) {
        String s="ADOBECODEBANC",t="ABC";
        String minSubstr=minWindow(s, t);
        System.out.println(minSubstr);
    }
}
