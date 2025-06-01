public class IsomorphicStrings {
    static boolean isIsomorphic(String s, String t){
        int[] indexS = new int[256]; 
        int[] indexT = new int[256];
        
        if(s.length() != t.length()) {
            return false;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                return false; 
            }
            
            
            indexS[s.charAt(i)] = i + 1; 
            indexT[t.charAt(i)] = i + 1; 
        }
        
        return true;
    }
}
