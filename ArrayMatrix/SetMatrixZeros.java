import java.util.Arrays;

public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] mat={{1,1,1,1},
                    {1,0,0,1},
                    {1,1,0,1},
                    {1,1,1,1},
                    };
        
        setMatrixZeros2(mat);
        System.out.println(Arrays.toString(mat[0]));
        System.out.println(Arrays.toString(mat[1]));
        System.out.println(Arrays.toString(mat[2]));
        System.out.println(Arrays.toString(mat[3]));

    }

    static void setMatrixZeros(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    markRow(mat,i,m);
                    markCol(mat,j,n);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==-1){
                    mat[i][j]=0;
                }
            }
        }
    }

    static void markRow(int[][] mat,int row,int m){
        for(int i=0;i<m;i++){
            if(mat[row][i]!=0){
                mat[row][i]=-1;
            }
        }
    }
    static void markCol(int[][] mat,int col,int n){
        for(int i=0;i<n;i++){
            if(mat[i][col]!=0){
                mat[i][col]=-1;
            }
        }
    }


    //Better solution
    static void setMatrixZeros1(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        int[] col=new int[m];
        int[] row=new int[n];
        
        // Initializing row and col arrays
        for(int i=0;i<n;i++){
            row[i]=0;
        }
        for(int j=0;j<m;j++){
            col[j]=0;
        }

        //Marking the zeros
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        //Making the rows and cols zeros
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1 || col[j]==1){
                    mat[i][j]=0;
                }
            }
        }
    }

    //Optimal Solution
    static void setMatrixZeros2(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        int col0=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    //mark the i-th row
                    mat[i][0]=0;

                    //mark the i-th column
                    if(j!=0)
                        mat[0][j]=0;
                    else
                        col0=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][0]==0 || mat[0][j]==0){
                    mat[i][j]=0;
                }
            }
        }

        if(mat[0][0]==0){
            for(int j=0;j<m;j++)
                mat[0][j]=0;   
        }
        if(col0==0){
            for(int i=0;i<n;i++)
                mat[i][0]=0;
        }
    }
}
