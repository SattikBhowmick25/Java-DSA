public class SetBitCount {
    public static int countSetBits(int n){
        if(n==0)    return 0;
        int count=0;
        while(n>1){
            count+=n&1;
            n=n>>1;
            if(n==1)    count++;          
        }
        return count;
    }
    public static void main(String[] args) {
        int n=15;
        System.out.println(countSetBits(n));
    }
}
