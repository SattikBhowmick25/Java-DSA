import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Meeting{
    int start;
    int end;
    int pos;
    Meeting(int s,int e,int p){
        start=s;
        end=e;
        pos=p;
    }
}
class CompareMeetings implements Comparator<Meeting>{
    @Override
    public int compare(Meeting m1,Meeting m2){
        if(m1.end<m2.end)   return -1;
        else if(m1.end>m2.end) return 1;
        else if(m1.pos<m2.pos)  return -1;
        else    return 1;
    }
}
public class MaxMeetings {
    static int maxMeetings(int start[],int end[]){
        ArrayList<Meeting> meet=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int n=start.length;
        for(int i=0;i<n;i++){
            meet.add(new Meeting(start[i],end[i],i+1));
        }
        CompareMeetings cmp=new CompareMeetings();
        Collections.sort(meet,cmp);
        
        ans.add(meet.get(0).pos);
        int limit=meet.get(0).end;
        for(int i=1;i<n;i++){
            if(meet.get(i).start>limit){
                ans.add(meet.get(i).pos);
                limit=meet.get(i).end;
            }
        }
        return ans.size();
    }
}
