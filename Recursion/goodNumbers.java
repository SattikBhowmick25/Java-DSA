public class goodNumbers {
    static long calcGood(long base, long exp){
        long MOD=1000000007;
        long result=1;
        while(exp>0){
            if(exp%2==1)
            result = (result*base) % MOD;
            base = (base*base) % MOD;
            exp/=2;
        }
        return result;
    }
    static int countGoodNumbers(long n) {
        long MOD=1000000007;
        long even = (n+1)/2;
        long odd = n/2;
        long ans1 = calcGood(5,even);
        long ans2 = calcGood(4,odd);
        return (int)((ans1*ans2) % MOD); 
    }
}
