public class MatrixRotation{
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},
                        {4,5,6},
                        {7,8,9}}; 
                        
        int[][] matrix1={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}}; 
        int[][] ans=rotateMatrix(matrix);

        displayMatrix(matrix1);   
        //System.out.println();
        //displayMatrix(ans);

        rotateMatrix1(matrix1);
        displayMatrix(matrix1);
    }

    static int[][] rotateMatrix(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] ans=new int[m][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j][n-1-i]=matrix[i][j];
            }
        }
        return ans;
    }

    static void rotateMatrix1(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
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