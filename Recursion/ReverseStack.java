import java.util.Stack;

public class ReverseStack {
    static void insertAtBottom(Stack<Integer> s,int x){
        if(s.isEmpty()){
            s.push(x);
            return;
        }
        else{
            int y=s.peek();
            s.pop();
            insertAtBottom(s,x);
            s.push(y);
        }
    }
    static void reverse(Stack<Integer> s)
    {
       if(s.size()>0){
           int x=s.peek();
           s.pop();
           reverse(s);
           
           insertAtBottom(s,x);
       }
    }
}
