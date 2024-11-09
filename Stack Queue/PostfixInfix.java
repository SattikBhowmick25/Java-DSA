import java.util.Stack;

public class PostfixInfix {
    static String postToInfix(String exp) {
        Stack<String> stack=new Stack<>();
        String prefix="";
        for(int i=0;i<exp.length();i++){
            String c=Character.toString(exp.charAt(i));
            if(Character.isLetterOrDigit(exp.charAt(i))){
                stack.push(c);
            }
            else{
                prefix="";
                String op1=stack.pop();
                String op2=stack.pop();
                prefix += '(' + op2 + c + op1 + ')'; 
                stack.push(prefix);
            }
        }
        return prefix;
    }
}
