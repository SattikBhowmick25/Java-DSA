import java.util.HashMap;
import java.util.Map;

public class Anagram {
    static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;

        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
                if(map.get(t.charAt(i)) == 0)
                    map.remove(t.charAt(i));
            }
        }
        System.out.println(map.size());
        if(map.size()==0)   return true;
        else return false;
    }
    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        boolean ans=isAnagram(s,t);
        System.out.println(ans);
    }
}
