public class Power {
    public static double myPow(double x, int n) {
        double ans = 1;
        long p = n; 
        if (p < 0) {
            x = 1 / x;
            p = -p; 
        }
        while (p > 0) {
            if (p % 2 == 1) {
                ans *= x;
            }
            x *= x;
            p /= 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int x=2,n=-2;
        System.out.println(x+"^"+n+" = "+myPow(x, n));
    }
}
