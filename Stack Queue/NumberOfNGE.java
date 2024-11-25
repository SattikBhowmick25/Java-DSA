public class NumberOfNGE {
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int[] nge=new int[queries];
        for(int i=0;i<queries;i++){
            int index=indices[i];
            int count=0;
            for(int j=index;j<arr.length;j++){
                if(arr[index]<arr[j])   count++;
            }
            nge[i]=count;
        }
        return nge; 
    }
}
