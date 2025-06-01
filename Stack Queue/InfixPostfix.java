import java.util.Stack;

public class InfixPostfix {
    static int prec(char ch) {
        switch (ch) {
        case '+':
        case '-':
          return 1;
    
        case '*':
        case '/':
        case '%':
          return 2;
    
        case '^':
          return 3;
        }
        return -1;
    }
    public static String infixToPostfix(String exp) {
        Stack<Character> stack=new Stack<>();
        String postf="";
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c))
                postf += c;
            else if(c=='(')
                stack.push(c);
            else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    postf += stack.pop();
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && prec(c) <= prec(stack.peek())){
                    postf += stack.pop();
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            if (stack.peek() == '(')
                return "Invalid Expression";

            postf += stack.pop();
        }
        return postf;
    }
}