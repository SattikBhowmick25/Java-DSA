public class Shipment {
    public static void main(String[] args) {
        int[] weights={1,2,3,4,5,6,7,8,9,10};
        int days=daysRequired(weights, 8);
        int capacity=minimumCapacity(weights, 1);
        System.out.println(capacity);
    }
    static int minimumCapacity(int[] weights,int d){
        int low=max(weights),high=sumAll(weights);
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int days=daysRequired(weights, mid);
            if(days<=d){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    static int sumAll(int[] weights){
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
        }
        return sum;
    }
    static int max(int[] weights){
        int max=-9999;
        for(int i=0;i<weights.length;i++){
            if(max<weights[i])
                max=weights[i];
        }
        return max;
    }
    static int daysRequired(int[] weights,int capacity){
        int days=0;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(sum>capacity){
                sum=weights[i];
                days++;
            }
        }
        days++;
        return days;
    }
}
