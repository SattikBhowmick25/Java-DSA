import java.util.Stack;

public class Histogram {
    public int largestRectangleArea(int[] arr) {
        int maxArea = 0;
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
    public int largestRectangleArea1(int[] height){
        int maxArea=0;
        int n=height.length;
        Stack<Integer> st=new Stack<>();
        int pse,nse;
        int element=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && (i==n || height[st.peek()] > height[i]) ){
                element=st.peek();
                st.pop();
                nse=i;
                pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max(maxArea, height[element]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            nse=n;
            element=st.peek();
            st.pop();
            pse=st.isEmpty()?-1:st.peek();
            maxArea=Math.max(maxArea,(nse-pse-1)*height[element]);
        }
        return maxArea;
    }
}
