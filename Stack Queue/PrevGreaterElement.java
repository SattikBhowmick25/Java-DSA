import java.util.Arrays;
import java.util.Stack;

public class PrevGreaterElement {
    static int[] findPGE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] pge=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        return pge;
    }
    public static void main(String[] args) {
        int[] arr={10,2,6,7,3,2,10};
        int[] pse=findPGE(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(pse));
    }
}
