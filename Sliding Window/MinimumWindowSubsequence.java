public class MinimumWindowSubsequence{
    static String minWindowSub(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int left,right = 0;
        int minLen = Integer.MAX_VALUE;
        String minSubsequence="";

        if(n==0 || m==0)    return "";

        while(right<n){
            int tIdx=0;
            while(right<n){
                if(s1.charAt(right)==s2.charAt(tIdx)){
                    tIdx++;
                }
                if (tIdx==m) {
                    break;
                }
                right++;
            }
            if(right==n)    return "";

            left=right;
            tIdx=m-1;
            while (tIdx>=0) {
                if(s1.charAt(left)==s2.charAt(tIdx)){
                    tIdx--;
                }
                if(tIdx<0)  break;
                left--;
            }
            if(right-left+1<minLen){
                minLen=right-left+1;
                minSubsequence=s1.substring(left, right+1);
            }
            right=left+1;
        }
        return minSubsequence;
    }
    public static void main(String[] args) {
        String s1="abcdebddebde",s2="bde";
        String minWindow=minWindowSub(s1, s2);
        System.out.println(minWindow);
    }    
}