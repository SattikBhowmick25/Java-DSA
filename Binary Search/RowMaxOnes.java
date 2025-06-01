public class RowMaxOnes{
    public static void main(String[] args) {
        int[][] mat={{0,1,1,1},
                     {0,0,0,1},
                     {0,0,1,1},
                     {1,1,1,1}};
        int row=findRow(mat);
        int ones=lowerBound(mat[2], 1);
        System.out.println(row);
    }
    static int lowerBound(int[] arr,int x){
        int index=-1;
        int low=0,high=arr.length-1;

        if(arr[arr.length-1]<x)     return arr.length;
        
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                index=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return index;
    }
    static int findRow(int[][] mat){
        int row=-1;
        int maxOnes=0;
        for(int i=0;i<mat.length;i++){
            int ones=mat[i].length-lowerBound(mat[i], 1);
            if(maxOnes<ones){
                maxOnes=ones;
                row=i;
            }
        }
        return row;
    }
}