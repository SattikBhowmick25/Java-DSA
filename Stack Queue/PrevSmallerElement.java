import java.util.Arrays;
import java.util.Stack;

public class PrevSmallerElement {
    static int[] prevSmallerElement(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] pse=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(arr[i]);
        }
        return pse;
    }
    public static void main(String[] args) {
        int[] arr={10,2,6,7,3,2,10};
        int[] pse=prevSmallerElement(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(pse));
    }
}
