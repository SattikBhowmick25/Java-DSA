import java.util.Arrays;

public class SJF {
    static int sjf(int bt[] ) {
        int carry=0;
        int totalWait=0;
        int n=bt.length;
        Arrays.sort(bt);
        for(int i=0;i<n-1;i++){
            carry=carry+bt[i];
            totalWait=totalWait+carry;
        }
        return totalWait/n;
    }
}
