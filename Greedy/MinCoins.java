public class MinCoins {
    public int minCoins(int coins[], int sum) {
        int count=0;
        int remain=sum;
        for(int i=0;i<coins.length && remain>0;i++){
            count += remain/coins[i];
            remain=remain%coins[i];
        }
        if(remain!=0)   return -1;
        else return count;
    }
}
