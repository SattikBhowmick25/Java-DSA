public class MissingNumber {
    static int missingNumber(int[] arr){
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

        //Search for first missing number 
        for(int index=0;index<arr.length;index++){
            if(arr[index]!=index){
                return index;
            }
        }

        //Case 2
        return arr.length;
    }

    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
