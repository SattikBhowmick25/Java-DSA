public class Power {
    static double myPow(double x, int n) {
        if(n==0)    return 1;
        if(n<0){
            return myPow(x, n+1)/x;
        }
        else{
            return x*myPow(x,n-1);
        }
    }
    public static void main(String[] args) {
        double num=5;
        System.out.println(myPow(num, 2));
    }
}
