import java.util.Stack;

public class MinStack {
    class Pair{
        int val,min;
        Pair(int val,int min){
            this.val=val;
            this.min=min;
        }
    }
    Stack<Pair> st;
    public MinStack() {
       st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
            st.push(new Pair(val,val));
        else
            st.push(new Pair(val,Math.min(val,st.peek().min)));
    }
    
    public void pop() {
        if(!st.isEmpty())
            st.pop();
    }
    
    public int top() {
       if(!st.isEmpty()){
        return st.peek().val;
       }
       else 
            return -1;
    }
    
    public int getMin() {
       if(!st.isEmpty()){
            return st.peek().min; 
       }
       else return -1;
    }
}
