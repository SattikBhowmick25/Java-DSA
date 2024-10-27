import java.util.ArrayList;;

public class CountInversions {
    public static void main(String[] args) {
        int[] arr={5,3,2,4,1};
        int count=mergeSort(arr, 0, arr.length-1);
        System.out.println(count);
    }
    static int merge(int[] arr,int low,int mid,int high){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low;
        int right=mid+1;
        int count=0;

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
                count+=(mid-left+1);
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
        return count;
    }
    static int mergeSort(int[] arr,int low,int high){
        int count=0;
        if(low>=high)   return count;
        int mid=low+(high-low)/2;
        count+=mergeSort(arr, low, mid);
        count+=mergeSort(arr, mid+1, high);
        count+=merge(arr, low, mid, high);
        return count;
    }
}
