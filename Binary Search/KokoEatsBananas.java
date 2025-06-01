public class KokoEatsBananas {
    public static void main(String[] args) {
        int[] arr={3,6,7,11};
        int minRate=minimumRateOfEating(arr, 8);
        System.out.println(minRate);
    }
    static int findMax(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    static int findTotalHours(int[] arr,int rate){
        int totalHours=0;
        for(int i=0;i<arr.length;i++){
            totalHours+=Math.ceil((double)arr[i]/(double)rate);
        }
        return totalHours;
    }
    static int minimumRateOfEating(int[] arr,int limitHours){
        int low=1,high=findMax(arr);
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int totalHours=findTotalHours(arr, mid);
            if(totalHours>limitHours){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
}
