import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={2,10,5,20,1,2,3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        int flag=1;
        for(int i=0;i<arr.length-1 && flag==1;i++){
            flag=0;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    flag=1;
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
