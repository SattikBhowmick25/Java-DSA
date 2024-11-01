import java.util.Stack;

public class StackImpQ {
    Stack<Integer> input;
    Stack<Integer> output;
    public StackImpQ() {
        input=new Stack<>();
        output=new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(output.empty()){
            while(!input.empty()){
                output.push(input.peek());
                input.pop();
            }
        }
        int x=output.peek();
        output.pop();
        return x;
    }
    
    public int peek() {
        if(output.empty()){
            while(!input.empty()){
                output.push(input.peek());
                input.pop();
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.size()+output.size()==0;
    }
}
