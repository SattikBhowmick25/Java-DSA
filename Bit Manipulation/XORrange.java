public class XORrange {
    public int findRangeXOR(int l, int r) {
        //your code goes here
        int lXor=findXOR(l-1);
        int rXor=findXOR(r);
        return lXor^rXor;

   }
   public int findXOR(int n){
       if(n%4==1)          return 1;
       else if(n%4==2)     return n+1;
       else if (n%4==3)    return 0;
       else                return n;
   }
}
