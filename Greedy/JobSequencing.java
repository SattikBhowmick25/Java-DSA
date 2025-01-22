import java.util.ArrayList;
import java.util.Arrays;
class Job{
    int id;
    int deadline;
    int profit;
    Job(int id,int deadline,int profit){
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
public class JobSequencing {
    
    public ArrayList<Integer> jobSequencing(int[] id, int[] deadline, int[] profit) {
        int n=id.length;
        Job[] arr=new Job[n];
        for(int i=0;i<n;i++){
            arr[i]=new Job(id[i],deadline[i],profit[i]);
        }
        Arrays.sort(arr,(a,b)->b.profit-a.profit);
        int maxIndex=0;
        for(int i=0;i<n;i++){
            if(maxIndex<arr[i].deadline){
                maxIndex=arr[i].deadline;
            }
        }
        int[] slots=new int[maxIndex+1];
        for(int i=0;i<=maxIndex;i++){
            slots[i]=-1;
        }
        int count=0;
        int maxProfit=0;
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(slots[j]==-1){
                    count++;
                    maxProfit+=arr[i].profit;
                    slots[j]=arr[i].id;
                    break;
                }
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        result.add(count);
        result.add(maxProfit);
        return result;
    }
}
