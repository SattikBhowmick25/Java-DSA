import java.util.Arrays;

public class SearchSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,5},
                         {10,11,15},
                         {20,31,49},
                         {50,52,100}};
        int[] ans = searchMatrix(matrix, 31);
        System.out.println(Arrays.toString(ans));
    }
    static int[] searchMatrix(int[][] matrix,int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int low=0;
        int high=n*m-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col] == target){
                return new int[]{row,col};
            }
            else if(matrix[row][col] > target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
