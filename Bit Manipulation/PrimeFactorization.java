import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public List<List<Integer>> primeFactors(int[] queries) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            List<Integer> list=getPrimeFactorization(queries[i]);
            ans.add(list);
        }
        return ans;
    }
    public static List<Integer> getPrimeFactorization(int n){
        List<Integer> ans=new ArrayList<>();
        for(int i=2;i*i<n;i++){
            if(n%i==0){
                while(n%i==0){
                    ans.add(i);
                    n=n/i;
                }
            }
        }
        if(n>1) ans.add(n);
        return ans;
    }
}
