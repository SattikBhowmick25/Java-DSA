import java.util.Stack;

public class InfixPrefix {
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
    public static String infixToPrefix(String exp) {
        Stack<Character> stack=new Stack<>();
        StringBuilder s=new StringBuilder();
        s.append(exp);
        s.reverse();
        exp=s.toString();
        char[] infix=exp.toCharArray();
        for(int i=0;i<infix.length;i++){
            if(infix[i]=='('){
                infix[i]=')';
            }
            else if(infix[i]==')'){
                infix[i]='(';
            }
        }
        exp=infix.toString();
        String prefix="";

        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c))
                prefix += c;
            else if(c=='(')
                stack.push(c);
            else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    prefix += stack.pop();
                }
                stack.pop();
            }
            else{
                if(c=='^'){
                    while(!stack.isEmpty() && prec(c) <= prec(stack.peek())){
                        prefix += stack.pop();
                    }
                }
                else{
                    while(!stack.isEmpty() && prec(c) < prec(stack.peek())){
                        prefix += stack.pop();
                    }
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            if (stack.peek() == '(')
                return "Invalid Expression";

            prefix += stack.pop();
        }
        s=new StringBuilder();
        s.append(prefix);
        s.reverse();
        prefix=s.toString();
        return prefix;
    }
}
