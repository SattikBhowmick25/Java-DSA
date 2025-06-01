import java.util.Arrays;

public class Cookies {
    public int findContentChildren(int[] g, int[] s) {
        int gLen=g.length;
        int sLen=s.length;
        int gIndex=0;
        int sIndex=0;

        Arrays.sort(g);
        Arrays.sort(s);
    
        while(gIndex<gLen && sIndex<sLen){
            if(g[gIndex]<=s[sIndex]){
                gIndex++;
            }
            sIndex++;
        }
        return gIndex;
    }
}
