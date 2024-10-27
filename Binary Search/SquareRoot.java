public class SquareRoot {
    public static void main(String[] args) {
        int num=-1;
        int sqrt=squareRoot(num);
        System.out.println("Number : "+num+"\t Square Root : "+sqrt);
    }
    static int squareRoot(int num){
        int low=1,high=num;
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            long square=mid*mid;
            if(square<=num){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
}
