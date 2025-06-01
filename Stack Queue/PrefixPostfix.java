import java.util.Stack;

public class PrefixPostfix{
    public static String prefixPostfix(String prefix){
        Stack<String> st=new Stack<>();
        for(int l=prefix.length()-1;l>=0;l--){
            char c=prefix.charAt(l);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                st.push(Character.toString(c));
            }
            else{
                String t1=st.pop();
                String t2=st.pop();
                String s=t1+t2+c;
                st.push(s);
            }
        }
        return st.peek();
    }
}