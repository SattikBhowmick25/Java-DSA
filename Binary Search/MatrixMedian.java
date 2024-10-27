public class MatrixMedian {
    public static void main(String[] args) {
        int[][] mat={{1,4,9},
                     {2,5,6},
                     {3,7,8}};
        int[][] mat1={{1,3,9},
                      {2,2,4},
                      {1,3,5}};             
        int median=findMedian(mat1);
        System.out.println(median);
    }
    static int findMax(int[][] mat){
        int max=-9999;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j] > max){
                    max=mat[i][j];
                }
            }
        }
        return max;
    }
    static int findMin(int[][] mat){
        int min=9999;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j] < min){
                    min=mat[i][j];
                }
            }
        }
        return min;
    }
    static int upperBound(int[] arr,int x){
        int low=0,high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    static int countSmallEqual(int[][] mat,int x){
        int count=0;
        for(int i=0;i<mat.length;i++){
            int val=upperBound(mat[i], x);
            count += val;
        }
        return count;
    }
    static int findMedian(int[][] mat){
        int low=findMin(mat);
        int high=findMax(mat);
        int n=mat.length;
        int m=mat[0].length;

        while(low<=high){
            int mid=low+(high-low)/2;
            int count=countSmallEqual(mat, mid);

            if(count <= (n*m)/2){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
}
