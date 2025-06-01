import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FreqSort {
    static String frequencySort(String s) {
        int[] freq=new int[256];
        List<Character> charList=new ArrayList<>();
        String resultStr="";
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }
        
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                charList.add((char)i);
            }
        }
        Collections.sort(charList,(a,b)->freq[b]-freq[a]);
        
        for(char c:charList){
            for(int i=0;i<freq[c];i++){
                resultStr += c;
            }
        }
        return resultStr;
    }
    public static void main(String[] args) {
        String s="tree";
        String ans=frequencySort(s);
        System.out.println(ans);
    }
}
