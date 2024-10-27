import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1},
                        {2},
                        {3}
                        };
                        
        int[] ans=spiralMatrix(matrix);
        displayMatrix(matrix);
        System.out.println(Arrays.toString(ans));
    }

    // Spiral traversal of an [n x m]-matrix
    static int[] spiralMatrix(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0, bottom=n-1;
        int left=0, right=m-1;
        int[] ans=new int[n*m];
        int k=0;

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ans[k++]=matrix[top][i];
            }
            top++;

            for(int i=top;i<=bottom;i++){
                ans[k++]=matrix[i][right];
            }
            right--;

            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans[k++]=matrix[bottom][i];
                }
                bottom--;
            }

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans[k++]=matrix[i][left];
                }
                left++;
            }
        }

        return ans;
    }

    static void displayMatrix(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;

        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
