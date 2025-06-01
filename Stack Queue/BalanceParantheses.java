import java.util.Stack;

public class BalanceParantheses{
    static boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='[')  stk.push(c);
            else{
                if(stk.isEmpty())   return false;
                switch(c){
                    case ')':   if(stk.peek()=='(')
                                    stk.pop();
                                else    return false;
                                break;
                    case '}':   if(stk.peek()=='{')
                                    stk.pop();
                                else    return false; 
                                break;  
                    case ']':   if(stk.peek()=='[')
                                    stk.pop();
                                else    return false;         
                                break;
                }
            }
        }
        return stk.isEmpty();
    }
}