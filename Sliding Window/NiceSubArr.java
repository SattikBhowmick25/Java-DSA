public class NiceSubArr {
    static int countNiceLE(int[] arr,int k){
        int left=0,right=0;
        int countSub=0;
        int countOdd=0;
        if(k<0) return 0;
        while(right < arr.length){
            if(arr[right]%2 == 1)     countOdd++;
            while(countOdd > k){
                if(arr[left]%2 == 1)    countOdd--;
                left++;
            }
            countSub+=right-left+1;
            right++;
        }
        return countSub;
    }
    //Time-O(4*N)   Space-O(1)
    static int countNice(int[] arr,int k){
        return ( countNiceLE(arr, k)-countNice(arr, k-1));
    }
}
