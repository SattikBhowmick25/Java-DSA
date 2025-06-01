public class OutermostParentheses{
    static String removeOuterParentheses(String s){
        String ans="";
        int balance=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(balance>0){
                    ans += s.charAt(i);
                }
                balance++;
            }
            else if(s.charAt(i)==')'){
                balance--;
                if(balance>0){
                    ans += s.charAt(i);
                }
            }
            else{
                continue;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="(()())(())";
        String ans=removeOuterParentheses(s);
        System.out.println(ans);
    }
}