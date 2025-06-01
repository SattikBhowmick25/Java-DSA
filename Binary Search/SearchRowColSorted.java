import java.util.Arrays;

public class SearchRowColSorted {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},
                         {2,5,8,12,19},
                         {3,6,9,16,22},
                         {10,13,14,17,24},
                         {18,21,23,26,30}};
        int[] ans = searchMatrix(matrix, 14);
        System.out.println(Arrays.toString(ans));
    }
    static int[] searchMatrix(int[][] matrix,int target){
        int n=matrix.length;
        int m=matrix[0].length;
        int row=0,col=m-1;

        while(row<n && col>=0){
            if(matrix[row][col]==target)        return new int[]{row,col};
            else if(matrix[row][col] > target)  col--;
            else                                row++;   
        }
        return new int[]{-1,-1};
    }
}
