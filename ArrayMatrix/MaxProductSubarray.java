public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr={2,3,-2,4};
        int maxProduct=maxProductSubarray(arr);
        System.out.println(maxProduct);
    }
    static int maxProductSubarray(int[] arr){
        int n=arr.length;
        int pref=1,suff=1;
        int max=-9999;

        for(int i=0;i<n;i++){
            if(pref==0) pref=1;
            if(suff==0) suff=1;

            pref *= arr[i];
            suff *= arr[n-1-i];

            max=Math.max(max, Math.max(pref,suff));
        }

        return max;
    }
}
