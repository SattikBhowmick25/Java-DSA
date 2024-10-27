import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSub{
    //Time-O(n^2)   Space-O(n)
    static int findLenBrute(String str){
        if(str.length()==0){
            return 0;
        }
        int maxAns=Integer.MIN_VALUE;
        for(int i=0;i<str.length();i++){
            Set<Character> se = new HashSet<>();
            for(int j=i;j<str.length();j++){
                if(se.contains(str.charAt(j))){
                    maxAns=Math.max(maxAns,j-i);
                    break;
                }
                se.add(str.charAt(j));
            }
        }
        return maxAns;
    }
    static int findLenOptimised1(String str){
        if(str.length()==0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int maxAns=Integer.MIN_VALUE;
        int l=0;
        for(int r=0;r<str.length();r++){
            if(set.contains(str.charAt(r))){
                while(l<r && set.contains((str.charAt(r)))){
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxAns=Math.max(maxAns, r-l+1);
        }
        return maxAns;
    }
    static int findLenOptimised2(String str){
        int left=0,right=0;
        int len=0;
        int n=str.length();
        HashMap<Character,Integer> map =  new HashMap<>();
        while (right<n) {
            if(map.containsKey(str.charAt(right)))
                left = Math.max(left,map.get(str.charAt(right))+1);
            
            map.put(str.charAt(right),right);

            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
    public static void main(String[] args) {
        String str="takeuforward";
        int maxAns=findLenBrute(str);
        int maxAns1=findLenOptimised1(str);
        int maxAns2=findLenOptimised2(str);
        System.out.println(str+" "+maxAns);
        System.out.println(str+" "+maxAns1);
        System.out.println(str+" "+maxAns2);
    }
}