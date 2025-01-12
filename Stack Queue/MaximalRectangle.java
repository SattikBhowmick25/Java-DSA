import java.util.Stack;

public class MaximalRectangle {
    public int largestRectangleArea(int[] height){
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
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxArea=0;
        int pSum[][]=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=(matrix[i][j]-'0');
                if(matrix[i][j]=='0'){
                    sum=0;
                }
                pSum[i][j]=sum;
            }
        }
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,largestRectangleArea(pSum[i]));
        }
        return maxArea;
    }
}
