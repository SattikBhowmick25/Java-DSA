import java.util.ArrayList;
import java.util.List;

public class Divisors {
    public static List<Integer> findDivisors(int n){
        List<Integer> div=new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                div.add(i);
                if(n/i != i)
                    div.add(n/i);
            }
        }
        return div;
    }        
    public static void main(String[] args) {
        List<Integer> ans=findDivisors(68);
        for(int f:ans){
            System.out.print(f+" ");
        }
        
    }
}

