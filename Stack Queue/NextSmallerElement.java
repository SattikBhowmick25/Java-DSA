import java.util.Stack;

public class NextSmallerElement {
    public static int[] prevSmaller(int[] A) {
        int n=A.length;
        Stack<Integer> st=new Stack<>();
        int[] G=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>=A[i]){
                st.pop();
            }
            G[i]=st.isEmpty()?-1:st.peek();
            st.push(A[i]);
        }
        return G;
    }
}
