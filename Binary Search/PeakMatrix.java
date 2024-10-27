import java.util.Arrays;

public class PeakMatrix {
    public static void main(String[] args) {
        int[][] mat={{10,20,15},
                     {21,30,14},
                     {7,16,32}};
        int[] ans=findPeakGrid(mat);
        System.out.println(Arrays.toString(ans));
    }
    static int findMaxIndex(int[][] mat,int col){
        int maxElement=-1;
        int index=-1;
        int n=mat.length;
        for(int i=0;i<n;i++){
            if(mat[i][col]>maxElement){
                maxElement=mat[i][col];
                index=i;
            }
        }
        return index;
    }
    static int[] findPeakGrid(int[][] mat) {
        int m=mat[0].length;
        int low=0,high=m-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int row=findMaxIndex(mat, mid);
            
            int left=mid-1>=0?mat[row][mid-1]:-1;
            int right=mid+1<m?mat[row][mid+1]:-1;

            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row,mid};
            }
            else if(mat[row][mid] < left){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
