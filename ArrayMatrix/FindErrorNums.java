public class FindErrorNums{
    static int[] findErrorNums(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i];
            if(arr[i]<arr.length && arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }

        for(int index=0;index<arr.length;index++){
            if(arr[index]!=index){
                return new int[]{arr[index],index+1};
            }
        }

        return new int[]{-1,-1}; 
    }

    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}