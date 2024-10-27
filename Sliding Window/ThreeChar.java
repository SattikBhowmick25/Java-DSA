import java.util.HashMap;

public class ThreeChar{
    static int numberOfSubstrings(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0,right=0;
        int n=str.length();
        int count=0;

        map.put('a',0);
        map.put('b',0);
        map.put('c',0);

        while(right<str.length()){
            char rch=str.charAt(right);
            map.put(rch, map.get(rch)+1);
            
            while(map.get('a')>=1 && map.get('b')>=1 && map.get('c')>=1){
                count += n-right;
                char lch=str.charAt(left);
                map.put(lch,map.get(lch)-1);
                left++;
            }
            right++;
        }
        return count;
    }
    static int numberOfSubstringsBetter(String str){
        int[] map={0,0,0};
        int left=0,right=0;
        int n=str.length();
        int count=0;

        while(right<str.length()){
            char rch=str.charAt(right);
            map[rch-'a']++;
            
            while(map[0]>=1 && map[1]>=1 && map[2]>=1){
                count += n-right;
                char lch=str.charAt(left);
                map[lch-'a']--;
                left++;
            }
            right++;
        }
        return count;
    }
    static int numberOfSubstringsBest(String str){
        int[] lastOccr={-1,-1,-1};
        int count=0;

        for(int i=0;i<str.length();i++){
            lastOccr[str.charAt(i)-'a']=i;
            if(lastOccr[0]!=-1 && lastOccr[1]!=-1 && lastOccr[2]!=-1){
                count += Math.min(Math.min(lastOccr[0],lastOccr[1]),lastOccr[2])+1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str="abcabc";
        int count=numberOfSubstringsBest(str);
        System.out.println(count);
    }
}