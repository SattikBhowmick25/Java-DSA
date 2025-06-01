import java.util.Stack;

public class PrefixInfix{
    public static String prefixInfix(String prefix){
        Stack<String> st=new Stack<>();

        for(int l=prefix.length()-1;l>=0;l--){
            char c=prefix.charAt(l);
            if( (c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9') ){
                st.push(Character.toString(c));
            }
            else{
                String op1=st.peek();   st.pop();
                String op2=st.peek();   st.pop();
                String s='(' + op1 + c + op2 + ')';
                st.push(s);
            }
        }
        return st.peek();
    }
}