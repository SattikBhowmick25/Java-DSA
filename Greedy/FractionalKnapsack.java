import java.util.*;

public class FractionalKnapsack{
    class Item {
        int value, weight;
        Item(int x, int y) {
          this.value = x;
          this.weight = y;
        }
    }
      
    class ItemComparator implements Comparator<Item>
    {
        @Override
        public int compare(Item a, Item b) 
        {
            double r1 = (double)(a.value) / (double)(a.weight); 
            double r2 = (double)(b.value) / (double)(b.weight); 
            if(r1 < r2) return 1; 
            else if(r1 > r2) return -1; 
            else return 0; 
        }
    }
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        Item arr[]= new Item[val.size()];
        for(int i=0;i<val.size();i++){
            arr[i]=new Item(val.get(i),wt.get(i));
        }
        Arrays.sort(arr, new ItemComparator()); 
        
        int n=val.size();
        int curWeight = 0; 
        double finalvalue = 0.0; 
        
        for (int i = 0; i < n; i++) {
       
            if (curWeight + arr[i].weight <= capacity) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }
     
            else {
                int remain = capacity - curWeight;
                finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
     
        return finalvalue;
        
    }
}