import java.util.ArrayList;

public class SumDigits {
    public static void main(String[] args) {
        int[] a={9,9,9},b={};
        ArrayList<Integer> nums=sumOfArrays(a,b);
        System.out.print("The sum is:");
        for(Integer num:nums){
            System.out.print(num);
        }
    }
    
    static ArrayList<Integer> sumOfArrays(int[] a,int[] b){
        int i=a.length-1;
        int j=b.length-1;
        int carry=0,sum;
        //int maxLen=a.length>b.length?(a.length+1):(b.length+1);
        //int k=maxLen-1;
        ArrayList<Integer> sumArray=new ArrayList<>();
        //int[] sumArr=new int[maxLen];

        while(i>=0 && j>=0){
            sum=a[i]+b[j]+carry;
            
            carry=sum/10;
            sum%=10;
            sumArray.add(0,sum);
            i--;
            j--;
        }

        //Case 1
        while(i>=0){
            sum=a[i]+carry;

            carry=sum/10;
            sum%=10;
            sumArray.add(0,sum);
            i--;
        }
        //Case 2
        while(j>=0){
            sum=b[j]+carry;

            carry=sum/10;
            sum%=10;
            sumArray.add(0,sum);
            j--;
        }
        if(carry>0)
        sumArray.add(0,carry);
        return sumArray;
    }
    
}
