import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval{
    int start;
    int end;
    int pos;
    Interval(int s,int e,int p){
        start=s;
        end=e;
        pos=p;
    }
}
class CompareIntervals implements Comparator<Interval>{
    @Override
    public int compare(Interval m1,Interval m2){
        if(m1.end<m2.end)   return -1;
        else if(m1.end>m2.end) return 1;
        else if(m1.pos<m2.pos)  return -1;
        else    return 1;
    }
}
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        ArrayList<Interval> inter=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int n=intervals.length;
        for(int i=0;i<n;i++){
            inter.add(new Interval(intervals[i][0],intervals[i][1],i+1));
        }
        CompareIntervals cmp=new CompareIntervals();
        Collections.sort(inter,cmp);
        
        ans.add(inter.get(0).pos);
        int limit=inter.get(0).end;
        for(int i=1;i<n;i++){
            if(inter.get(i).start>=limit){
                ans.add(inter.get(i).pos);
                limit=inter.get(i).end;
            }
        }
        return n-ans.size();

    }
}