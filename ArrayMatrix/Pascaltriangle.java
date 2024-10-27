import java.util.Arrays;

public class Pascaltriangle {
    public static void main(String[] args) {
        int n=2,r=1;
        int ncr=find_nCr(n, r);
        System.out.println(ncr);

        int row=2;
        int[] ans=pascalRow(6);
        System.out.println(Arrays.toString(ans));
    }

    static int find_nCr(int n,int r){
        int ans=1;
        for(int i=0;i<r;i++){
            ans*=(n-i);
            ans/=(i+1);
        }
        return ans;
    }
    static int[] pascalRow(int n){
        int[] ans=new int[n];
        int res=1;
        ans[0]=res;
        for(int i=1;i<n;i++){
            res=res*(n-i);
            res=res/i;
            ans[i]=res;
        }
        return ans;
    }

}
