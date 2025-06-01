import java.util.Arrays;

public class SieveOfEratosthenes{
    public static int countPrimes(int n) {
        int count=0;
        boolean[] prime=new boolean[n];

        //initializing the array with ones
        for(int i=2;i<n;i++){
            prime[i]=true;
        }

        //Marking the multiples of the prime numbers with 0
        for(int i=2;i*i<n;i++){
            if(i>2 && i%2==0)   prime[i]=false;
            else if(prime[i]==true){
                for(int j=i*i;j<n;j+=i){
                    prime[j]=false;
                }
            }
        }
        
        //Counting the indexes marked with 1
        for(int i=2;i<n;i++){
            if(prime[i]==true)     count++;
        }
        
        return count;
    }
    public static void main(String[] args) {
        int n=10;
        System.out.println(countPrimes(n));
    }
}