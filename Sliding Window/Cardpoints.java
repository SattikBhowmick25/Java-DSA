public class Cardpoints {
    static int maxScore(int[] cardPoints,int k){
        int maxSum=0;
        int lSum=0,rSum=0;
        int rIndex=cardPoints.length-1;

        for(int i=0;i<k;i++){
            lSum += cardPoints[i];
        }
        maxSum = lSum;

        for(int i=k-1;i>=0;i--){
            lSum -= cardPoints[i];
            rSum += cardPoints[rIndex];
            maxSum = Math.max(maxSum, lSum+rSum);
            rIndex--;
        }
        return maxSum;
    }
    static int maxPoints(int[] cardPoints,int k){
        int n=cardPoints.length;
        int left=n-k;
        int right=n-1;
        int maxSum=0;
        int sum=0;
        for(int i=left;i<=right;i++)    sum+=cardPoints[i];
        maxSum=sum;

        while(k>0){
            sum -= cardPoints[left];
            left = (left+1)%n;
            right = (right+1)%n;
            sum += cardPoints[right];
            maxSum=Math.max(maxSum,sum);
            k--;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] cardPoints={1,2,3,4,5,6,1};
        // int score=maxScore(cardPoints, 3);
        int score1=maxPoints(cardPoints, 3);
        System.out.println(score1);
    }
}
