import java.util.ArrayList;
import java.util.Collections;

public class SubsetSumAsc {
    public void subsetSumshelper(int ind,int sum,int[] arr,int n,ArrayList<Integer> sumList){
        if(ind==n){
            sumList.add(sum);
            return;
        }
        //pick
        subsetSumshelper(ind+1, sum+arr[ind], arr, n, sumList);

        //not pick
        subsetSumshelper(ind+1, sum, arr, n, sumList);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> sumList=new ArrayList<>();
        subsetSumshelper(0, 0, arr, arr.length, sumList);
        Collections.sort(sumList);
        return sumList;
    }
}
