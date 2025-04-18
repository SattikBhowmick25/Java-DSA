import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static List<Integer> primeFactors1(int n){
        List<Integer> factors=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(n%i==0){
                factors.add(i);
                while(n%i==0){
                    n=n/i;
                }
            }
        }
        return factors;
    }
    public static List<Integer> primeFactors2(int n){
        List<Integer> factors=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                factors.add(i);
                while(n%i==0){
                    n=n/i;
                }
            }
        }
        if(n!=1)    factors.add(n);
        return factors;
    }
    public static void main(String[] args) {
        List<Integer> factors=primeFactors2(420);
        for(int f:factors){
            System.out.print(f+" ");
        }
    }
}
