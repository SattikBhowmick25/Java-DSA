import java.util.Stack;

public class SumSubarrayMin {
    public static int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] nse=findNSE(arr);
        int[] psee=findPSEE(arr);
        int total=0;
        int mod=(int)(1e9+7);
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total=(total+(left*right*arr[i]))%mod;
        }
        return total;
    }
    //Finds the next smaller element's index
    public static int[] findNSE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] nse=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    //Finds the previous smaller or equal element's index
    public static int[] findPSEE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] psee=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            psee[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return psee;
    }
}
