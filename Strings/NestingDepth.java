public class NestingDepth {
    static int maxDepth(String s) {
        int depth=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                depth++;
                max=Math.max(max,depth);
            }
            else if(s.charAt(i)==')'){
                depth--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s="(1+(2*3)+((8)/4))+1";
        int max=maxDepth(s);
        System.out.println(max);
    }
}
