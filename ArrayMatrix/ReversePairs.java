import java.util.ArrayList;

public class ReversePairs {
    public static void main(String[] args) {
        int[] arr={40,25,19,12,9,6,2};
        int count=mergeSort(arr, 0, arr.length-1);
        System.out.println(count);
    }
    
    static void merge(int[] arr,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        ArrayList<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
    }
    static int countRevPairs(int[] arr,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        int count=0;
        for(int i=left;i<=mid;i++){
            while(right<=high && arr[i]>2*arr[right]){
                right++;
            }
            count+=(right-(mid+1));
        }
        return count;
    }
    static int mergeSort(int[] arr,int low,int high){
        int count=0;
        if(low>=high)   return count;

        int mid=low+(high-low)/2;
        count+=mergeSort(arr, low, mid);
        count+=mergeSort(arr, mid+1, high);
        count+=countRevPairs(arr, low, mid, high);
        merge(arr, low, mid, high);

        return count;
    }
}
