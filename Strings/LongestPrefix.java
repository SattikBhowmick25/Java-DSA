public class LongestPrefix {
    static String longestCommonPrefix(String[] strs) {
        int minLen=Integer.MAX_VALUE;
        String pref="";
        for(int i=0;i<strs.length;i++){
            if(minLen>strs[i].length()){
                minLen=strs[i].length();
            }
        }   
        for(int i=0;i<minLen;i++){
            boolean flag=true;
            for(int j=0;j<strs.length-1;j++){
                if(strs[j].charAt(i)!=strs[j+1].charAt(i)){
                    flag=false;
                    break;
                }
            }
            if(flag)    pref+=strs[0].charAt(i);
            else    
                break;
        }
        return pref;
    }
}
