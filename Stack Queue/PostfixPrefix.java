import java.util.Stack;

public class PostfixPrefix {
    public static String oostfixPrefix(String postfix){
        Stack<String> st=new Stack<>();
        for(int i=0;i<postfix.length();i++){
            char c=postfix.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                st.push(Character.toString(c));
            }
            else{
                String t1=st.pop();
                String t2=st.pop();
                String s=c+t2+t1;
                st.push(s);
            }
        }
        return st.peek();
    }
}
