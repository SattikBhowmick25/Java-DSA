import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        int len=num.length(),i;
        String str="",str1="";
        for(i=0;i<len;i++){
            char c=num.charAt(i);
            while(!stack.isEmpty() && k>0 && (c-'0')<(stack.peek()-'0')){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(k>=0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()){
            return "0";
        }
        while(!stack.isEmpty()){
            str=stack.pop()+str;
        }
        i=0;
        while(str.length()!=0 && str.charAt(i)=='0'){
            i++;
        }
        while(i<str.length()){
            str1=str1+str.charAt(i);
            i++;
        }
        if(str1.length()==0)    return "0";
        return str;
    }
}
