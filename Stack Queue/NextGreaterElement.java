import java.util.Stack;

public class NextGreaterElement {
    static int[] findNGE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty())
                nge[i]=-1;
            else   
                nge[i]=st.peek();
            st.push(arr[i]);
        }
        return nge;
    }
    static int findMatch(int key,int[] arr){
        for(int i=0;i<arr.length;i++){
            if(key==arr[i]) {
                return i;
            }
        }
        return -1;
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge2=findNGE(nums2);
        int[] nge1=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int index=findMatch(nums1[i], nums2);
            nge1[i]=nge2[index];
        }
        return nge1;
    }
}
